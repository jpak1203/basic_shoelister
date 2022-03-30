package com.udacity.shoestore.screens.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeScreenViewModel: ViewModel() {

    private val _showInstructionScreen = MutableLiveData<Boolean>()
    val showInstructionScreen: LiveData<Boolean>
        get() = _showInstructionScreen

    fun showInstructionScreen() {
        _showInstructionScreen.value = true
    }

    fun onInstructionScreenComplete() {
        _showInstructionScreen.value = false
    }
}