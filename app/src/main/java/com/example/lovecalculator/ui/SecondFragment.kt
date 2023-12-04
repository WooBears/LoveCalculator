package com.example.lovecalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.Repository
import com.example.lovecalculator.viewModel.LoveViewModel
import com.example.lovecalculator.databinding.FragmentSecondBinding
import com.example.lovecalculator.util.loadImage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment : Fragment(){

    private lateinit var binding: FragmentSecondBinding
    @Inject
    lateinit var repository: Repository
    private val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = viewModel.getAllLove()

        model.forEach {
            binding.tvRes.text = it.percentage
            binding.imageView3.loadImage("https://e7.pngegg.com/pngimages/631/6/png-clipart-couple-heart-heart-kiss-couple-love-red-love-kissing-couple-love-miscellaneous.png")
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}