package com.example.aka

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aka.databinding.FragmentCharlistBinding
import com.example.aka.items.CharlistItem
import com.example.aka.items.MultiTypeAdapter


class CharlistFragment : Fragment() {
    private var _binding: FragmentCharlistBinding? = null
    private val binding get() = _binding!!


    val items = listOf(
        CharlistItem.Header("Первая таблица"),
        CharlistItem.TableItem("Сила", "12", "2"),
        CharlistItem.TableItem("Ловкость", "20", "10"),
        CharlistItem.Header("Навыки"),
        CharlistItem.Skill("Сила", "10"),
        CharlistItem.Skill("Ловкость", "15")
    )
    private val adapter = MultiTypeAdapter(items)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
