package com.udacity.shoestore.screens.shoeDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoesViewModel

class ShoeDetailFragment : Fragment() {

    private val viewModel : ShoesViewModel by activityViewModels()

    private val shoeData = Shoe("",  "",0.0, "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentShoeDetailBinding.inflate(inflater, container, false)

        binding.shoeDetailViewModel = viewModel
        binding.lifecycleOwner = this
        binding.shoeData = shoeData

        viewModel.cancelState.observe(viewLifecycleOwner, Observer { cancelState ->
            if (cancelState) {
                navigateToShoeListFragment()
                viewModel.onCancelComplete()
            }
        })

        viewModel.saveShoe.observe(viewLifecycleOwner, Observer { save ->
            if (save) {
                navigateToShoeListFragment()
                viewModel.onSaveComplete()
            }
        })

        return binding.root
    }

    private fun navigateToShoeListFragment() {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        findNavController().navigate(action)
    }

}