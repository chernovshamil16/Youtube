package com.example.youtube.playlists

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtube.R
import com.example.youtube.data.model.Items
import com.example.youtube.databinding.ItemPlaylistsBinding

class PlaylistAdapter (private val list : ArrayList<Items>, private val clickListener : (id : String) -> Unit)
    : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(
            ItemPlaylistsBinding.inflate(
                LayoutInflater.from(parent.context) , parent , false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class PlaylistViewHolder(private val binding : ItemPlaylistsBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind (items: Items) {
            binding.tvTitle.text = items.snippet.title
            binding.tvId.text = String.format(itemView.context.getString(R.string.video_series , items.contentDetails.itemCount.toString()))
            binding.ivPlaylist.load(items.snippet.thumbnails.standard
                .url)

            itemView.setOnClickListener {
                clickListener(items.id)
            }
        }

    }

}

