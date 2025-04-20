package uz.orifjon.wedrivetask.cache.manager

import android.content.Context
import android.content.SharedPreferences

fun Context.getPrefs(fileName: String? = null): SharedPreferences {
    val name = if (fileName.isNullOrEmpty()) {
        getDefaultSharedPrefName()
    } else {
        "${this.packageName}$fileName"
    }
    return this.getSharedPreferences(
        name,
        Context.MODE_PRIVATE
    )
}

fun Context.getDefaultSharedPrefName(): String {
    return this.packageName + "_pref"
}