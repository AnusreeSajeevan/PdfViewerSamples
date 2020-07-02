package com.example.pdfviewersample

import androidx.databinding.ViewDataBinding

interface ItemClickCallback {
    fun onItemClick(iDataBindingModel : IDataBindingModel, itemViewBinding: ViewDataBinding)
}
