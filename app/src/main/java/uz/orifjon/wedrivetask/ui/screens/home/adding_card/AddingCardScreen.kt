package uz.orifjon.wedrivetask.ui.screens.home.adding_card

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import uz.orifjon.wedrivetask.R
import uz.orifjon.wedrivetask.ui.core.FillEmptySpace
import uz.orifjon.wedrivetask.ui.core.MaskVisualTransformation
import uz.orifjon.wedrivetask.ui.core.Spacer16
import uz.orifjon.wedrivetask.ui.core.Spacer32
import uz.orifjon.wedrivetask.ui.core.Spacer8
import uz.orifjon.wedrivetask.ui.core.keyboards.KeypadKey
import uz.orifjon.wedrivetask.ui.core.keyboards.NumberKeyboardView
import uz.orifjon.wedrivetask.ui.theme.CardBackgroundColor
import uz.orifjon.wedrivetask.ui.theme.roundedShape12
import uz.orifjon.wedrivetask.ui.theme.roundedShape16
import uz.orifjon.wedrivetask.utils.AddingType
import uz.orifjon.wedrivetask.utils.CARD_NUMBER
import uz.orifjon.wedrivetask.utils.CARD_NUMBER_HINT
import uz.orifjon.wedrivetask.utils.EXPIRED_DATE
import uz.orifjon.wedrivetask.utils.EXPIRED_DATE_HINT
import uz.orifjon.wedrivetask.utils.extensions.navigateBack


@Serializable
data object AddingCardRoute

@Composable
fun AddingCardScreen(
    navController: NavController,
    viewModel: AddingCardViewModel = koinViewModel()
) {

    val context = LocalContext.current

    val state = viewModel.state.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is AddingCardEvent.AfterFailedAddedNewCard -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }
                is AddingCardEvent.AfterSuccessfullyAddedNewCard -> {
                    navController.navigateBack(
                        AddingCardNavResult(
                            event.newCard
                        )
                    )
                }
            }
        }
    }

    Scaffold(
        topBar = {
            AddingCardTopBar(onClickBack = navController::popBackStack)
        },
        content = { paddingValues ->
            AddingCardContent(
                paddingValues,
                state = state,
                onClickSave = viewModel::onClickSave,
                enabled = viewModel.checkInputNotEmpty(),
                onKeypad = viewModel::onKeypadKey,
                onChangeValueType = viewModel::changeInputDataType
            )
        }
    )


}


@Composable
private fun AddingCardContent(
    paddingValues: PaddingValues, state: AddingCardState,
    enabled: Boolean,
    onClickSave: () -> Unit,
    onKeypad: (KeypadKey) -> Unit,
    onChangeValueType: (AddingType) -> Unit
) {
    Box(modifier = Modifier.padding(paddingValues)) {
        CardInputView(
            state,
            enabled = enabled,
            onClickSave = onClickSave,
            onChangeValueType = onChangeValueType,
            onKeypad = onKeypad
        )
    }
}

@Composable
private fun CardInputView(
    state: AddingCardState,
    enabled: Boolean,
    onClickSave: () -> Unit,
    onChangeValueType: (AddingType) -> Unit,
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

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .border(2.dp, White, roundedShape16)
                .shadow(1.dp, roundedShape16)
                .background(CardBackgroundColor, shape = roundedShape16)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            ItemDataInputTextField(
                value = state.cardNumber,
                onValueChange = { },
                onEdit = { onChangeValueType(AddingType.CARD) },
                enabled = false,
                hint = CARD_NUMBER_HINT,
                visualTransformation = MaskVisualTransformation(CARD_NUMBER),
                inputType = AddingType.CARD
            )
            Spacer16()
            ItemDataInputTextField(
                value = state.expiredDate,
                onValueChange = { },
                onEdit = { onChangeValueType(AddingType.EXPIRED_DATE) },
                enabled = false,
                hint = EXPIRED_DATE_HINT,
                visualTransformation = MaskVisualTransformation(EXPIRED_DATE),
                inputType = AddingType.EXPIRED_DATE
            )
        }
        FillEmptySpace()
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            content = {
                Text(stringResource(R.string.save), color = White)
            }, onClick = onClickSave,
            shape = roundedShape12,
            colors = ButtonDefaults.buttonColors(
                containerColor = Black
            ),
            enabled = enabled
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
                stringResource(R.string.add_card),
                color = Black,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.figtree_medium))
            )
        }
    }
}


@Composable
private fun ItemDataInputTextField(
    value: String,
    modifier: Modifier = Modifier,
    isWriting: Boolean = false,
    hint: String,
    onValueChange: (String) -> Unit,
    visualTransformation: MaskVisualTransformation,
    enabled: Boolean = true,
    onEdit: () -> Unit,
    inputType: AddingType
) {
    val textStyle = LocalTextStyle.current.copy(color = Black)

    Row(
        modifier = modifier
            .height(40.dp)
            .clip(roundedShape16)
            .background(CardBackgroundColor)
            .clickable { onEdit() }
            .border(
                width = if (isWriting) 1.dp else 0.dp,
                color = if (isWriting) Black else Color.Unspecified,
                shape = roundedShape16
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = if (inputType == AddingType.CARD) {
                Modifier
                    .border(1.dp, Color.Gray, roundedShape16)
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            } else {
                Modifier
                    .width(80.dp)
                    .border(1.dp, Color.Gray, roundedShape16)
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            }
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                readOnly = true,
                visualTransformation = visualTransformation,
                textStyle = textStyle,
                modifier = Modifier.fillMaxWidth(),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = hint,
                            style = textStyle.copy(color = Color.Gray)
                        )
                    }
                    innerTextField()
                },
                enabled = enabled
            )
        }
    }
}
