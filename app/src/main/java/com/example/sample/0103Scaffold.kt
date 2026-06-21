package com.example.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.red30.compose.ui.theme.Red30TechTheme

@Composable
private fun Scaffold0103(modifier: Modifier = Modifier) {
    Red30TechTheme {
        Scaffold( // This is main container, in this container there are defined top container, bottom container and main content container
            modifier = modifier.fillMaxSize(),
            topBar = {
                TopAppBar( // Top container
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    ),
                    title = {
                        Text("I'm the appbar")
                    }
                )
            },
            bottomBar = { // Bottom container
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                ) {
                    Text("I'm the bottom bar")
                }
            }
        ) { innerPadding: PaddingValues -> // Main content container
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .then(Modifier.fillMaxSize()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "This is my primary content that is center aligned and desecrate",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }
    }
}

@Preview(showBackground = true) // This app composable allows to preview current UI without using emulator
@Composable // This UI builds preview automatically after changes
private fun Scaffold0103Preview() {
    Scaffold0103()
}
