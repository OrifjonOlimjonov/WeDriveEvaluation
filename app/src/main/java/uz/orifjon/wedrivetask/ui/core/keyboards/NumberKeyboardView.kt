package uz.orifjon.wedrivetask.ui.core.keyboards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp

@Composable
fun NumberKeyboardView(
    onKeypad: (KeypadKey) -> Unit
) {

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .background(White),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Fixed(3)
    ) {
        items(getKeys()) {
            if(it != KeypadKey.Point)
            KeyView(
                keypad = it,
                onClick = onKeypad
            )
        }
    }

}

private fun getKeys(): List<KeypadKey> {
    val list = mutableListOf<KeypadKey>()
    for (i in 1..9) {
        list.add(KeypadKey.Number("$i"))
    }
    list.add(KeypadKey.Point)
    list.add(KeypadKey.Number("0"))
    list.add(KeypadKey.Delete)
    return list
}