package br.com.wsworks.listcarswswork.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.wsworks.listcarswswork.ui.theme.ListCarsWsWorkTheme
import java.lang.reflect.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation as PasswordVisualTransformation1

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ListCarsWsWorkTheme {
        LoginScreen(navController = rememberNavController())
    }
}

@Composable
fun LoginScreen(navController: NavHostController) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = androidx.compose.ui.Modifier

        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Box {
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Login") })
        }

        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

        Box {
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter password") },
                visualTransformation = PasswordVisualTransformation1(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        Box { SaveLoginButton(navController, username, password) }
    }

}

@Composable
fun SaveLoginButton(navController: NavHostController, username: String, password: String) {
    OutlinedButton(onClick = {

        if (username.isNotEmpty() && password.isNotEmpty()) {
            navController.navigate("list")
        }

    }) {
        Text("Login")
    }
}