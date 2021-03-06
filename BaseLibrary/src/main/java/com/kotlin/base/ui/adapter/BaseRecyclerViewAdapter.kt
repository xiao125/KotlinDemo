package com.kotlin.base.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import java.text.FieldPosition

/**
 * RecyclerViewAdapter基类
 */
 abstract class BaseRecyclerViewAdapter<T,VH:RecyclerView.ViewHolder>(var mContext: Context):RecyclerView.Adapter<VH>() {

    //ItemClick事件
    var mItemClickListener: OnItemClickListener<T>? =null
    /**
     * ItemClick事件声明
     */
    interface OnItemClickListener<in T>{
        fun onItemClick(item:T,position: Int)
    }

    fun setOnItemClickListener(listener:OnItemClickListener<T>){
        this.mItemClickListener = listener
    }

    /**
     * MutableList可变列表
     * 定义：MutableList<类型>或mutableListOf(元素1，元素2，....,元素n)
     * 可以改变自身大小的数组
     */
    var dataList:MutableList<T>  = mutableListOf()

    /**
     * 设置数据
       Presenter处理过为null的情况，所以为不会为Null
     */
    fun setData(sources:MutableList<T>){
        dataList = sources
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener{
            if(mItemClickListener !=null){
                mItemClickListener!!.onItemClick(dataList[position],position)
            }
        }
    }


    override fun getItemCount(): Int {
        return dataList.size
    }



}