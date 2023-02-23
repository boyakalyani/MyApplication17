package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity:AppCompatActivity() {
    private lateinit var database: NoteDatabase
    private lateinit var notesDao: NotesDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database=NoteDatabase.getDatabase(this)
        notesDao=database.getNotesDao()

        getData();

        val insertbtn=findViewById<Button>(R.id.idBtn)
        val noteEdt1=findViewById<EditText>(R.id.idEdtNoteName)
        val noteEdt2=findViewById<EditText>(R.id.idEdtNoteDesc)

        insertbtn.setOnClickListener(){
            var myTable=Note(noteEdt1.text.toString(),noteEdt2.text.toString(),)
            notesDao.createUser(myTable)
            getData()
        }

    }

    private fun getData() {
        val reclerView=findViewById<RecyclerView>(R.id.recyclerView_id)

        var userListNote=notesDao.getAllUsers()
        var adapter=NoteRVAdapter(this,userListNote)
        reclerView.adapter=adapter
        reclerView.layoutManager=LinearLayoutManager(this)
    }
}


//
//import android.content.Intent
//import android.provider.SyncStateContract.Helpers.insert
//import android.widget.Toast
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import androidx.room.Room
//import com.google.android.material.floatingactionbutton.FloatingActionButton
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import java.nio.file.Files.delete
//
//class MainActivity : AppCompatActivity(), NoteClickInterface, NoteClickDeleteInterface {
//
//    lateinit var notesRV: RecyclerView
//    lateinit var addFAB: FloatingActionButton
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        notesRV = findViewById(R.id.notesRV)
//        addFAB = findViewById(R.id.idFAB)
//
//        val noteDatabase = Room.databaseBuilder(this, NoteDatabase::class.java, "notes_db").build()
//        val noteDao = noteDatabase.getNotesDao()
//
//
//        val allNotes: LiveData<List<Note>> = noteDatabase.allNotes
//
//
//        notesRV.layoutManager = LinearLayoutManager(this)
//
//        val noteRVAdapter = NoteRVAdapter(this, this)
//        notesRV.adapter = noteRVAdapter
//
//        addFAB.setOnClickListener {
//            val intent = Intent(this@MainActivity, AddEditNoteActivity::class.java)
//            startActivity(intent)
//            this.finish()
//        }
//    }
//
//    override fun onNoteClick(note: Note) {
//        val intent = Intent(this@MainActivity, AddEditNoteActivity::class.java)
//        intent.putExtra("noteType", "Edit")
//        intent.putExtra("noteTitle", note.noteTitle)
//        intent.putExtra("noteDescription", note.noteDescription)
//        intent.putExtra("noteId", note.id)
//        startActivity(intent)
//        this.finish()
//    }
//
//    override fun onDeleteIconClick(note: Note) {
//        Toast.makeText(this, "${note.noteTitle} Deleted", Toast.LENGTH_LONG).show()
//deleteNote(note)
//    }
//}
//
//
//




