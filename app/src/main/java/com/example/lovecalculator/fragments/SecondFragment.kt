package com.example.lovecalculator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lovecalculator.LoveView
import com.example.lovecalculator.Presenter
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentSecondBinding
import com.example.lovecalculator.model.LoveModel

class SecondFragment : Fragment(), LoveView{

    private lateinit var binding: FragmentSecondBinding
    private val presenter = Presenter(this)

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
        presenter.getLove(fname.toString(),sname.toString())
    }

    override fun showRespond(respond: String) {
        binding.tvRes.text = respond
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), "Error!", Toast.LENGTH_SHORT).show()
    }
}