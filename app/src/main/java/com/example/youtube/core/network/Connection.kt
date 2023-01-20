package com.example.youtube.core.network

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import androidx.lifecycle.MutableLiveData

class Connection (private val cm : ConnectivityManager) : MutableLiveData<Boolean>() {

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {

        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            postValue(true)
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            postValue(false)
        }
    }

    override fun onActive() {
        val request = NetworkRequest.Builder()
        cm.registerNetworkCallback(request.build() , networkCallback)
    }

    override fun onInactive() {
        super.onInactive()
        cm.unregisterNetworkCallback(networkCallback)
    }

}