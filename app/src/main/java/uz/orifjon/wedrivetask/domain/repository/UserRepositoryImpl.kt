package uz.orifjon.wedrivetask.domain.repository

import uz.orifjon.wedrivetask.cache.preferences.UserPreferences
import uz.orifjon.wedrivetask.data.models.user.UserRequest
import uz.orifjon.wedrivetask.data.repository.UserRepository
import uz.orifjon.wedrivetask.network.service.user.ApiUserService

class UserRepositoryImpl(
    private val apiUserService: ApiUserService,
    private val userPreferences: UserPreferences
) : UserRepository {

    override suspend fun login(phoneNumber: String) {

        val userRequest = UserRequest(phone = phoneNumber)

        apiUserService.login(userRequest)

        userPreferences.phoneNumber = phoneNumber

    }


}