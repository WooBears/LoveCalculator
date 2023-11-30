package com.example.lovecalculator.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentOnBoardingBinding
import com.example.lovecalculator.onBoarding.adapter.OnBoardingAdapter
import com.example.lovecalculator.viewModel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import me.relex.circleindicator.CircleIndicator3

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    private val adapter = OnBoardingAdapter(this::onCLick)
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewpager.adapter = adapter

        val viewPager2 = binding.viewpager

        val circleIndicator: CircleIndicator3 = binding.indicator
        circleIndicator.setViewPager(viewPager2)
    }

    private fun onCLick(){
        viewModel.onShowed()
        findNavController().navigateUp()
    }
}