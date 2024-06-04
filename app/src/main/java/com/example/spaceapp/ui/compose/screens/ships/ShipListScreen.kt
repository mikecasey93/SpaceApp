package com.example.spaceapp.ui.compose.screens.ships

import android.util.Log
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
import androidx.navigation.NavHostController
import com.example.common.state.CommonScreen
import com.example.spaceapp.model.ShipItem
import com.example.spaceapp.model.ShipListModel
import com.example.spaceapp.ui.uiaction.ship.ShipListAction
import com.example.spaceapp.ui.uiaction.ship.ShipListSingleEvent
import com.example.spaceapp.ui.viewmodel.ShipListViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ShipListScreen(
    viewModel: ShipListViewModel,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        viewModel.submitAction(ShipListAction.Load)
    }

    viewModel.uiStateFlow.collectAsState().value.let{ state->
        CommonScreen(state = state) {
            Column {
                ShipList(it) { item ->
                    viewModel.submitAction(
                        ShipListAction.OnShipItemClick(
                            item.shipModel,
                            item.shipName,
                            item.status,
                            item.shipType,
                            item.image,
                            item.weightLbs,
                            item.yearBuilt
                        )
                    )
                }

            }

        }
    }

    LaunchedEffect(Unit) {
        viewModel.singleEventFlow.collectLatest {
            when (it) {
                is ShipListSingleEvent.OpenDetailsScreen -> {
                    Log.i("ROUTE", it.navRoute)
                    navController.navigate(it.navRoute)
                }
            }
        }
    }
}



@Composable
fun ShipList(
    model: ShipListModel,
    onItemClick: (ShipItem) -> Unit,
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(model.items) { ship ->
            ShipItem(ship = ship, onItemClick = onItemClick)
        }
    }

}


@Composable
fun ShipItem(ship: ShipItem, onItemClick: (ShipItem) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick (ship) },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Ship Id: ${ship.shipId}")
        }
    }
}