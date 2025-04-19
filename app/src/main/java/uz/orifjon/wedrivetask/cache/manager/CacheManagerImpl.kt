package uz.orifjon.wedrivetask.cache.manager

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class CacheManagerImpl(
    context: Context,
    prefFileName: String?
) : CacheManager {

    private val prefs: SharedPreferences = context.getPrefs(
        prefFileName ?: context.getDefaultSharedPrefName()
    )

    override fun readString(key: String, defaultValue: String?) = prefs.getString(key, defaultValue)

    override fun readBoolean(key: String, defaultValue: Boolean) = prefs.getBoolean(key, defaultValue)

    override fun readInt(key: String, defaultValue: Int) = prefs.getInt(key, defaultValue)

    override fun readLong(key: String, defaultValue: Long) = prefs.getLong(key, defaultValue)

    override fun writeString(key: String, value: String?): String? {
        prefs.edit { putString(key, value).apply() }
        return value
    }

    override fun writeBoolean(key: String, value: Boolean): Boolean {
        prefs.edit { putBoolean(key, value).apply() }
        return value
    }

    override fun writeInt(key: String, value: Int): Int {
        prefs.edit { putInt(key, value).apply() }
        return value
    }

    override fun writeLong(key: String, value: Long): Long {
        prefs.edit { putLong(key, value).apply() }
        return value
    }

    override fun clear(key: String) = prefs.edit {
        remove(key)
    }

    override fun clearAll() {
        prefs.edit {
            clear().commit()
            apply()
        }
    }

    override fun clearEverything(callBack: () -> Unit) {
        prefs.edit {
            clear().commit()
            apply()
            callBack.invoke()
        }
    }
}