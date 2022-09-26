package com.example.challenge_chapter4.dao

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDAO {
    @Insert
    fun insertNote(note: DataNote)

    @Query(" SELECT * FROM datanote ORDER BY id DESC")
    fun getDataNote() : LiveData<List<DataNote>>

    @Delete
    fun deleteNote(note: DataNote) : Int

    @Update
    fun updateNote(note: DataNote)
}