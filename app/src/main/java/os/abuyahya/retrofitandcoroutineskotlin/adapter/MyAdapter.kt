package os.abuyahya.retrofitandcoroutineskotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_layout.view.*
import os.abuyahya.retrofitandcoroutineskotlin.R
import os.abuyahya.retrofitandcoroutineskotlin.model.Post

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<Post>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.userId_txt.text = myList[position].userId.toString()
        holder.itemView.id_txt.text = myList[position].id.toString()
        holder.itemView.title_txt.text = myList[position].title
        holder.itemView.body_txt.text = myList[position].body
    }

    fun setData(newList: List<Post>){
        this.myList = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return myList.size
    }
}
