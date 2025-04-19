package uz.orifjon.wedrivetask.cache.preferences

import uz.orifjon.wedrivetask.cache.manager.CacheManager

class UserPreferences(
    private val cacheManager: CacheManager
) {

    var phoneNumber: String? = null
        get() {
            return cacheManager.readString("phoneNumber", "")
        }
        set(value) {
            cacheManager.writeString("phoneNumber", value)
            field = value
        }
}