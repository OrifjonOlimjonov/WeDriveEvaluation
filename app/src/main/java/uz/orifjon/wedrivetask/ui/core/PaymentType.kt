package uz.orifjon.wedrivetask.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.orifjon.wedrivetask.R
import uz.orifjon.wedrivetask.ui.theme.roundedShape12

@Composable
fun PaymentTypeView(
    modifier: Modifier = Modifier,
    text: String = "",
    icon: Int = R.drawable.ic_cash,
    onCheckedChanged: (Boolean) -> Unit
) {
    val checked = remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .clip(roundedShape12)
            .background(White)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .height(60.dp)
                .clip(roundedShape12)
                .background(Color(0xFFF7F8FC))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(icon), null, tint = Color.Unspecified)
            Spacer8()
            Text(text = text, color = Black)
            FillEmptySpace()
            Switch(
                checked = checked.value,
                onCheckedChange = {
                    checked.value = it
                }
            )
        }
    }
}