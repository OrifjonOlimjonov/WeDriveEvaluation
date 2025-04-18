package uz.orifjon.wedrivetask.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import uz.orifjon.wedrivetask.R
import uz.orifjon.wedrivetask.ui.theme.White80


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    titleStr: String = "",
    navigationIcon: Int? = null,
    onNavigationClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(text = titleStr, color = Black, fontFamily = FontFamily(Font(R.font.figtree_bold)))
        },
        navigationIcon = {
            if (navigationIcon != null) {
                Surface(shadowElevation = 4.dp, shape = CircleShape){
                    IconButton(
                        modifier = Modifier.background(White80),onClick = onNavigationClick) {
                        Icon(
                            painter = painterResource(id = navigationIcon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                        )
                    }
                }
            }
        },
        actions = actions,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = White
        )
    )
}