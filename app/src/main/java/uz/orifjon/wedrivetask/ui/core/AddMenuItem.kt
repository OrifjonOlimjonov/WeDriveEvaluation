package uz.orifjon.wedrivetask.ui.core

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import uz.orifjon.wedrivetask.R


@Composable
fun AddMenuItem(
    modifier: Modifier = Modifier
) {

    Row {
        Icon(painter = painterResource(R.drawable.ic_card), null, tint = Color.Unspecified)
        Text("0sdsad")
        Icon(painter = painterResource(R.drawable.ic_launcher_background), null)
    }

}