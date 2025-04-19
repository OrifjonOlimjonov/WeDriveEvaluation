package uz.orifjon.wedrivetask.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import uz.orifjon.wedrivetask.R
import uz.orifjon.wedrivetask.ui.core.AddMenuItem
import uz.orifjon.wedrivetask.ui.core.AppBar
import uz.orifjon.wedrivetask.ui.core.BottomSheetShape
import uz.orifjon.wedrivetask.ui.core.CardView
import uz.orifjon.wedrivetask.ui.core.IdentificationRequiredView
import uz.orifjon.wedrivetask.ui.core.PaymentTypeView
import uz.orifjon.wedrivetask.ui.core.Spacer8
import uz.orifjon.wedrivetask.ui.screens.home.adding_card.AddingCardRoute
import uz.orifjon.wedrivetask.ui.screens.home.adding_card.AddingCardScreen
import uz.orifjon.wedrivetask.ui.screens.home.adding_promo_code.AddingPromoCodeBottomSheet


@Serializable
data object HomeRoute


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = koinViewModel()
) {

    val state = viewModel.state.collectAsState()

    val promoCodeBottomSheetState = rememberModalBottomSheetState(true)
    val coroutineScope = rememberCoroutineScope()

    if (state.value.promoCodeBottomSheetState) {
        BottomSheetShape(
            sheetState = promoCodeBottomSheetState,
            onDismiss = {
                coroutineScope.launch {
                    promoCodeBottomSheetState.hide()
                }.invokeOnCompletion {
                    if (!promoCodeBottomSheetState.isVisible) {
                        viewModel.onBottomSheet()
                    }
                }
            }
        ) {
            AddingPromoCodeBottomSheet(onSavePromoCodeClick = { code ->
                viewModel.addPromoCode(code)
            })
        }
    }


    Scaffold(
        topBar = {
            AppBar(
                titleStr = stringResource(R.string.wallet)
            )
        },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                MainContent(
                    onNavigateAddingCard = {
                        navController.navigate(AddingCardRoute)
                    },
                    onPromoCodeBottomSheet = {
                        viewModel.onBottomSheet()
                    })
            }
        }
    )

}

@Composable
private fun MainContent(
    onNavigateAddingCard: () -> Unit,
    onPromoCodeBottomSheet: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        CardView(
            title = stringResource(R.string.balance),
            textBody = "0,000.00"
        )

        Spacer8()


        IdentificationRequiredView()

        AddMenuItem(
            text = R.string.add_promo_code,
            icon = R.drawable.ic_promokod,
            onClickListener = onPromoCodeBottomSheet
        )
        PaymentTypeView(icon = R.drawable.ic_cash, text = stringResource(R.string.cash)) {}
        PaymentTypeView(
            icon = R.drawable.ic_card,
            text = stringResource(R.string.card_with_last_number, "7777")
        ) {}
        AddMenuItem(
            text = R.string.add_new_card,
            icon = R.drawable.ic_add_card,
            onClickListener = onNavigateAddingCard

        )
    }

}