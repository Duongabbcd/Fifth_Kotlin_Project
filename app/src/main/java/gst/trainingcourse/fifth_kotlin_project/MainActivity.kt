package gst.trainingcourse.fifth_kotlin_project

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main),Communicator {
    var fragmentA = Fragment_A()
    private var mIsDualPane = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//       setContentView()

        //if FragmentB is present in activity_main.xml,then we are in Tablet
        //Else the app is running handset
        val fragmentBView = findViewById<View>(R.id.fragmentB)
        mIsDualPane = fragmentBView?.visibility == View.VISIBLE

        //custom Toolbar replacing ActionBar
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val logo: ImageView = findViewById(R.id.logo)
        logo.setOnClickListener {
            drawerLayout.openDrawer(Gravity.LEFT)
       }

//        supportFragmentManager.beginTransaction().add(R.id.fragmentA,fragmentA).commit()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragmentA, fragmentA)
            commit()
        }

        val nav1 :NavigationView = findViewById(R.id.nav1)
        val nav2 :NavigationView = findViewById(R.id.nav2)


            nav1.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.all1 ->{
                        selectAuthor("All")
                    }
                    R.id.rap_den -> selectAuthor("Den Vau")
                    R.id.raplk -> selectAuthor("Lil Knight")
                    R.id.rapem ->selectAuthor("Eminem")
                    R.id.raprhym -> selectAuthor("Rhymastic")
                    R.id.rapwiz -> selectAuthor("Wiz Khalifa")
                }
                true
            }

            nav2.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.all2 ->selectTrack("All")
                    R.id.album1 -> selectTrack("1")
                    R.id.album2-> selectTrack("2")
                    R.id.album3 ->selectTrack("3")
                    R.id.album4-> selectTrack("4")

                }
                true
            }



    }
    override fun displayDetails(
        id: Int,
        image: Int,
        title: String,
        author: String,
        genre: String,
        track: Int,
        released: Int
    ) {
        if (!mIsDualPane) {//false = handset mode

            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragmentA, fragmentA)
                commit()
            }

            val intent = Intent(this, MainActivityB::class.java)

            intent.putExtra("id", id.toString())
            intent.putExtra("image", image.toString())
            intent.putExtra("name", title)
            intent.putExtra("author", author)
            intent.putExtra("genre", genre)
            intent.putExtra("track", track.toString())
            intent.putExtra("year", released.toString())


            startActivity(intent)

        }else{

            val fragmentB = supportFragmentManager.findFragmentById(R.id.fragmentB) as Fragment_B

           fragmentB.displayDetail(id,image,title,author,genre,track,released)

        }
    }

    fun selectAuthor(author: String){
        DataSource.selectedAuthor =author
        fragmentA= Fragment_A()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentA,fragmentA).commit()

    }

    fun selectTrack(track :String){
        DataSource.selectedType = track
        fragmentA = Fragment_A()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentA,fragmentA).commit()
    }




}
