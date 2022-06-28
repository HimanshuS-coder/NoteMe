package com.example.noteme

import androidx.lifecycle.LiveData
import java.util.concurrent.Flow

class NoteRepository(private val noteDao : NoteDao) {

    val allNotes : LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note : Note)
    {
        noteDao.insert(note)
    }

    suspend fun delete(note: Note)
    {
        noteDao.delete(note)
    }
}