package com.example.noteme

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// In the entities section we add all the entities that we have created so here we only have one entity/table so we'll enter that only.
@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
public abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            // here this below statement means if instance is not null then it will return it else it will get inside the synchronized lock block.
            // Here a lock is applied so that multiple instances doesn't access the code at the same time.
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

// This is our database class which follows a SINGLETON Pattern.
// Singleton prevents multiple instances of database opening at the
// same time.