package com.example.lovecalculator.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.adapter.LoveAdapter
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.viewModel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private val viewModel: LoveViewModel by viewModels()
    private val adapter = LoveAdapter(this::onLongClick)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = viewModel.getAllLove()
        binding.recycler.adapter = adapter
        adapter.addLove(list)

    }
    private fun onLongClick(loveModel: LoveModel){

        var builder = AlertDialog.Builder(requireContext())

        builder.setTitle(getString(R.string.update_str))
            .setMessage(getString(R.string.do_you_want_to_update, loveModel.sname))
            .setCancelable(true)
            .setPositiveButton("Yes"){dialogInterface,it ->
                val action = HistoryFragmentDirections.actionHistoryFragmentToFirstFragment(loveModel)
                findNavController().navigate(action)
            }
            .setNegativeButton("No"){dialogInterface,it ->

            }
            .show()

    }
}