package uz.orifjon.wedrivetask.ui.core

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import uz.orifjon.wedrivetask.R

@Composable
fun PaymentTypeView(
    modifier: Modifier = Modifier,
    onCheckedChanged: (Boolean) -> Unit
) {

    Row {
        Icon(painter = painterResource(R.drawable.ic_launcher_background), null)
        Text("salom")
        Switch(
            checked = false,
            onCheckedChange = onCheckedChanged

        )
    }
}