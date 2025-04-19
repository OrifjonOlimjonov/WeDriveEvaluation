package uz.orifjon.wedrivetask.domain.mappers

import uz.orifjon.wedrivetask.data.models.wallet.WalletResponse
import uz.orifjon.wedrivetask.domain.models.Wallet



fun List<WalletResponse>.toDomain() = map { it.toDomain() }

fun WalletResponse.toDomain() = Wallet(
    activeMethod = active_method,
    activeCardId = active_card_id,
    id = id,
    balance = balance,
    phone = phone
)