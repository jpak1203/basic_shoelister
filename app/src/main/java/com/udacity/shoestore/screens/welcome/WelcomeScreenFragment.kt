package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding
import com.udacity.shoestore.screens.login.LoginFragmentDirections
import com.udacity.shoestore.screens.login.LoginViewModel

class WelcomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeScreenBinding
    private lateinit var viewModel: WelcomeScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(WelcomeScreenViewModel::class.java)

        binding.welcomeScreenViewModel = viewModel

        viewModel.showInstructionScreen.observe(viewLifecycleOwner, Observer { showInstructionScreen ->
            if (showInstructionScreen) {
                val action = WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstructionFragment()
                NavHostFragment.findNavController(this).navigate(action)
                viewModel.onInstructionScreenComplete()
            }
        })

        return binding.root
    }
}