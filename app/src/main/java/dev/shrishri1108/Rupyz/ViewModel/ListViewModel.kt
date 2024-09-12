package dev.shrishri1108.Rupyz.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.shrishri1108.Rupyz.Model.ListResponse
import dev.shrishri1108.Rupyz.Network.ListReciever
import kotlinx.coroutines.launch

class ListViewModel(private val listReciever: ListReciever) : ViewModel() {

    val m_response: MutableLiveData<ListResponse> = MutableLiveData()

    fun getUsers() {

        viewModelScope.launch {
            try {
                val response = listReciever.getUsers()
                m_response.value = response
                Log.d("mainTest", "Success")

            } catch (exception: Exception) {

                Log.d("mainTest", "getmsg- ${exception.message}")
            }

        }
    }
}
