package uz.orifjon.wedrivetask.ui.core

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Spacer4() {
    Spacer(modifier = Modifier.size(4.dp))
}

@Composable
fun Spacer8() {
    Spacer(modifier = Modifier.size(8.dp))
}


@Composable
fun Spacer16() {
    Spacer(modifier = Modifier.size(16.dp))
}


@Composable
fun Spacer32() {
    Spacer(modifier = Modifier.size(32.dp))
}


@Composable
fun RowScope.FillEmptySpace() = Spacer(
    Modifier
        .fillMaxWidth()
        .weight(1f)
)

@Composable
fun ColumnScope.FillEmptySpace() = Spacer(
    Modifier
        .fillMaxHeight()
        .weight(1f)
)