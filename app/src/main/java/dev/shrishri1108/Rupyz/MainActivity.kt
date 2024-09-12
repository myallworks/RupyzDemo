package dev.shrishri1108.Rupyz

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.shrishri1108.Rupyz.Adapter.RecyclerViewAdapter
import dev.shrishri1108.Rupyz.Network.ListReciever
import dev.shrishri1108.Rupyz.ViewModel.ListViewModel
import dev.shrishri1108.Rupyz.ViewModel.ListViewModelFactory
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity() {
    private val listReciever: ListReciever = ListReciever()
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var listViewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        val viewModelFactory = ListViewModelFactory(listReciever)
        listViewModel = ViewModelProvider(this, viewModelFactory)[ListViewModel::class.java]
        listViewModel.getUsers()
        listViewModel.m_response.observe(this, Observer {
            recyclerViewAdapter.setUserData(it.data)
            recyclerView.visibility = View.VISIBLE
        })

    }

    private fun initRecyclerView() {

        recyclerViewAdapter = RecyclerViewAdapter(this, ArrayList())

        recyclerView.apply {

            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = recyclerViewAdapter
        }
    }
}