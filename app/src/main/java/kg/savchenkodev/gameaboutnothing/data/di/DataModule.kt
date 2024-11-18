package kg.savchenkodev.gameaboutnothing.data.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kg.savchenkodev.gameaboutnothing.data.repository_impl.LevelsRepositoryImpl
import kg.savchenkodev.gameaboutnothing.data.storage.JsonFileReader
import kg.savchenkodev.gameaboutnothing.domain.repository.LevelsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideJsonReader(@ApplicationContext context: Context): JsonFileReader {
        return JsonFileReader(context)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {
    @Binds
    abstract fun bindLevelsRepository(impl: LevelsRepositoryImpl): LevelsRepository
}