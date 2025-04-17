package uz.orifjon.wedrivetask.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.orifjon.wedrivetask.ui.theme.roundedShape16

@Composable
fun CardView(
    modifier: Modifier = Modifier,
    title: String = "",
    textBody: String = ""
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .clip(roundedShape16)
            .background(color = Black)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(title, color = White)
            Text(textBody, color = White, fontSize = 18.sp)
        }
    }

}