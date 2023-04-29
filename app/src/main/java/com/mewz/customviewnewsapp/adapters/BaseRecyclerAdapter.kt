package com.mewz.customviewnewsapp.adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.mewz.customviewnewsapp.views.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<T: BaseViewHolder<W>, W>
    : RecyclerView.Adapter<T>() {

     var mData : MutableList<W> = arrayListOf()

    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(data: MutableList<W>){
        mData = data
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun appendNewData(data: List<W>){
        mData.addAll(data)
        notifyDataSetChanged()
    }
}
