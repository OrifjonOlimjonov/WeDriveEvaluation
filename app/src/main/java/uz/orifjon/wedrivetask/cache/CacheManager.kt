package uz.orifjon.wedrivetask.cache
interface CacheManager {

    fun readString(key: String, defaultValue: String?): String?
    fun readBoolean(key: String, defaultValue: Boolean): Boolean
    fun readInt(key: String, defaultValue: Int): Int
    fun readLong(key: String, defaultValue: Long): Long

    fun writeString(key: String, value: String?): String?
    fun writeBoolean(key: String, value: Boolean): Boolean
    fun writeInt(key: String, value: Int): Int
    fun writeLong(key: String, value: Long): Long

    fun clear(key: String)

    fun clearAll()

    fun clearEverything(callBack: () -> Unit)

}