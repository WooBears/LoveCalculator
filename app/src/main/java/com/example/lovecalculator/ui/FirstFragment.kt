package com.example.lovecalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lovecalculator.App
import com.example.lovecalculator.viewModel.LoveViewModel
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentFirstBinding
import com.example.lovecalculator.model.LoveModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val args by navArgs<FirstFragmentArgs>()
    private val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {

            viewModel.getLiveData(binding.edFirstName.text.toString(), binding.edSecondName.text.toString())
                .observe(viewLifecycleOwner, Observer { love ->
                    viewModel.insertLove(love)
                    findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                })

        }

        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_historyFragment)
        }

        binding.button4.setOnClickListener {
            update()
            Toast.makeText(requireContext(), "Updated!!", Toast.LENGTH_SHORT).show()
        }

    }
    private fun update()
    {
        args.love.fname = binding.edFirstName.text.toString()
        args.love.sname = binding.edSecondName.text.toString()
        args.love.let { viewModel.updateLove(it) }

    }
}