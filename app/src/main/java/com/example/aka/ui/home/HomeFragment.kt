package com.example.aka.ui.home


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.aka.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.welcomeText.text = "Добро пожаловать в приложение Аркен_Хар!"
        binding.linkToLastMages.text = "Рассказ \"Последние маги\""
        binding.linkToRoman.text = "Роман \"Рубиновый Орден\" "

        fun onOpenRomanClick(view: View) {
            val url = "https://author.today/work/396815"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        fun onOpenLastClick(view: View) {
            val url = "https://www.litres.ru/book/darya-stal/poslednie-magi-70232329/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        return view
    }
}