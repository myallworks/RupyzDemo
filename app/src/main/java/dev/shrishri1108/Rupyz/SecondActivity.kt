package dev.shrishri1108.Rupyz

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.shrishri1108.Rupyz.Adapter.ContentAdapter
import dev.shrishri1108.Rupyz.Network.ContentReciever
import dev.shrishri1108.Rupyz.ViewModel.ContentViewModel
import dev.shrishri1108.Rupyz.ViewModel.ContentViewModelFactory
import kotlinx.android.synthetic.main.activity_second.recyclerView1

class SecondActivity : AppCompatActivity() {

    private val contentReciever: ContentReciever = ContentReciever()
    private lateinit var contentAdapter: ContentAdapter
    private lateinit var contentViewModel: ContentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initRecyclerView()
        val viewModelFactory = ContentViewModelFactory(contentReciever)
        contentViewModel = ViewModelProvider(this, viewModelFactory)[ContentViewModel::class.java]
        contentViewModel.getUsers()
        contentViewModel.m_response.observe(this, Observer {
            contentAdapter.setUserData(it.data)
            recyclerView1.visibility = View.VISIBLE
        })
    }

    private fun initRecyclerView() {

        contentAdapter = ContentAdapter(this, ArrayList())

        recyclerView1.apply {

            recyclerView1.layoutManager = LinearLayoutManager(this@SecondActivity)
            adapter = contentAdapter
        }
    }
}