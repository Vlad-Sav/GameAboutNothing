package kg.savchenkodev.gameaboutnothing.data.storage.type_adapters

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

class EnumTypeAdapter<T : Enum<T>>(private val enumClass: Class<T>) : TypeAdapter<T>() {
    override fun write(out: JsonWriter, value: T) {
        out.value(value.name)
    }

    override fun read(input: JsonReader): T {
        val enumValue = input.nextString()
        return java.lang.Enum.valueOf(enumClass, enumValue)
    }
}