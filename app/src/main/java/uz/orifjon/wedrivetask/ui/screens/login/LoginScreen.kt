package uz.orifjon.wedrivetask.ui.screens.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import uz.orifjon.wedrivetask.R
import uz.orifjon.wedrivetask.ui.core.FillEmptySpace
import uz.orifjon.wedrivetask.ui.core.Spacer8
import uz.orifjon.wedrivetask.ui.screens.home.HomeRoute
import uz.orifjon.wedrivetask.utils.extensions.navigateAndClearStack

@Serializable
data object LoginRoute

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                LoginEvent.AfterLogIn -> {
                    navController.navigateAndClearStack(HomeRoute)
                }

                is LoginEvent.LoginError -> {
                    Toast.makeText(context, event.errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = state.phoneNumber,
                onValueChange = viewModel::changePhoneNumber,
                colors = TextFieldDefaults.colors(focusedTextColor = White, unfocusedTextColor = White)
            )
            Spacer8()
            Button(
                 onClick = {
                    viewModel.login()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Black)) {
                Text(stringResource(R.string.login), color = White)
            }
        }
    }


}