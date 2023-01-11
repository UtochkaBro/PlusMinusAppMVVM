package com.example.plusminusappmvvm.database.room.repository

import androidx.lifecycle.LiveData
import com.example.plusminusappmvvm.database.DataBaseRepository
import com.example.plusminusappmvvm.database.room.dao.NoteRoomDao
import com.example.plusminusappmvvm.model.Note

class RoomRepository(private val noteRoomDao: NoteRoomDao) : DataBaseRepository {
    override val readAll: LiveData<List<Note>>
        get() = noteRoomDao.getAllNotes()

    override suspend fun create(note: Note, onSucess: () -> Unit) {
        noteRoomDao.addNote(note = note)
    }

    override suspend fun update(note: Note, onSucess: () -> Unit) {
        noteRoomDao.updateNote(note = note)
    }

    override suspend fun delete(note: Note, onSucess: () -> Unit) {
        noteRoomDao.deleteNote(note = note)
    }
}