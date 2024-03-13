package com.lab1_71557.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lab1_71557.R
import com.lab1_71557.ui.components.CustomButton
import com.lab1_71557.ui.components.CustomOutlinedTextField
import com.lab1_71557.ui.components.Head

@Composable
fun bLogin(onNavigateToSignUp: () -> Unit
) {
    LoginContent(
        onNavigateToSignUp = onNavigateToSignUp
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoginContent(
    onNavigateToSignUp: () -> Unit
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
            title = stringResource(id = R.string.welcomeBackMessage)
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
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Right,
            text = stringResource(id = R.string.forgot_password)
        )

        CustomButton(
            modifier = Modifier.padding(top = 25.dp), text = stringResource(id = R.string.login)
        ) {
            Toast.makeText(context, "Login", Toast.LENGTH_LONG).show()

        }

        Row(
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Divider(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .weight(1f)
            )
            Text(text = stringResource(id = R.string.or_continue_with))
            Divider(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .weight(1f)
            )

        }

        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier.size(60.dp), onClick = {
                    Toast.makeText(context, "Continue with Google", Toast.LENGTH_SHORT).show()
                }, colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onSurface

                )
            ) {
                Box(modifier = Modifier.fillMaxSize()) {

                    Image(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(32.dp),
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = null
                    )
                }
            }
            Card(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(60.dp), onClick = {
                    Toast.makeText(context, "Continue with Apple", Toast.LENGTH_SHORT).show()

                }, colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onSurface

                )
            ) {
                Box(modifier = Modifier.fillMaxSize()) {

                    Image(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(32.dp),
                        painter = painterResource(id = R.drawable.ic_apple),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                        contentDescription = null
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(id = R.string.not_a_member))
            Text(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .clickable {
                        onNavigateToSignUp()
                    },
                text = stringResource(id = R.string.register_now),
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}