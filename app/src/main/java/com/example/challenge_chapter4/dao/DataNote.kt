package com.example.challenge_chapter4.dao

import android.view.View
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class DataNote(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var content: String
) : Serializable