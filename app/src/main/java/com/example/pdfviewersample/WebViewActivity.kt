package com.example.pdfviewersample

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.pdfviewersample.databinding.ActivityWebViewBinding
import com.example.pdfviewersample.utils.getPdfUrl
import com.example.pdfviewersample.viewmodel.WebViewActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class WebViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityWebViewBinding

    val viewModel: WebViewActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@WebViewActivity, R.layout.activity_web_view)
        initBinding()
    }

    fun initBinding() {
        binding.viewModel = viewModel
        binding.webView.webViewClient = CustomWebViewClient()
        binding.webView.settings.setSupportZoom(true)
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://docs.google.com/gview?embedded=true&url=${getPdfUrl()}")
        Log.d("WebCheck", "" + binding.webView.settings.userAgentString)

        //set user agent
        //what is java script enabled

    }

    class CustomWebViewClient: WebViewClient() {
        override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?): Boolean {
            return true
        }

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            return false
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            view?.loadUrl("javascript:(function() { " +
                    "document.getElementsByClassName('ndfHFb-c4YZDc-GSQQnc-LgbsSe ndfHFb-c4YZDc-to915-LgbsSe VIpgJd-TzA9Ye-eEGnhe ndfHFb-c4YZDc-LgbsSe')[0].style.display='none'; })()");
        }
    }
}
