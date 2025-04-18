package uz.orifjon.wedrivetask.ui.core.keyboards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.orifjon.wedrivetask.R


@Composable
fun KeyView(
    keypad: KeypadKey,
    onClick: (KeypadKey) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(32.dp)
            .clip(CircleShape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClick(keypad) },
                indication = null
            ),
        contentAlignment = Alignment.Center
    ) {
        when (keypad) {
            is KeypadKey.Number -> {
                Text(
                    text = keypad.number,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 24.sp
                )
            }

            KeypadKey.Delete -> {
                Icon(
                    painter = painterResource(id = R.drawable.ic_remove_text),
                    contentDescription = null
                )
            }

            KeypadKey.Point -> {

            }
        }
    }
}

sealed interface KeypadKey {
    data class Number(val number: String) : KeypadKey
    data object Point : KeypadKey
    data object Delete : KeypadKey
}