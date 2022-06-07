package com.example.registropersonas.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.registropersonas.model.Ocupacion
import com.example.registropersonas.model.Persona


@Database(
    entities = [
        Ocupacion::class,
        Persona::class
    ],
    exportSchema = false,
    version = 1
)
abstract class PersonasDb : RoomDatabase() {
    abstract val ocupacionDao: OcupacionDao
    abstract val personaDao: PersonaDao
}