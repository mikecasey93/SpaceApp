package com.example.spaceapp.ui.compose.screens.capsules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.common.state.CommonScreen
import com.example.spaceapp.model.Capsule
import com.example.spaceapp.model.CapsuleListModel
import com.example.spaceapp.ui.viewmodel.CapsuleListViewModel
import com.example.spaceapp.ui.uiaction.capsule.CapsuleListAction
import com.example.spaceapp.ui.uiaction.capsule.CapsuleListSingleEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CapsuleListScreen(
    viewModel: CapsuleListViewModel,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        viewModel.submitAction(CapsuleListAction.Load)
    }

    viewModel.uiStateFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            Column {
                CapsuleList(it) { item ->
                    viewModel.submitAction(
                        CapsuleListAction.CapsuleItemClick(
                            item.capsuleId,
                            item.details,
                            item.landings,
                            item.originalLaunch,
                            item.status
                        )
                    )
                }
            }
        }
    }

        LaunchedEffect(Unit) {
            viewModel.singleEventFlow.collectLatest {
                when (it) {
                    is CapsuleListSingleEvent.GoToDetailsScreen -> {
                        navController.navigate(it.route)
                    }
                }
            }
        }
}

@Composable
fun CapsuleList(
    listModel: CapsuleListModel,
    onItemClick: (Capsule) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(listModel.capsules) {capsule ->
            CapsuleItem(capsule = capsule, onItemClick = onItemClick)
        }
    }
}

@Composable
fun CapsuleItem(capsule: Capsule, onItemClick: (Capsule) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(capsule) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Capsule ID: ${capsule.capsuleId}")
        }
    }
}