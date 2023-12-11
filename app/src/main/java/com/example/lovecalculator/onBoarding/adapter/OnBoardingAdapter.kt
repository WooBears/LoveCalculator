package com.example.lovecalculator.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieDrawable
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemViewBinding
import com.example.lovecalculator.model.OnBoarding
import com.example.lovecalculator.util.loadImage

class OnBoardingAdapter(
    private val onClick: ()->Unit
): Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf<OnBoarding>(
        OnBoarding("Find your Love", "Find your love with whom you want to live", R.raw.love1),
        OnBoarding("Match with your Love", "Swipe to right to get the right one", R.raw.love2),
        OnBoarding("Connect with your Love", "Write messages to each other and be involved", R.raw.love3)

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

    inner class OnBoardingViewHolder(val binding: ItemViewBinding): ViewHolder(binding.root)
    {
        private val lottieAnimationView: LottieAnimationView = binding.ivLottiNimation
        fun onBind(onBoarding: OnBoarding)= with(binding){
            tvTitle.text = onBoarding.title
            tvDesc.text= onBoarding.desc
            tvSkip.isVisible= adapterPosition != list.lastIndex
            btnStart.isVisible = adapterPosition == list.lastIndex


            LottieCompositionFactory.fromRawRes(itemView.context, onBoarding.animation)
            .addListener { composition ->
            lottieAnimationView.setComposition(composition)
            lottieAnimationView.repeatCount = LottieDrawable.INFINITE
            lottieAnimationView.playAnimation()
        }
            btnStart.setOnClickListener {
                onClick()
            }

            tvSkip.setOnClickListener {
                onClick()
            }
        }
    }

}