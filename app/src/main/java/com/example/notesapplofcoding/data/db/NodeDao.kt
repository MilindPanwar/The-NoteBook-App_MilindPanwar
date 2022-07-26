package com.example.notesapplofcoding.data.db

import androidx.room.*
import com.example.notesapplofcoding.data.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NodeDao {


    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun upsertNote(note: Note) //it'll insert and if note exist already it will remove previous and insert new


    /*@Insert
    suspend fun insert(note: Note)*/
    //removing the update funtion
    //as update function can work in the insert function

    /*@Update
    suspend fun updateNote(note:Note)*/

    @Delete
    suspend fun deleteNote(note: Note)
    @Query("SELECT*FROM Note ORDER BY noteId DESC")
    fun selectNotes(): Flow<List<Note>>

    @Query("SELECT * FROM Note WHERE noteText LIKE '%'||:searchQuery||'%'")
    fun searchInNotesTitle(searchQuery: String) :Flow<List<Note>>

    @Query("DELETE FROM note")
    suspend fun deleteAllNotes()





}











