package com.example.notesapplofcoding.repositories

import com.example.notesapplofcoding.data.Note
import com.example.notesapplofcoding.data.db.NotesDatabase

class NotesRepo (
    notesDatabase : NotesDatabase
){
    val nodeDao=notesDatabase.nodeDao
    suspend fun upsertNote(note: Note)= nodeDao.upsertNote(note)
    suspend fun deleteNote(note: Note) = nodeDao.deleteNote(note)
    fun getNotes() = nodeDao.selectNotes()
    fun searchNotes(searchQuery: String)=nodeDao.searchInNotesTitle(searchQuery)
    suspend fun deleteAllNotes()=nodeDao.deleteAllNotes()

}