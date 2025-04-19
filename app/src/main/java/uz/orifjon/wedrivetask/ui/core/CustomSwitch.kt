package uz.orifjon.wedrivetask.ui.core

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true
) {
    val thumbOffset by animateDpAsState(
        targetValue = if (checked) 20.dp else 0.dp
    )

    val backgroundColor by animateColorAsState(
        targetValue = when {
            !enabled -> Color(0xFFEFEFF4)
            checked -> Color.Black
            else -> Color(0xFFEFEFF4)
        }
    )

    val thumbColor by animateColorAsState(
        targetValue = if (enabled) Color.White else Color(
            0xFFEFEFF4
        )
    )

    Box(
        modifier = Modifier
            .width(52.dp)
            .height(32.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .toggleable(
                value = checked,
                enabled = enabled,
                onValueChange = onCheckedChange
            )
            .padding(horizontal = 2.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .offset(x = thumbOffset)
                .size(28.dp)
                .background(thumbColor, CircleShape)
                .border(
                    width = if (enabled) 0.dp else 1.dp,
                    color = Color.LightGray,
                    shape = CircleShape
                )
        )
    }
}
