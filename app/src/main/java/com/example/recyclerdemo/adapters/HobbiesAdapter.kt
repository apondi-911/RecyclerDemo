package com.example.recyclerdemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdemo.activities.MainActivity
import com.example.recyclerdemo.models.HobbiesViewModel
import com.example.recyclerdemo.R


class HobbiesAdapter(private val context: Context, private val hobbiesList: List<HobbiesViewModel>): RecyclerView.Adapter<HobbiesAdapter.ViewHolder>(){

    private var itemHobbiesListener : OnItemClickListener?=null

    //creating an interface
    interface OnItemClickListener{
        fun onItemHobbiesClick(position: Int)
        fun onItemImageClicked(position: Int)
    }

    fun setOnItemClickListener (listener: MainActivity){
        itemHobbiesListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view =LayoutInflater.from(parent.context).inflate(R.layout.list_items,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbiesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hobbiesViewModel = hobbiesList[position]
        holder.textView.text=hobbiesViewModel.title

    }

    inner class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
        var textView: TextView = itemView.findViewById(R.id.tvTitle)
        var imgView: ImageView =itemView.findViewById(R.id.imgShare)

        init {
            textView.setOnClickListener{
                if(itemHobbiesListener!=null){
                    @Suppress("DEPRECATION") val position=adapterPosition
                    if (position!=RecyclerView.NO_POSITION){
                        itemHobbiesListener!!.onItemHobbiesClick(position)
                    }
                }
            }

            imgView.setOnClickListener{
                if(itemHobbiesListener!=null){
                    @Suppress("DEPRECATION") val position=adapterPosition
                    if (position!=RecyclerView.NO_POSITION){
                        itemHobbiesListener!!.onItemImageClicked(position)
                    }
                }
            }

        }


    }
}