package uz.orifjon.wedrivetask.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
                .border(1.dp, Black, shape = roundedShape16)
                .padding(8.dp)
        ) {
            Icon(
                modifier = Modifier,
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null
            )
            Text("Identification Required")
            Icon(
                modifier = Modifier,
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null
            )

        }
    }

}