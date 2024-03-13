package com.lab1_71557.ui.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.lab1_71557.R
import com.lab1_71557.ui.components.CustomButton
import com.lab1_71557.ui.components.CustomOutlinedTextField
import com.lab1_71557.ui.components.Head

@Composable
fun gSignUp(
    onNavigateToLogin: () -> Unit,
) {
    SignUpLogin(
        onNavigateToLogin = onNavigateToLogin)
}

@Composable
private fun SignUpLogin(
    onNavigateToLogin: () -> Unit,
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Head(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(top = 60.dp),
            title = stringResource(id = R.string.createAccountMessage)
        )

        CustomOutlinedTextField(
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth()
                .height(70.dp),
            keyboardType = KeyboardType.Email,
            hint = stringResource(id = R.string.email)
        )
        CustomOutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
            hint = stringResource(id = R.string.password)
        )
        CustomOutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
            hint = stringResource(id = R.string.confirm_password)
        )


        CustomButton(
            modifier = Modifier.padding(top = 25.dp), text = stringResource(id = R.string.sign_up)
        ) {
            Toast.makeText(context, "Sign Up", Toast.LENGTH_LONG).show()
        }
        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(id = R.string.already_a_member))
            Text(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .clickable {
                        onNavigateToLogin()
                    },
                text = stringResource(id = R.string.login_now),
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}