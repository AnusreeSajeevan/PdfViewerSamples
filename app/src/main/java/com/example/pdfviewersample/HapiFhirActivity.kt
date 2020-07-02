package com.example.pdfviewersample

import `in`.projecteka.jataayu.presentation.decorator.DividerItemDecorator
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pdfviewersample.databinding.ActivityHapiFhirBinding
import com.example.pdfviewersample.utils.KEY_DIAGNOSTIC_REPORT
import com.example.pdfviewersample.utils.Success
import com.example.pdfviewersample.utils.getData
import com.example.pdfviewersample.viewmodel.HapiFhirActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HapiFhirActivity : AppCompatActivity(), ItemClickCallback {

    lateinit var binding: ActivityHapiFhirBinding
    private var listItems: List<IDataBindingModel> = emptyList()
    private lateinit var genericRecyclerViewAdapter: GenericRecyclerViewAdapter

    val viewModel: HapiFhirActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@HapiFhirActivity, R.layout.activity_hapi_fhir)
        initBinding()
        initObservers()
//        initToolbar()
        viewModel.getAuthToken()

    }

//    private fun initToolbar() {
//        setSupportActionBar(binding.appToolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setDisplayShowHomeEnabled(true)
//        binding.appToolbar.setNavigationOnClickListener { onBackPressed() }
//    }

    private fun initObservers() {
        viewModel.healthDataResponse.observe(this, Observer {
            when (it) {
                is Success -> {
                    Log.d("HealthData", "" + it.data?.entries)
                    Log.d("entries", "" + getData(it.data?.entries, KEY_DIAGNOSTIC_REPORT))
                    Log.d("entries", "" + getData(it.data?.entries, KEY_DIAGNOSTIC_REPORT).size)

                    val listEntries = getData(it.data?.entries, "Observation")


                    val linkDataModels = arrayListOf<IDataBindingModel>()
                    listEntries.forEach { dataEntry ->
                        linkDataModels.add(dataEntry.resource)
                    }
                    listItems = linkDataModels
                    genericRecyclerViewAdapter = GenericRecyclerViewAdapter(listItems, this)
                    binding.rvReports.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = genericRecyclerViewAdapter
                        val dividerItemDecorator = DividerItemDecorator(
                            ContextCompat.getDrawable(
                                context!!,
                                android.R.color.transparent
                            )!!
                        )
                        addItemDecoration(dividerItemDecorator)
                    }
                }

            }
        })

        viewModel.authResponse.observe(this, Observer {
            when (it) {
                is Success -> {
                    viewModel.authToken.set(it.data?.accessToken)
                }
            }
        })
    }

    fun initBinding() {
        binding.viewModel = viewModel
    }

    override fun onItemClick(
        iDataBindingModel: IDataBindingModel,
        itemViewBinding: ViewDataBinding
    ) {
//        Toast.makeText(this, iDataBindingModel.dataBindingVariable()., Toast.LENGTH_SHORT).show()
    }
}
