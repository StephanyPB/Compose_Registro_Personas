package com.example.registropersonas.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Personas")
@Parcelize
data class Persona(
    @PrimaryKey(autoGenerate = true)
    val personaId: Int=0,
    val nombres: String,
    val email : String="",
    val ocupacionId : Int=0,
    val salario: Float=0f
): Parcelable