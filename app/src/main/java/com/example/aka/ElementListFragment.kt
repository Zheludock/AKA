package com.example.aka

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.aka.databinding.FragmentElementListBinding


class ElementListFragment : Fragment() {
    private var _binding: FragmentElementListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentElementListBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        val imageJsonMap = mapOf(
            R.id.fire to R.raw.fire,
            R.id.ice to R.raw.ice,
            R.id.water to R.raw.water,
            R.id.curse to R.raw.curse,
            R.id.dark to R.raw.dark,
            R.id.death to R.raw.death,
            R.id.shadow to R.raw.shadow,
            R.id.light to R.raw.light,
            R.id.air to R.raw.air,
            R.id.earth to R.raw.earth,
            R.id.time to R.raw.time,
        )
        imageJsonMap.forEach { (viewId, jsonResId) ->
            view.findViewById<ImageView>(viewId).setOnClickListener {
                navigateToAccordion(jsonResId)
            }
        }


        return view
    }

    private fun navigateToAccordion(jsonResId: Int) {
        findNavController().navigate(
            R.id.action_elementListFragment_to_accordionFragment,
            Bundle().apply {
                putInt("jsonResId", jsonResId)
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}