package com.example.aka

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aka.databinding.FragmentElementListBinding
import com.example.aka.databinding.FragmentPlayBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


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

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}