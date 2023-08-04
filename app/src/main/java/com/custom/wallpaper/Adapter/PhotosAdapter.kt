package com.custom.wallpaper.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.custom.wallpaper.ModelClass.ModelClass
import com.custom.wallpaper.databinding.LayoutPhotosBinding
import java.util.ArrayList

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.DataHolder>() {
    var list = ArrayList<ModelClass>()
    lateinit var context : Context

    class DataHolder(itemView: LayoutPhotosBinding) : RecyclerView.ViewHolder(itemView.root) {

        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        context = parent.context
        var binding = LayoutPhotosBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataHolder(binding)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {


        holder.binding.apply {

            val dataModel = list[position]
            Glide.with(context).load(dataModel.image).into(imgData)

        }
    }

    fun UpdateData(list: ArrayList<ModelClass>) {
        this.list = list
        notifyDataSetChanged()
    }
}