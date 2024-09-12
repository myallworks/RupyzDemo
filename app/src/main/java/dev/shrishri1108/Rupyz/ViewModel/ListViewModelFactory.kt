package dev.shrishri1108.Rupyz.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.shrishri1108.Rupyz.Network.ListReciever

class ListViewModelFactory(private val listReciever: ListReciever) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel(listReciever) as T
    }
}