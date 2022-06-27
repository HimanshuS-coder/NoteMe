package com.example.noteme

import androidx.room.*

// Here Dao means Data Access Object, where we write all the queries regarding our database
@Dao
interface NoteDao {

    // This insert will insert our tuples similarly delete will delete that tuple
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note : Note)

    @Delete
    fun delete(note: Note)

    @Query("Select * From notes_table Order By id ASC")
    fun getAllNotes(): List<Note>
}