package com.example.pdfviewersample

import android.Manifest
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.pdfviewersample.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    private fun displayPdfUsingDefaultApp() {
        try {
            startActivity(viewModel.displayPdfUsingDefaultApp())
        } catch (e: Exception) {
            Toast.makeText(this, "install app", Toast.LENGTH_SHORT).show()
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun checkPermission(view: View) {
        val result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        if (result == PackageManager.PERMISSION_GRANTED) {
            displayPdfUsingDefaultApp()
        } else {
            // User may have declined earlier, ask Android if we should show him a reason
            if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // show an explanation to the user
                // Good practise: don't block thread after the user sees the explanation, try again to request the permission.
            } else {
                // request the permission.
                // CALLBACK_NUMBER is a integer constants
                requestPermissions(arrayOf<String>(Manifest.permission.READ_EXTERNAL_STORAGE), 2000);
                // The callback method gets the result of the request.
            }
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(READ_EXTERNAL_STORAGE), 2000)
    }


    override fun onRequestPermissionsResult(requestCode : Int ,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        when (requestCode) {
            2000 -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, do your work....
                    displayPdfUsingDefaultApp()
                } else { // permission denied
                    // Disable the functionality that depends on this permission.
                }
                return
            }
        }
    }

}
