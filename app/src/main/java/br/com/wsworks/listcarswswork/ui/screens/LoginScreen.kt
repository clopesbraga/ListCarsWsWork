package br.com.wsworks.listcarswswork.ui.screens

import android.util.Log
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.wsworks.listcarswswork.ui.theme.ListCarsWsWorkTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
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

    val auth = Firebase.auth
    var username by remember { mutableStateOf(auth.currentUser?.email ?: "") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box {
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Box {
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter password") },
                visualTransformation = PasswordVisualTransformation1(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Box { SaveLoginButton(navController, username, password, auth) }
    }

}

@Composable
private fun SaveLoginButton(
    navController: NavHostController,
    username: String,
    password: String,
    auth: FirebaseAuth
) {
    OutlinedButton(onClick = {

        if (username.isEmpty()) {

            auth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener { logintTask ->
                    if (logintTask.isSuccessful) {
                        navController.navigate("list")
                    } else {
                        Log.d("CREATE_ERROR", "USER NOT SAVED -> ${logintTask.exception}")
                    }
                }
        } else {
            auth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener { loginTask ->
                    if (loginTask.isSuccessful) {
                        navController.navigate("list")
                    } else {
                        Log.d("LOGIN_ERROR", "LOGIN ERROR -> ${loginTask.exception}")
                    }
                }
        }

    }) {
        Text("Login")
    }
}