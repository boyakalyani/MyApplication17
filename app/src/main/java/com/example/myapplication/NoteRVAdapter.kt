package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition


class NoteRVAdapter (private var context: Context,private var userListNote: List<Note>)
    :RecyclerView.Adapter<NoteRVAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int):MyViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.note_rv_item,parent,false)
        return MyViewHolder(view)
       }
    override fun onBindViewHolder(holder: MyViewHolder,position: Int) {
        var myModel=userListNote.get(position)
        holder.nameTv.text=myModel.noteTitle
        holder.emaiTv.text=myModel.noteDescription

        holder.itemView.setOnClickListener(){
            val intent= Intent(context,updateActivity::class.java)
            intent.putExtra("id",userListNote.get(position).id)
            intent.putExtra("name",userListNote.get(position).noteTitle)
            intent.putExtra("email",userListNote.get(position).noteDescription)

            context.startActivity(intent)
        }
        holder.deleteuse.setOnClickListener(){
            val database=NoteDatabase.getDatabase(context)
            val dao=database.getNotesDao()
            dao.deleteUser(userListNote.get(position))
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return userListNote.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var nameTv:TextView
         var emaiTv:TextView
         var deleteuse:ImageView

        init {
            nameTv=itemView.findViewById(R.id.userNametv_id)
            emaiTv=itemView.findViewById(R.id.userEmailtv_id)
            deleteuse=itemView.findViewById(R.id.deleteuser_id)
        }
    }
}


//class NoteRVAdapter( val noteClickDeleteInterface: NoteClickDeleteInterface, val noteClickInterface: NoteClickInterface) : RecyclerView.Adapter<NoteRVAdapter.ViewHolder>() {

//    private val allNotes = ArrayList<Note>()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_rv_item, parent, false)
//        return ViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.noteTV.setText(allNotes.get(position).noteTitle)
//        holder.dateTV.setText("Last Updated : " + allNotes.get(position).timeStamp)
//        holder.deleteIV.setOnClickListener {
//
//            noteClickDeleteInterface.onDeleteIconClick(allNotes.get(position))
//        }
//
//        holder.itemView.setOnClickListener {
//
//            noteClickInterface.onNoteClick(allNotes.get(position))
//        }
//    }
//
//    override fun getItemCount(): Int {
//
//        return allNotes.size
//    }
//
//    fun updateList(newList: List<Note>) {
//
//        allNotes.clear()
//
//        allNotes.addAll(newList)
//        notifyDataSetChanged()
//    }
//     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        val noteTV = itemView.findViewById<TextView>(R.id.idTVNote)
//        val dateTV = itemView.findViewById<TextView>(R.id.idTVDate)
//        val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)
//    }
//}

//interface NoteClickDeleteInterface {
//        fun onDeleteIconClick(note: Note)
//}
//
//interface NoteClickInterface {
//    fun onNoteClick(note: Note)
//}
