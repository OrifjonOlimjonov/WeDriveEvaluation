package uz.orifjon.wedrivetask.ui.core
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetShape(
    cornerSize: Int = 20,
    paddingSize: Int = 0,
    onDismiss: () -> Unit = {},
    sheetState: SheetState = rememberModalBottomSheetState(true),
    alignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable (ColumnScope) -> Unit
) {
    ModalBottomSheet(
        containerColor = Color.Transparent,
        dragHandle = {},
        onDismissRequest = onDismiss,
        sheetState = sheetState,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .padding(paddingSize.dp)
                .clip(RoundedCornerShape(topEnd = cornerSize.dp, topStart = cornerSize.dp))
                .background(MaterialTheme.colorScheme.primary),
            horizontalAlignment = alignment
        ) {
            content(this)
        }
        Spacer(modifier = Modifier.windowInsetsBottomHeight(WindowInsets.systemBars))
    }
}