package com.example.lovecalculator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.databinding.ItemLoveBinding
import com.example.lovecalculator.model.LoveModel

class LoveAdapter(
    private val onLongClick: (LoveModel) -> Unit
) : Adapter<LoveAdapter.LoveViewModel>() {

    private val list = arrayListOf<LoveModel>()
    fun addLove(love: List<LoveModel>){
        list.clear()
        list.addAll(love)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoveViewModel {
       return LoveViewModel(
           ItemLoveBinding.inflate(
               LayoutInflater.from(parent.context),
               parent,
               false))
    }
    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: LoveViewModel, position: Int) {
        holder.bind(list[position])
    }
    inner class LoveViewModel(private var binding: ItemLoveBinding): ViewHolder(binding.root){
        fun bind(loveModel: LoveModel){
            with(binding){
                tvFname.text = loveModel.fname
                tvSname.text = loveModel.sname
                tvResPercentage.text= loveModel.percentage
                tvItemRes.text = loveModel.result

                root.setOnLongClickListener {
                    onLongClick(loveModel)
                    true
                }
            }
        }
    }
}