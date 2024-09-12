package dev.shrishri1108.Rupyz.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.shrishri1108.Rupyz.Model.DataX
import dev.shrishri1108.Rupyz.R
import kotlinx.android.synthetic.main.item_content.view.imageView1

class ContentAdapter(private val context: Context, private var usersResponse: ArrayList<DataX>) :
    RecyclerView.Adapter<ContentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_content, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user = usersResponse[position]

//        holder.id.text = post.id
        holder.title.text = user.title
        holder.subject.text = user.content

        Glide.with(holder.itemView.context)
            .load(user.feature_image_url)
            .into(holder.itemView.imageView1)

    }

    override fun getItemCount(): Int {
        return usersResponse.size
    }

    fun setUserData(postList: ArrayList<DataX>) {
        this.usersResponse = postList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //        fun bind(users: UsersItem){
//            itemView.txtName.text = users.name
        val title: TextView = itemView.findViewById(R.id.txtTitle1)
        val subject: TextView = itemView.findViewById(R.id.txtContent)
        val image: ImageView = itemView.findViewById(R.id.imageView1)
        //  itemView.txtSubject.text = users.subjects.toString()


    }

}