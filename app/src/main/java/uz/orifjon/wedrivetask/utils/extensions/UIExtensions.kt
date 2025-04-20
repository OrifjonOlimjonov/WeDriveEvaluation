package uz.orifjon.wedrivetask.utils.extensions

import java.math.RoundingMode
import java.text.DecimalFormat


fun Double.formatPrice(): String {
    val formatter = DecimalFormat("##0,000.00")
    formatter.roundingMode = RoundingMode.DOWN
    return formatter.format(this)
}
