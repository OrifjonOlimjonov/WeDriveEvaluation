package uz.orifjon.wedrivetask.ui.screens.home.adding_card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import uz.orifjon.wedrivetask.R
import uz.orifjon.wedrivetask.ui.core.AppBar
import uz.orifjon.wedrivetask.ui.core.CardView
import uz.orifjon.wedrivetask.ui.core.FillEmptySpace
import uz.orifjon.wedrivetask.ui.core.IdentificationRequiredView
import uz.orifjon.wedrivetask.ui.core.Spacer16
import uz.orifjon.wedrivetask.ui.core.Spacer32
import uz.orifjon.wedrivetask.ui.core.Spacer8
import uz.orifjon.wedrivetask.ui.core.SpacerStatusBarPadding
import uz.orifjon.wedrivetask.ui.core.keyboards.KeypadKey
import uz.orifjon.wedrivetask.ui.core.keyboards.NumberKeyboardView
import uz.orifjon.wedrivetask.ui.theme.CardBackgroundColor
import uz.orifjon.wedrivetask.ui.theme.roundedShape12
import uz.orifjon.wedrivetask.ui.theme.roundedShape16
import uz.orifjon.wedrivetask.ui.theme.roundedShape5


@Serializable
data object AddingCardRoute

@Composable
fun AddingCardScreen(
    navController: NavController,
    viewModel: AddingCardViewModel = koinViewModel()
) {


    val state = viewModel.state.collectAsState().value


    Scaffold(
        topBar = {
            AddingCardTopBar(onClickBack = navController::popBackStack)
        },
        content = { paddingValues ->
            AddingCardContent(
                paddingValues,
                state = state,
                onKeypad = viewModel::onKeypadKey,
                onCardNumberValueChange = viewModel::changeCardNumberValue,
                onExpiredDateValueChange = viewModel::changeExpiredDateValue
            )
        }
    )


}


@Composable
fun AddingCardContent(
    paddingValues: PaddingValues, state: AddingCardState,
    onKeypad: (KeypadKey) -> Unit,
    onCardNumberValueChange: (String) -> Unit,
    onExpiredDateValueChange: (String) -> Unit
) {
    Box(modifier = Modifier.padding(paddingValues)) {
        CardInputView(
            state,
            onCardNumberValueChange = onCardNumberValueChange,
            onExpiredDateValueChange = onExpiredDateValueChange,
            onKeypad = onKeypad
        )
    }
}

@Composable
private fun CardInputView(
    state: AddingCardState,
    onCardNumberValueChange: (String) -> Unit,
    onExpiredDateValueChange: (String) -> Unit,
    onKeypad: (KeypadKey) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(150.dp)
            .background(White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .border(2.dp, White, roundedShape16)
                .shadow(1.dp, roundedShape16)
                .background(CardBackgroundColor, shape = roundedShape16)
                .padding(8.dp)
        ) {

            Column {
                OutlinedTextField(
                    value = state.cardNumber,
                    onValueChange = onCardNumberValueChange,
                    shape = roundedShape16,
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true
                )
                OutlinedTextField(
                    value = state.expiredDate,
                    onValueChange = onExpiredDateValueChange,
                    shape = roundedShape16,
                    modifier = Modifier.width(100.dp),
                    readOnly = true
                )
            }
        }
        FillEmptySpace()
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            content = {
                Text(stringResource(R.string.save), color = White)
            }, onClick = {

            },
            shape = roundedShape12,
            colors = ButtonDefaults.buttonColors(
                containerColor = Black
            )
        )
        Spacer32()
        NumberKeyboardView(onKeypad = onKeypad)

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddingCardTopBar(
    onClickBack: () -> Unit,
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(White),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer16()
            FloatingActionButton(
                modifier = Modifier
                    .size(40.dp)
                    .background(White, CircleShape),
                shape = CircleShape,
                containerColor = White,
                onClick = onClickBack
            ) {
                Icon(painter = painterResource(R.drawable.ic_arrow_left), null, tint = Black)
            }
            Spacer8()
            Text(
                "Add Card",
                color = Black,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.figtree_medium))
            )
        }
    }
}