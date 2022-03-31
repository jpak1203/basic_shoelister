package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    private val _showWelcomeScreen = MutableLiveData<Boolean>()
    val showWelcomeScreen: LiveData<Boolean>
        get() = _showWelcomeScreen

    private val _showShoeListings = MutableLiveData<Boolean>()
    val showShoeListings: LiveData<Boolean>
        get() = _showShoeListings

    fun showWelcomeScreen() {
        _showWelcomeScreen.value = true
    }

    fun onWelcomeScreenComplete() {
        _showWelcomeScreen.value = false
    }

    fun showShoeListings() {
        _showShoeListings.value = true
    }

    fun onShoeListingsComplete() {
        _showShoeListings.value = false
    }
}