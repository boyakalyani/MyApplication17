package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Dao
interface NotesDao {
    @Insert
    fun createUser(note: Note)

    @Update
    fun updateUser(note: Note)

    @Delete
    fun deleteUser(note: Note)

    @Query("SELECT * from notesTable")//chusko o sari Note rasi
    fun getAllUsers():List<Note>

}
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(note :Note)
//
//
//    @Delete
//    suspend fun delete(note: Note)
//
//
//    @Query("Select * from notesTable order by id ASC")
//    fun getAllNotes(): LiveData<List<Note>>
//
//    @Update
//    suspend fun update(note: Note)
//
//}
//@Dao
//interface NoteDao {
