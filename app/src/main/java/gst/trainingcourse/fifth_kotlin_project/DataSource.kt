package gst.trainingcourse.fifth_kotlin_project

import gst.trainingcourse.fifth_kotlin_project.model.Album
import gst.trainingcourse.fifth_kotlin_project.model.Author
import gst.trainingcourse.fifth_kotlin_project.model.Song

class DataSource {
    companion object{
        fun createDataSet() :ArrayList<Song>{
            val list = ArrayList<Song>()
            list.add(Song(1,R.drawable.haitrieunam , "Hai trieu nam",Author.Den_vau,Album.OldSchool,1,2019))
            list.add(Song(2,R.drawable.denvau , "Dua nhau di tron",Author.Den_vau,Album.OldSchool,2,2016))
            list.add(Song(3,R.drawable.noicuoiconduong, "Nguoi la noi cuoi con duong",Author.Lil_Kinght,Album.OldSchool,4,2010))
            list.add(Song(4,R.drawable.lk , "Im lang",Author.Lil_Kinght,Album.OldSchool,2,2009))
            list.add(Song(5,R.drawable.eminem , "Rap God",Author.Emniem,Album.OldSchool,1,2007))
            list.add(Song(6,R.drawable.wizkhalifa , "Black And Yellow",Author.Wiz_Khalifa,Album.OldSchool,3,2004))
            list.add(Song(7,R.drawable.rhym , "Yeu 5",Author.Rhymastic,Album.NewSchool,1,2017))
            list.add(Song(8,R.drawable.notafraind , "Not Afraid",Author.Emniem,Album.NewSchool,4,2009))
            list.add(Song(9,R.drawable.lose , "Lose yourself",Author.Emniem,Album.NewSchool,2,2006))
            list.add(Song(10,R.drawable.mhtat , "Khi man hinh tat",Author.Rhymastic,Album.NewSchool,3,2018))
            list.add(Song(11,R.drawable.laucao , "Tren lau cao",Author.Rhymastic,Album.NewSchool,1,2018))
            list.add(Song(12,R.drawable.wiz , "We own It",Author.Wiz_Khalifa,Album.NewSchool,2,2013))


            return list
        }
        var selectedAuthor="All"
        var selectedType = "All"

        fun getFilter() :MutableList<Song>{
            val newOne = mutableListOf<Song>()

            for(song in createDataSet()){
                if((selectedAuthor=="All")
                    && (selectedType=="All"|| selectedType == song.track.toString())){
                    newOne.add(song)
                }
            }

            return newOne
        }
    }
}