package gst.trainingcourse.fifth_kotlin_project

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import gst.trainingcourse.fifth_kotlin_project.model.Song


class Fragment_A : Fragment() {
    private lateinit var recycler1 :RecyclerView
    private lateinit var songAdapter: SongAdapter
    private val listSong = ArrayList<Song>()
    private val data =DataSource.getFilter()



        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)


            listSong.addAll(data)
            recycler1 = view.findViewById(R.id.recycler1)


         initRecycleView()



            return view
    }

    private fun searching(x:String){
        val listNew = arrayListOf<Song>()
        for(song in data) {
                if (song.author.equals(x))
                    listNew.add(song)
                else if(x.equals("Tat ca")){
                    listNew.addAll(data)
                }
        }

        songAdapter = SongAdapter(listNew,requireContext())
        recycler1.adapter=songAdapter
    }

    private fun checking(x:Int){
        val listNew = arrayListOf<Song>()
        for(song in data) {
            if (song.track.equals(x))
                listNew.add(song)
            else if(x.equals(0)){
                listNew.addAll(data)
            }
        }

        songAdapter = SongAdapter(listNew,requireContext())
        recycler1.adapter=songAdapter
    }

    private fun initRecycleView() {
        songAdapter = SongAdapter(listSong,requireContext() )
        recycler1.setHasFixedSize(true)
        recycler1.layoutManager =LinearLayoutManager(activity)
        recycler1.adapter =songAdapter

    }


    fun isNumber(s: String?): Boolean {
        return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
    }
}