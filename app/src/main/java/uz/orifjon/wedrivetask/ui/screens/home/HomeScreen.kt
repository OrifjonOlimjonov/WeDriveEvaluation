package uz.orifjon.wedrivetask.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import uz.orifjon.wedrivetask.R
import uz.orifjon.wedrivetask.ui.core.AddMenuItem
import uz.orifjon.wedrivetask.ui.core.AppBar
import uz.orifjon.wedrivetask.ui.core.CardView
import uz.orifjon.wedrivetask.ui.core.IdentificationRequiredView
import uz.orifjon.wedrivetask.ui.core.PaymentTypeView


@Serializable
data object HomeRoute


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = koinViewModel()
) {

    val state = viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            AppBar(
                titleStr = stringResource(R.string.wallet)
            )
        },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                MainContent()
            }
        }
    )

}

@Composable
private fun MainContent() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        CardView(
            title = "Balance",
            textBody = "0,000.00"
        )

        Spacer(modifier = Modifier.height(8.dp))


        IdentificationRequiredView()

        AddMenuItem()
        PaymentTypeView {

        }
    }

}