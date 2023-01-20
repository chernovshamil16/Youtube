package com.example.youtube.playlists

import androidx.lifecycle.LiveData
import com.example.youtube.App
import com.example.youtube.core.ui.BaseViewModel
import com.example.youtube.data.model.Playlists

class MainViewModel : BaseViewModel() {


    fun playlist() : LiveData<Playlists> {
        return App().repository.getPlaylists()
    }



}