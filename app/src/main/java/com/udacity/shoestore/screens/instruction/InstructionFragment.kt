package com.udacity.shoestore.screens.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding
    private lateinit var viewModel: InstructionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInstructionBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(InstructionViewModel::class.java)

        binding.instructionViewModel = viewModel

        viewModel.showShoeList.observe(viewLifecycleOwner, Observer { showShoeList ->
            if (showShoeList) {
                val action = InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment()
                NavHostFragment.findNavController(this).navigate(action)
                viewModel.onShoeShoeListComplete()
            }
        })

        return binding.root
    }
}