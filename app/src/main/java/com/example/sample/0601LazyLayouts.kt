package com.example.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.red30.compose.ui.component.SessionItem
import com.example.red30.compose.ui.theme.Red30TechTheme
import com.example.red30.data.ConferenceDataUiState
import com.example.red30.data.fakes

private class LazyLayouts0601 {

    @Composable
    fun MainApp(modifier: Modifier = Modifier) {
        val uiState = ConferenceDataUiState.fakes()

        Scaffold { innerPadding ->
//            LazyColumn( // Lazy layouts compose items as needed
//                // This item is lazy column, it automaticly adds sroll functionality and other functionality
//                modifier = modifier
//                    .fillMaxSize()
//                    .padding(innerPadding)
//                    .padding(24.dp),
//                verticalArrangement = Arrangement.spacedBy(24.dp),
//            ) {
////                item { // It needs to be in item
////                    SessionItem( // lazy layouts use scope block instead for composable content block
////                        sessionInfo = uiState.sessionInfos.first()
////                    )
////                }
////                items(count = 5) {
////                    SessionItem( // With lazy column it can print easily multiple components
////                        sessionInfo = uiState.sessionInfos.first()
////                    )
////                }
//
//                items(uiState.sessionInfos) { // For doing this way it's need import of items
//                    SessionItem( // With lazy column it can print easily multiple components
//                        sessionInfo = it
//                    )
//                }
//            }


            LazyHorizontalGrid( // Horizontal row of lazy items
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp),
                rows = GridCells.Fixed(2), // It can be set how many rows it has
                horizontalArrangement = Arrangement.spacedBy(48.dp),
            ) {
                items(count = 5) {
                    Box(modifier = Modifier.width(360.dp)) {
                        SessionItem(
                            modifier = Modifier.fillMaxWidth(),
                            sessionInfo = uiState.sessionInfos.last()
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun LazyLayouts0601Preview() {
    Red30TechTheme {
        LazyLayouts0601().MainApp()
    }
}
