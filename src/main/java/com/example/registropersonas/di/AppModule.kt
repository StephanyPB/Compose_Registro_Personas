package com.example.registropersonas.di

import android.content.Context
import androidx.room.Room
import com.example.registropersonas.data.OcupacionDao
import com.example.registropersonas.data.PersonaDao
import com.example.registropersonas.data.PersonasDb
import com.example.registropersonas.data.repository.OcupacionRepository
import com.example.registropersonas.data.repository.PersonaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPersonasDb(@ApplicationContext context: Context):PersonasDb{
        return  Room.databaseBuilder(
            context,
            PersonasDb::class.java,
            "PersonasDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesOcupacionDao(personasDb:PersonasDb): OcupacionDao {
        return personasDb.ocupacionDao
    }

    @Provides
    fun providesPersonaDao(personasDb: PersonasDb): PersonaDao {
        return  personasDb.personaDao
    }

    @Provides
    fun providesOcupacionRepository(ocupacionDao: OcupacionDao): OcupacionRepository {
        return  OcupacionRepository(ocupacionDao)
    }

    @Provides
    fun providesPersonaRepository(personaDao: PersonaDao): PersonaRepository {
        return  PersonaRepository(personaDao)
    }
}