package com.example.noteme

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// By adding this annotation "entity" we have added it to the database with table name "notes_table"
@Entity(tableName = "notes_table")
class Note(@ColumnInfo(name = "text") val text : String) {
    @PrimaryKey(autoGenerate = true) var id =0
}

// Now by default it will take column name as "text", we can also mention the column name explicitly
// Here we have also generated a primary key and here autogenerate means it will generate all the ids automatically
// Also we haven't mentioned the primary key in the constructor bcoz as it will autogenerate the ids so NO need to mention it
// in the constructor.