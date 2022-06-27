package com.example.noteme

import androidx.lifecycle.LiveData
import androidx.room.*

// Here Dao means Data Access Object, where we write all the queries regarding our database
@Dao
interface NoteDao {

    // This insert will insert our tuples similarly delete will delete that tuple
    // Insert and Delete operations are a little heavy tasks so if we make them work on the MAIN THREAD then there is a possibility that our app
    // becomes slow at that particular time bcoz these are heavy tasks, So in order to solve this problem what we have to do is that we have to make them work
    // in background so that it doesn't interfere with our main thread, So in order to do that we'll use kotlin coroutines, it is kind of async feature.
    // So to do that just add "suspend" keyword before the methods.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note : Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("Select * From notes_table Order By id ASC")
    fun getAllNotes(): LiveData<List<Note>>
}

// LIVE DATA is an observeable data holder class. Through this we can know when our list is updating and we can observe it.