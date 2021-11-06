package gst.trainingcourse.fifth_kotlin_project.Utils

import android.content.Context
import android.content.res.Configuration
import gst.trainingcourse.fifth_kotlin_project.model.Album
import gst.trainingcourse.fifth_kotlin_project.model.Author

object Utils {
    fun isTablet(context: Context):Boolean{
        return (context.resources.configuration.screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK)>=Configuration.SCREENLAYOUT_SIZE_LARGE
    }

    fun getOneAuthor(author: Author) :String{
        return when(author){
            Author.Den_vau->"Den Vau"
            Author.Lil_Kinght->"Lil Knight"
            Author.Emniem->"Eminem"
            Author.Wiz_Khalifa->"Wiz Khalifa"
            Author.Rhymastic->"Rhymastic"
        }
    }

    fun getOneAlbum(album: Album):String{
        return when(album){
            Album.NewSchool->"New School"
            Album.OldSchool->"Old School"
        }
    }
}