package com.udacity.shoestore.models

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoesViewModel :  ViewModel() {

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    private var _saveShoe = MutableLiveData<Boolean>()
    val saveShoe : LiveData<Boolean>
        get() = _saveShoe

    private var _cancelState = MutableLiveData<Boolean>()
    val cancelState : LiveData<Boolean>
        get() = _cancelState

    private var _shoeDetailsEvent = MutableLiveData<Boolean>()
    val shoeDetailsEvent: LiveData<Boolean>
        get() = _shoeDetailsEvent

    init {
        _shoeList.value = mutableListOf()
        _saveShoe.value = false
    }

    fun onShoeDetailsEvent() {
        _shoeDetailsEvent.value = true
    }

    fun onShoeDetailsEventComplete() {
        _shoeDetailsEvent.value = false
    }

    fun createShoe(name: String, company: String, size: Double, description: String) {
        _shoeList.value?.add(Shoe(name, company, size, description))
    }

    fun onSave() {
        _saveShoe.value = true
    }

    fun onSaveComplete() {
        _saveShoe.value = false
    }

    fun onCancel() {
        _cancelState.value = true
    }

    fun onCancelComplete() {
        _cancelState.value = false
    }

}