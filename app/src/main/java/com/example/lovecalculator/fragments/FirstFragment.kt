package com.example.lovecalculator.fragments

import android.os.Bundle
import android.text.style.BulletSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.LoveView
import com.example.lovecalculator.Presenter
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), LoveView {

    private lateinit var binding: FragmentFirstBinding
    private val presenter = Presenter(this)
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
            presenter.getLove(binding.edFirstName.text.toString(), binding.edSecondName.text.toString())
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }

    }

    override fun showRespond(respond: String) {
        res = respond
    }
    override fun showError(error: String) {
        TODO()
    }
}