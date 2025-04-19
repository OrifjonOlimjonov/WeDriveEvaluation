package uz.orifjon.wedrivetask.network.service.user

import io.ktor.client.HttpClient
import io.ktor.client.request.setBody
import uz.orifjon.wedrivetask.data.models.user.UserRequest
import uz.orifjon.wedrivetask.utils.extensions.postJson

class ApiUserServiceImpl(
    private val httpClient: HttpClient
) : ApiUserService {

    override suspend fun login(userRequest: UserRequest) {
        httpClient.postJson<Unit>(POST_USER) {
            setBody(userRequest)
        }
    }

}

const val POST_USER = "users"