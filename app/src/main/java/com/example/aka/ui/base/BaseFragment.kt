package com.example.aka.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aka.R
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

        binding.buttonMagic.setOnClickListener {
            findNavController().navigate(R.id.navigation_elements)
        }

        binding.buttonPlaces.setOnClickListener {
            findNavController().navigate(R.id.navigation_stub)
        }

        binding.buttonPersonage.setOnClickListener {
            findNavController().navigate(R.id.navigation_stub)
        }

        binding.buttonArtefacts.setOnClickListener {
            findNavController().navigate(R.id.navigation_stub)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}