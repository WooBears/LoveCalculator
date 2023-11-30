package com.example.lovecalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.lovecalculator.Repository
import com.example.lovecalculator.viewModel.LoveViewModel
import com.example.lovecalculator.databinding.FragmentSecondBinding
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
        val fname: String? = arguments?.getString("fname")
        val sname: String? = arguments?.getString("sname")
        viewModel.getLiveData(fname.toString(),sname.toString())
            .observe(viewLifecycleOwner, Observer {
                binding.tvRes.text = it?.percentage
            })
    }

}