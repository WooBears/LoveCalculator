package com.example.lovecalculator.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.databinding.ItemViewBinding
import com.example.lovecalculator.model.OnBoarding
import com.example.lovecalculator.util.loadImage

class OnBoardingAdapter(
    private val onClick: ()->Unit
): Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf<OnBoarding>(
        OnBoarding("Find your Love", "Find your love with whom you want to live", "https://static.vecteezy.com/system/resources/previews/001/187/438/non_2x/heart-png.png"),
        OnBoarding("Match with your Love", "Swipe to right to get the right one", "https://i0.wp.com/sreditingzone.com/wp-content/uploads/2018/03/Love-Png-HD-19.png?ssl=1"),
        OnBoarding("Connect with your Love", "Write messages to each other and be involved", "https://e7.pngegg.com/pngimages/689/350/png-clipart-heart-love-heart-shaped-red-wish-hearts-thumbnail.png"),
        OnBoarding("Be Happy!", "Live Your Life ", "https://w7.pngwing.com/pngs/756/401/png-transparent-couple-love-love-couple-love-child-hand-thumbnail.png")

    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemViewBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemViewBinding): ViewHolder(binding.root)
    {
        fun onBind(onBoarding: OnBoarding)= with(binding){
            tvTitle.text = onBoarding.title
            tvDesc.text= onBoarding.desc
            ivBoard.loadImage(onBoarding.image.toString())
            tvSkip.isVisible= adapterPosition != list.lastIndex
            btnStart.isVisible = adapterPosition == list.lastIndex

            btnStart.setOnClickListener {
                onClick()
            }

            tvSkip.setOnClickListener {
                onClick()
            }
        }
    }

}