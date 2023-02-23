package com.example.myapplication

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNotesDao(): NotesDao

    //myDao
    companion object {
        private var INSTANSE : NoteDatabase? = null
        fun getDatabase(context: Context):NoteDatabase{
            if (INSTANSE==null){
                INSTANSE=Room.databaseBuilder(context,NoteDatabase::class.java,"app_database").fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
            return INSTANSE!!
        }
    }
}

//    open var allNotes: LiveData<List<Note>> = getNotesDao().getAllNotes()

//    companion object {
//        @Volatile
//        private var INSTANCE: NoteDatabase? = null
//
//        fun getDatabase(context: Context): NoteDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    NoteDatabase::class.java,
//                    "note_database"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//
//}
////fun deleteNote(note: Note) = CoroutineScope(Dispatchers.IO).launch {
////    noteDao.deleteNote(note)
////}
////
////fun updateNote(note: Note) = CoroutineScope(Dispatchers.IO).launch {
////    noteDao.updateNote(note)
////}
////
////fun addNote(note: Note) = CoroutineScope(Dispatchers.IO).launch {
////    noteDao.addNote(note)
////}




