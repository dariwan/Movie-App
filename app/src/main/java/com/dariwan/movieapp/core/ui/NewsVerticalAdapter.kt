package com.dariwan.movieapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dariwan.movieapp.R
import com.dariwan.movieapp.core.domain.model.Movie
import com.dariwan.movieapp.databinding.TopMovieListBinding

class NewsVerticalAdapter : RecyclerView.Adapter<NewsVerticalAdapter.ListViewHolder>() {

    private var listData = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListData: List<Movie>?){
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = TopMovieListBinding.bind(itemView)
        fun bind(data: Movie){
            with(binding){
                Glide.with(itemView.context)
                    .load(data.poster_path)
                    .into(imgMovie)
                tvTitle.text = data.original_title
                tvDate.text = data.release_date
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.top_movie_list, parent, false))


    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }
}