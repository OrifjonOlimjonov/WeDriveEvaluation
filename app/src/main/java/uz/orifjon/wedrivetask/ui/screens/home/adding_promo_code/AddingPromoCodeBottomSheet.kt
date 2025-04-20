package uz.orifjon.wedrivetask.ui.screens.home.adding_promo_code

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.orifjon.wedrivetask.R
import uz.orifjon.wedrivetask.ui.core.Spacer16
import uz.orifjon.wedrivetask.ui.core.Spacer4
import uz.orifjon.wedrivetask.ui.core.Spacer8
import uz.orifjon.wedrivetask.ui.theme.figtreeMedium
import uz.orifjon.wedrivetask.ui.theme.roundedShape12

@Composable
fun AddingPromoCodeBottomSheet(
    onSavePromoCodeClick: (String) -> Unit
) {

    val promoCodeText = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(White)
    ) {
        Spacer16()
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
                    onClick = { }
                ) {
                    Icon(painter = painterResource(R.drawable.ic_arrow_left), null, tint = Black)
                }
                Spacer8()
                Text(
                    stringResource(R.string.enter_promo_code),
                    color = Black,
                    fontSize = 18.sp,
                    fontFamily = figtreeMedium
                )
            }
            Box(modifier = Modifier.padding(16.dp)) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    BasicTextField(
                        value = promoCodeText.value,
                        onValueChange = { promoCodeText.value = it },
                        singleLine = true,
                        textStyle = TextStyle(
                            color = Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp),
                        decorationBox = { innerTextField ->
                            Column {
                                innerTextField()
                                Spacer4()
                                HorizontalDivider(color = Black, thickness = 1.dp)
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Characters
                        )
                    )
                }
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 16.dp),
                content = {
                    Text(stringResource(R.string.save), color = White)
                },
                onClick = { onSavePromoCodeClick(promoCodeText.value) },
                shape = roundedShape12,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Black
                )
            )
            Spacer16()
        }
    }
}