package com.example.challenge_chapter4.dao

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel (application : Application) : AndroidViewModel(application){

    val repo : NoteRepository

    init {
        val dao = NoteDatabase.getInstance(application)!!.noteDao()
        repo = NoteRepository(dao)
    }

    fun getNote(): LiveData<List<DataNote>> = repo.getAllNote()

    fun addNote(note : DataNote) {
        repo.insertNote(note)
    }
    fun updateNote(note : DataNote) {
        repo.updateNote(note)
    }

}