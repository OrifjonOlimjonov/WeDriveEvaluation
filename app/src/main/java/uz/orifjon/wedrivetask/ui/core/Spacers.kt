package uz.orifjon.wedrivetask.ui.core

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Spacer2() {
    Spacer(modifier = Modifier.size(2.dp))
}

@Composable
fun Spacer4() {
    Spacer(modifier = Modifier.size(4.dp))
}

@Composable
fun Spacer8() {
    Spacer(modifier = Modifier.size(8.dp))
}

@Composable
fun Spacer10() {
    Spacer(modifier = Modifier.size(10.dp))
}

@Composable
fun Spacer12() {
    Spacer(modifier = Modifier.size(12.dp))
}

@Composable
fun Spacer16() {
    Spacer(modifier = Modifier.size(16.dp))
}

@Composable
fun Spacer20() {
    Spacer(modifier = Modifier.size(20.dp))
}

@Composable
fun Spacer24() {
    Spacer(modifier = Modifier.size(24.dp))
}

@Composable
fun Spacer30() {
    Spacer(modifier = Modifier.size(30.dp))
}

@Composable
fun Spacer32() {
    Spacer(modifier = Modifier.size(32.dp))
}

@Composable
fun Spacer35() {
    Spacer(modifier = Modifier.size(35.dp))
}

@Composable
fun Spacer60() {
    Spacer(modifier = Modifier.size(60.dp))
}

@Composable
fun SpacerWidth70(){
    Spacer(modifier = Modifier.width(70.dp))
}

@Composable
fun SpacerWidth80(){
    Spacer(modifier = Modifier.width(80.dp))
}

@Composable
fun SpacerStatusBarPadding() {
    val topStatusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    Spacer(modifier = Modifier.size(topStatusBarHeight))
}

@Composable
fun SpacerBottomBarPadding() {
    val bottomBarHeight = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
    Spacer(modifier = Modifier.size(bottomBarHeight))
}

@Composable
fun RowScope.FillEmptySpace() = Spacer(
    Modifier
        .fillMaxWidth()
        .weight(1f))

@Composable
fun ColumnScope.FillEmptySpace() = Spacer(
    Modifier
        .fillMaxHeight()
        .weight(1f))