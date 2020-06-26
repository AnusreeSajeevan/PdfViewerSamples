package com.example.pdfviewersample.utils

import android.view.View
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @BindingAdapter("app:toggledVisibility")
    @JvmStatic
    fun conditionalVisibility(view: View, shouldShow: Boolean) {
        if (shouldShow) view.visibility = View.VISIBLE else view.visibility = View.GONE
    }
}