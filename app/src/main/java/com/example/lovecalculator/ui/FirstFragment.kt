package com.example.lovecalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.viewModel.LoveViewModel
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: LoveViewModel by viewModels()
    private var res: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = Bundle()
        binding.button2.setOnClickListener {
            bundle.putString("fname", binding.edFirstName.text.toString())
            bundle.putString("sname", binding.edSecondName.text.toString())

            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)

        }

    }

}