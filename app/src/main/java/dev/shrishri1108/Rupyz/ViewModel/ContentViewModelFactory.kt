package dev.shrishri1108.Rupyz.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.shrishri1108.Rupyz.Network.ContentReciever

class ContentViewModelFactory(private val contentReciever: ContentReciever) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ContentViewModel(contentReciever) as T
    }

}