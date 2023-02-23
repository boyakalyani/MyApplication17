package com.example.myapplication
//
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

//class AddEditNoteActivity : AppCompatActivity() {
//
//    lateinit var noteTitleEdt: EditText
//    lateinit var noteEdt: EditText
//    lateinit var saveBtn: Button
//
//
//    var noteID = -1;
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_edit_note)
//
//
//        noteTitleEdt = findViewById(R.id.idEdtNoteName)
//        noteEdt = findViewById(R.id.idEdtNoteDesc)
//        saveBtn = findViewById(R.id.idBtn)
//
//
//
//        val noteType = intent.getStringExtra("noteType")
//        if (noteType.equals("Edit")) {
//            val noteTitle = intent.getStringExtra("noteTitle")
//            val noteDescription = intent.getStringExtra("noteDescription")
//            noteID = intent.getIntExtra("noteId", -1)
//            saveBtn.setText("Update Note")
//            noteTitleEdt.setText(noteTitle)
//            noteEdt.setText(noteDescription)
//        } else {
//            saveBtn.setText("Save Note")
//        }
//        saveBtn.setOnClickListener {
//
//            val noteTitle = noteTitleEdt.text.toString()
//            val noteDescription = noteEdt.text.toString()
//
//            if (noteType.equals("Edit")) {
//                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
//                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
//                    val currentDateAndTime: String = sdf.format(Date())
//                    val updatedNote = Note(noteTitle, noteDescription, currentDateAndTime)
//
//                    val notesDao=NoteDatabase.getDatabase(this).getNotesDao()
//                    updatedNote.id = noteID
//                    notesDao.updateNote(updatedNote)
//                    Toast.makeText(this, "Note Updated..", Toast.LENGTH_LONG).show()
//                }
//            } else {
//                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
//                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
//                    val currentDateAndTime: String = sdf.format(Date())
//
//                    val notesDao=NoteDatabase.getDatabase(this).getNotesDao()
//                    val newNote
//                    viewModal.addNote(Note(noteTitle, noteDescription, currentDateAndTime))
//                    Toast.makeText(this, "$noteTitle Added", Toast.LENGTH_LONG).show()
//                }
//            }
//            startActivity(Intent(applicationContext, MainActivity::class.java))
//            this.finish()
//        }
//    }
//}



class AddEditNoteActivity : AppCompatActivity() {

    lateinit var noteTitleEdt: EditText
    lateinit var noteEdt: EditText
    lateinit var saveBtn: Button

    var noteID = -1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)

        noteTitleEdt = findViewById(R.id.idEdtNoteName)
        noteEdt = findViewById(R.id.idEdtNoteDesc)
        saveBtn = findViewById(R.id.idBtn)

//        val noteType = intent.getStringExtra("noteType")
//        if (noteType.equals("Edit")) {
//            val noteTitle = intent.getStringExtra("noteTitle")
//            val noteDescription = intent.getStringExtra("noteDescription")
//            noteID = intent.getIntExtra("noteId", -1)
//            saveBtn.setText("Update Note")
//            noteTitleEdt.setText(noteTitle)
//            noteEdt.setText(noteDescription)
//        } else {
//            saveBtn.setText("Save Note")
//        }
//        saveBtn.setOnClickListener {
//
//            val noteTitle = noteTitleEdt.text.toString()
//            val noteDescription = noteEdt.text.toString()
//
//            if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
//                val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
//                val currentDateAndTime: String = sdf.format(Date())
//
//                // get the notesDao object
//                val notesDao = NoteDatabase.getDatabase(this).getNotesDao()
//
//                // perform database operation on a background thread
//                CoroutineScope(Dispatchers.IO).launch {
//                    if (noteType.equals("Edit")) {
//                        val updatedNote = Note(noteTitle, noteDescription, currentDateAndTime)
//                        updatedNote.id = noteID
////                        notesDao.updateNote(updatedNote)
//                        Toast.makeText(this@AddEditNoteActivity, "Note Updated..", Toast.LENGTH_LONG).show()
//                    } else {
//                        val newNote = Note(noteTitle, noteDescription, currentDateAndTime)
////                        notesDao.addNote(newNote)
//                        Toast.makeText(this@AddEditNoteActivity, "$noteTitle Added", Toast.LENGTH_LONG).show()
//                    }
//
//                    startActivity(Intent(applicationContext, MainActivity::class.java))
//                    this@AddEditNoteActivity.finish()
//                }
//            }
//        }
    }
}
