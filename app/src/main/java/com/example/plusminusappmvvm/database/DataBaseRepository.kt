package com.example.plusminusappmvvm.database

import androidx.lifecycle.LiveData
import com.example.plusminusappmvvm.model.Note

interface DataBaseRepository {

    val readAll: LiveData<List<Note>>

    suspend fun create(note: Note, onSucess: ()-> Unit)

    suspend fun update(note: Note, onSucess: ()-> Unit)

    suspend fun delete(note: Note, onSucess: ()-> Unit)

}