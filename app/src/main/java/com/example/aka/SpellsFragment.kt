package com.example.aka

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aka.databinding.FragmentSpellsBinding
import com.example.aka.items.AccordionAdapter
import com.example.aka.items.AccordionItem
import org.json.JSONArray

class SpellsFragment : Fragment() {
    private var _binding: FragmentSpellsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpellsBinding.inflate(inflater, container, false)
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jsonResId = arguments?.getInt("jsonResId") ?: R.raw.spells
        val jsonString = loadJsonFromRaw(jsonResId)
        val items = parseJson(jsonString)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = AccordionAdapter(items)
    }

    private fun loadJsonFromRaw(jsonResId: Int): String {
        return try {
            resources.openRawResource(jsonResId)
                .bufferedReader()
                .use { it.readText() }
        } catch (e: Exception) {
            ""
        }
    }

    private fun parseJson(jsonString: String): List<AccordionItem> {
        return try {
            val jsonArray = JSONArray(jsonString)
            (0 until jsonArray.length()).map { i ->
                val jsonObject = jsonArray.getJSONObject(i)
                AccordionItem(
                    name = jsonObject.getString("name"),
                    description = jsonObject.getString("description")
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}