package gst.trainingcourse.fifth_kotlin_project.model

import java.io.Serializable

class Song( var id:Int = 0,
            var image:Int = 0,
            var title:String ="",
            var author:Author,
            var genre: Album,
            var track:Int=0,
            var release:Int=0) :Serializable{

    override fun toString(): String {
        return "Song( id = $id , image = $image , title = $title , author =$author ,genre = $genre , track= ${String.format("%02d",track)} , release = $release"
    }
}


enum class Author{
    Den_vau,Lil_Kinght,Emniem,Wiz_Khalifa,Rhymastic
}


enum class Album{
    OldSchool ,NewSchool
}