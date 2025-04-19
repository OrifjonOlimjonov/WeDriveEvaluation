package uz.orifjon.wedrivetask.data.repository

interface UserRepository {


    suspend fun login(phoneNumber: String)

}