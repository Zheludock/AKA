package com.example.aka.ui.home


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aka.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.linkToRoman.setOnClickListener{
            onOpenRomanClick()
        }
        binding.linkToLastMages.setOnClickListener {
            onOpenLastClick()
        }
        return view
    }

    private fun onOpenRomanClick() {
        val url = "https://author.today/work/396815"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun onOpenLastClick() {
        val url = "https://www.litres.ru/book/darya-stal/poslednie-magi-70232329/"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}