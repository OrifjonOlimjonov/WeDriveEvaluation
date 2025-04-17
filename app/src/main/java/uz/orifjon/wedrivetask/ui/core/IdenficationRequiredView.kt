package uz.orifjon.wedrivetask.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.orifjon.wedrivetask.R
import uz.orifjon.wedrivetask.ui.theme.roundedShape16

@Composable
fun IdentificationRequiredView(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .clip(roundedShape16)
            .background(White)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .height(72.dp)
                .border(1.dp, Black, shape = roundedShape16)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier,
                painter = painterResource(R.drawable.ic_info_circle),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Identification Required", color = Black)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier,
                painter = painterResource(R.drawable.ic_arrow_up_right),
                contentDescription = null,
                tint = Color.Unspecified
            )

        }
    }

}