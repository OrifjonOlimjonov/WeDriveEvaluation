package uz.orifjon.wedrivetask.ui.core

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import uz.orifjon.wedrivetask.R

@Composable
fun PaymentTypeView(
    modifier: Modifier = Modifier,
    onCheckedChanged: (Boolean) -> Unit
) {
    val checked = remember { mutableStateOf(false) }
    Row {
        Icon(painter = painterResource(R.drawable.ic_cash), null, tint = Color.Unspecified)
        Text("salom")
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = checked.value,
            onCheckedChange = {
                checked.value = it
            }
        )
    }
}