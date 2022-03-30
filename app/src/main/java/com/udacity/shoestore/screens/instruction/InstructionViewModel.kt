package com.udacity.shoestore.screens.instruction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionViewModel: ViewModel() {

    private val _showShoeList = MutableLiveData<Boolean>()
    val showShoeList: LiveData<Boolean>
        get() = _showShoeList

    fun showShoeList() {
        _showShoeList.value = true
    }

    fun onShoeShoeListComplete() {
        _showShoeList.value = false
    }
}