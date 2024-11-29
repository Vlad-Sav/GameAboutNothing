package kg.savchenkodev.gameaboutnothing.data.storage

import android.content.Context
import android.content.res.AssetManager
import com.google.gson.GsonBuilder
import kg.savchenkodev.gameaboutnothing.data.storage.type_adapters.EnumTypeAdapter
import kg.savchenkodev.gameaboutnothing.domain.LevelState
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class JsonFileReader(private val context: Context) {
    fun <T> readFile(fileName: String, model: Class<Array<T>>): List<T> {
        return try {
            val assetManager: AssetManager = context.assets
            val inputStream: InputStream = assetManager.open(fileName)
            val jsonString: String = convertStreamToString(inputStream)
            inputStream.close()
            val gson = GsonBuilder()
                .registerTypeAdapter(LevelState::class.java, EnumTypeAdapter(LevelState::class.java))
                .create()

            gson.fromJson(jsonString, model).toList()
        } catch (e: Exception) {
            e.printStackTrace()
            listOf()
        }
    }

    private fun convertStreamToString(inputStream: InputStream): String {
        val sb = StringBuilder()
        var line: String?

        val br = BufferedReader(InputStreamReader(inputStream))
        line = br.readLine()

        while (line != null) {
            sb.append(line)
            line = br.readLine()
        }
        br.close()

        return sb.toString()
    }
}