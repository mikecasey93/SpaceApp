package com.example.spaceapp.ui.compose.screens.capsules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.nav.routes.CapsuleInput

@Composable
fun CapsuleDetailsScreen(capsuleInput: CapsuleInput) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            "Details: ${capsuleInput.details}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            "Landings: ${capsuleInput.landings}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            "Launch: ${capsuleInput.originalLaunch}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            "Status: ${capsuleInput.status}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}