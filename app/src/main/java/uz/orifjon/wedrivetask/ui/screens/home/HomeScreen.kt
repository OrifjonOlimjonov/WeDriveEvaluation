package uz.orifjon.wedrivetask.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import uz.orifjon.wedrivetask.R
import uz.orifjon.wedrivetask.domain.mappers.PaymentType
import uz.orifjon.wedrivetask.ui.core.AddMenuItem
import uz.orifjon.wedrivetask.ui.core.AppBar
import uz.orifjon.wedrivetask.ui.core.BottomSheetShape
import uz.orifjon.wedrivetask.ui.core.CardView
import uz.orifjon.wedrivetask.ui.core.IdentificationRequiredView
import uz.orifjon.wedrivetask.ui.core.PaymentTypeView
import uz.orifjon.wedrivetask.ui.core.Spacer8
import uz.orifjon.wedrivetask.ui.screens.home.adding_card.AddingCardNavResult
import uz.orifjon.wedrivetask.ui.screens.home.adding_card.AddingCardRoute
import uz.orifjon.wedrivetask.ui.screens.home.adding_promo_code.AddingPromoCodeBottomSheet
import uz.orifjon.wedrivetask.utils.DEFAULT_BALANCE
import uz.orifjon.wedrivetask.utils.extensions.formatPrice
import uz.orifjon.wedrivetask.utils.extensions.onNavResult


@Serializable
data object HomeRoute


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = koinViewModel()
) {

    val state = viewModel.state.collectAsState().value
    val context = LocalContext.current
    val promoCodeBottomSheetState = rememberModalBottomSheetState(true)
    val coroutineScope = rememberCoroutineScope()

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    navController.onNavResult<AddingCardNavResult> { result ->
        viewModel.updateCardList()
    }
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                HomeScreenEvent.AfterFailurePromoCode -> {
                    snackbarHostState.showSnackbar(message = context.getString(R.string.promo_code_failed))
                }

                HomeScreenEvent.AfterSuccessPromoCode -> {
                    snackbarHostState.showSnackbar(message = context.getString(R.string.promo_code_activated))
                }

                HomeScreenEvent.AfterChangePaymentMethodFailure -> {
                    Toast.makeText(
                        context,
                        context.getString(R.string.payment_method_change_problem),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                HomeScreenEvent.AfterChangePaymentMethodSuccess -> {
                    snackbarHostState.showSnackbar(message = context.getString(R.string.successfully_change))
                }
            }
        }
    }

    if (state.promoCodeBottomSheetState) {
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
            }, onBack = {
                viewModel.onBottomSheet()
            })
        }
    }


    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            AppBar(
                titleStr = stringResource(R.string.wallet),
                scrollBehavior = scrollBehavior
            )
        },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                MainContent(
                    state = state,
                    viewModel = viewModel,
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
    state: HomeScreenState,
    viewModel: HomeScreenViewModel,
    onNavigateAddingCard: () -> Unit,
    onPromoCodeBottomSheet: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        LazyColumn {
            item {
                CardView(
                    title = stringResource(R.string.balance),
                    textBody = state.wallet?.balance?.formatPrice() ?: DEFAULT_BALANCE
                )
                Spacer8()
                IdentificationRequiredView()
                AddMenuItem(
                    text = R.string.add_promo_code,
                    icon = R.drawable.ic_promokod,
                    onClickListener = onPromoCodeBottomSheet
                )
                PaymentTypeView(
                    icon = R.drawable.ic_cash, text = stringResource(R.string.cash),
                    checked = viewModel.isCash()
                ) {
                    viewModel.changePaymentType(
                        cardId = null,
                        paymentType = PaymentType.cash
                    )
                }
            }
            items(state.cards) { card ->
                PaymentTypeView(
                    icon = R.drawable.ic_card,
                    text = stringResource(
                        R.string.card_with_last_number,
                        card.cardNumber.substring(12, 16)
                    ),
                    checked = viewModel.isChecked(card)
                ) {
                    viewModel.changePaymentType(
                        cardId = card.cardId,
                        paymentType = PaymentType.card
                    )
                }
            }
            item {
                AddMenuItem(
                    text = R.string.add_new_card,
                    icon = R.drawable.ic_add_card,
                    onClickListener = onNavigateAddingCard
                )
            }
        }
    }
}