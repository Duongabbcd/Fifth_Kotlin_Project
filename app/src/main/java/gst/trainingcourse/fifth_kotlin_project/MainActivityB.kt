package gst.trainingcourse.fifth_kotlin_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_b)

        val id = intent.getStringExtra("id")!!.toInt() //nhan data tu mainac
        val image = intent.getStringExtra("image")!!.toInt()
        val name = intent.getStringExtra("name")!!.toString()
        val author = intent.getStringExtra("author")!!.toString()
        val genre = intent.getStringExtra("genre")!!.toString()
        val track = intent.getStringExtra("track")!!.toInt()
        val year = intent.getStringExtra("year")!!.toInt()


        val fragmentB = supportFragmentManager.findFragmentById(R.id.fragment2) as Fragment_B
      fragmentB.displayDetail(id,image,name,author,genre,track,year)


    }
}