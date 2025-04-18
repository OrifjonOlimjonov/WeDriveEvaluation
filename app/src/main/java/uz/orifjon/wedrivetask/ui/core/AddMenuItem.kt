package uz.orifjon.wedrivetask.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.orifjon.wedrivetask.R
import uz.orifjon.wedrivetask.ui.theme.roundedShape12


@Composable
fun AddMenuItem(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.ic_card,
    text: Int = R.string.app_name,
) {

    Box(
        modifier = modifier
            .clip(roundedShape12)
            .background(White)
            .padding(8.dp)
            .shadow(1.dp,roundedShape12)
    ) {
        Row(
            modifier = Modifier
                .height(60.dp)
                .clip(roundedShape12)
                .background(Color(0xFFF7F8FC))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer8()
            Icon(painter = painterResource(icon), null, tint = Color.Unspecified)
            Spacer8()
            Text(text = stringResource(text), color = Black)
            FillEmptySpace()
            Icon(
                painter = painterResource(R.drawable.ic_chevrolet_right),
                null,
                tint = Color.Unspecified
            )
            Spacer8()
        }
    }

}