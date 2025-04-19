package uz.orifjon.wedrivetask.network.service.user

import uz.orifjon.wedrivetask.data.models.user.UserRequest

interface ApiUserService {

    suspend fun login(userRequest: UserRequest)

}