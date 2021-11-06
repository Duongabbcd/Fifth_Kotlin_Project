package gst.trainingcourse.fifth_kotlin_project

import android.content.Context
import android.graphics.Color
import android.os.Handler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView
import gst.trainingcourse.fifth_kotlin_project.model.Song

class SongAdapter(private var items:ArrayList<Song>, private val context: Context):RecyclerView.Adapter<SongAdapter.MyViewHolder>(){
        var selected :Int = 0
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongAdapter.MyViewHolder {
       val v =inflater.inflate(R.layout.item_song,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
       val current = items[position]

        holder.setData(current ,position)

        holder.itemView.setBackgroundColor(if(selected == position) Color.parseColor("#EADD69") else Color.WHITE)

        holder.setListener()


    }

    override fun getItemCount(): Int {
      return items.size
    }

   inner class MyViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
       lateinit var current :Song
       var pos : Int = 0

      fun setData(current :Song ,position: Int){
          image.setImageResource(current.image)
          title.text=current.title
          author.text= current.author
          this.current = current
          this.pos = position
      }
       val image :ImageView =itemView.findViewById(R.id.image)
       val title:TextView =itemView.findViewById(R.id.title)
       val author: TextView =itemView.findViewById(R.id.author)

       fun setListener(){
           itemView.setOnClickListener {
               Toast.makeText(context,"Detail of ${current.title}",Toast.LENGTH_SHORT).show()
               val click = context as Communicator
               click.displayDetails(current.id,current.image,current.title,current.author,
                   current.genre,current.track, current.release )

               itemView.setBackgroundColor(Color.parseColor("#EADD69"))

               if(adapterPosition == RecyclerView.NO_POSITION) return@setOnClickListener

               notifyItemChanged(selected)
               selected = adapterPosition
               notifyItemChanged(selected)
           }
       }
    }
}