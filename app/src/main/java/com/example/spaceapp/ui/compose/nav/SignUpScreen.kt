package com.example.spaceapp.ui.compose.nav

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.common.nav.NavRoutes
import com.example.spaceapp.R
import com.example.spaceapp.ui.compose.firebase.checkStatus

@Composable
fun SignUpScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var checkedState by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("SIGN UP" ,style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            isError = email.isBlank()
        )
        if (email.isBlank()) {
            Text("Email is blank", color = MaterialTheme.colorScheme.error)
        }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Email") },
            isError = password.isBlank()
        )
        if (email.isBlank()) {
            Text("Password is blank", color = MaterialTheme.colorScheme.error)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkedState,
                onCheckedChange = { checkedState = it },
                modifier = Modifier
                    .height(48.dp)
                    .padding(vertical = 1.5.dp)
            )
            Text(
                "Yes I would like to receive ads"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "By pressing Continue you agree to the Terms of Service",
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            color = Color.Gray, textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = { navController.navigate(NavRoutes.ROUTE_HOME) },
            modifier = Modifier
                .width(400.dp)
                .height(48.dp)
                .padding(vertical = 1.5.dp),
            border = BorderStroke(1.dp, Color.Black),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Black,
                containerColor = Color.Transparent
            )
        ) {
            Text("CONTINUE")
        }
    }
}


