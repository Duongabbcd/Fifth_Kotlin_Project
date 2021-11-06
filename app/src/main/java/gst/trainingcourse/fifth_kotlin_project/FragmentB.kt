package gst.trainingcourse.fifth_kotlin_project

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import gst.trainingcourse.fifth_kotlin_project.databinding.FragmentBBinding
import gst.trainingcourse.fifth_kotlin_project.model.Song

class Fragment_B : Fragment() {
    private val listSong = ArrayList<Song>()
    private val data =DataSource.createDataSet()

    private lateinit var binding: FragmentBBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentBBinding.inflate(inflater)



        return binding.root
    }
    //GO CHO T CAI DU LIEU TRONG FRAG B vao parameter ??
    //DOI TY t them cai nay


    fun displayDetail(id :Int ,image : Int, name : String, author: String, genre: String, track :Int ,release :Int){

        binding.track.text = "Track :"+String.format("%03d", track)
        binding.imageSong.setImageResource(image)
        binding.nameSong.text=name
        binding.authorSong.text=author
        binding.genre.text="Genre : "+genre
        binding.released.text= "Release : "+release.toString()
    }


}

