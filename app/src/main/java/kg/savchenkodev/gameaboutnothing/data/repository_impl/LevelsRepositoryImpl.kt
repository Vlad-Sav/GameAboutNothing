package kg.savchenkodev.gameaboutnothing.data.repository_impl

import kg.savchenkodev.gameaboutnothing.data.storage.JsonFileReader
import kg.savchenkodev.gameaboutnothing.game_domain.Level
import kg.savchenkodev.gameaboutnothing.game_domain.repository.LevelsRepository
import javax.inject.Inject

class LevelsRepositoryImpl @Inject constructor(
    private val gsonFileReader: JsonFileReader
): LevelsRepository  {
     override suspend fun getLevels(): List<Level> {
        val result = readFile("levels.json", Array<Level>::class.java)
        return result.toList()
    }

    private fun <T> readFile(fileName: String, clazz: Class<Array<T>>): List<T> =
        gsonFileReader.readFile(fileName, clazz).toList()
}