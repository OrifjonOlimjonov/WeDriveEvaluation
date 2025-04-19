package uz.orifjon.wedrivetask.cache.manager

import android.content.Context
import android.content.SharedPreferences


//import android.os.Build
//import androidx.security.crypto.EncryptedSharedPreferences
//import androidx.security.crypto.MasterKey

fun Context.getPrefs(fileName: String? = null): SharedPreferences {
//    val masterKey = MasterKey.Builder(this)
//        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
//        .build()

    val name = if (fileName.isNullOrEmpty()) {
        getDefaultSharedPrefName()
    } else {
        "${this.packageName}$fileName"
    }


    return this.getSharedPreferences(
        name,
        Context.MODE_PRIVATE
    )
//    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//        EncryptedSharedPreferences.create(
//            this,
//            name,
//            masterKey,
//            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
//            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
//        )
//
//    } else {
//        this.getSharedPreferences(
//            name,
//            Context.MODE_PRIVATE
//        )
//    }
}

fun Context.getDefaultSharedPrefName(): String {
    return this.packageName + "_pref"
}