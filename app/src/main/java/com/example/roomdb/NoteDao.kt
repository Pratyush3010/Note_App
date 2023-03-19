package com.example.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("select * from notesTable order by id ASC")
    fun  getAllNotes() : LiveData<List<Note>>

    @Update
    suspend fun update(note: Note)

}