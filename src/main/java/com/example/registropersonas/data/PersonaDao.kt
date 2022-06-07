package com.example.registropersonas.data

import androidx.room.*
import com.example.registropersonas.model.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(persona: Persona)

    @Delete
    suspend fun eliminar(persona: Persona)

    @Query("""
        SELECT * 
        FROM Personas
        WHERE personaId=:personaId     """)
    fun buscar(personaId: Int): Flow<Persona>

    @Query("""
        SELECT * 
        FROM Personas
        ORDER BY personaId """)
    fun getList(): Flow<List<Persona>>
}