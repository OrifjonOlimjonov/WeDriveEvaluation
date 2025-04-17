package uz.orifjon.wedrivetask.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.orifjon.wedrivetask.ui.theme.CardEndColor
import uz.orifjon.wedrivetask.ui.theme.CardStartColor
import uz.orifjon.wedrivetask.ui.theme.roundedShape16

@Composable
fun CardView(
    modifier: Modifier = Modifier,
    title: String = "Balance",
    textBody: String = "0,000.00"
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .clip(roundedShape16)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        CardStartColor,
                        CardEndColor
                    )
                )
            )
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                title, color = White, modifier = Modifier
                    .padding(top = 8.dp, start = 8.dp)
//                    .align(Alignment.TopStart)
            )

            Text(
                textBody,
                color = White,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 8.dp)
//                    .align(alignment = Alignment.CenterStart)
            )
        }


    }

}