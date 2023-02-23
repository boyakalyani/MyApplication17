package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class updateActivity : AppCompatActivity() {
    private lateinit var database: NoteDatabase
    private lateinit var notesDao: NotesDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        var userNameNode=findViewById<EditText>(R.id.userNameupTtle_id)
        var useremaiilnote=findViewById<EditText>(R.id.userEmailupnote_id)

        val id=intent.getIntExtra("id",-1)
        val name=intent.getStringExtra("name")
        val email=intent.getStringExtra("email")

        database=NoteDatabase.getDatabase(this)
        notesDao=database.getNotesDao()

        userNameNode.setText(name)
        useremaiilnote.setText(email)
        val updateuserbtn=findViewById<Button>(R.id.updateusernotes_id)

        updateuserbtn.setOnClickListener(){
//            notesDao.updateUser(Note(name!!,email!!))//id rayali mundhu chuskoo
            notesDao.updateUser(Note(userNameNode.text.toString(),useremaiilnote.text.toString()))
            finish()
        }

    }
}