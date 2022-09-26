package com.example.challenge_chapter4.dao

import androidx.lifecycle.LiveData

class NoteRepository (val data: NoteDAO) {

    fun getAllNote(): LiveData<List<DataNote>>{
        return data.getDataNote()
    }

    fun insertNote(note : DataNote){
        data.insertNote(note)
    }
    fun updateNote(note : DataNote){
        data.updateNote(note)
    }

}