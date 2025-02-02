package com.example.aka.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aka.databinding.FragmentBaseBinding

class BaseFragment : Fragment() {
    private var _binding: FragmentBaseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBaseBinding.inflate(inflater, container, false)
        val view = binding.root

        // Access your views using binding
        binding.containerForButton.setOnClickListener {
            // Handle click on containerForButton
        }

        binding.buttonMagic.setOnClickListener {
            // Handle click on buttonMagic
        }

        binding.buttonPlaces.setOnClickListener {
            // Handle click on buttonPlaces
        }

        binding.buttonPersonage.setOnClickListener {
            // Handle click on buttonPersonage
        }

        binding.buttonArtefacts.setOnClickListener {
            // Handle click on buttonArtefacts
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}