package com.example.gridapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gridapp.ui.theme.AppButton
import com.example.gridapp.ui.theme.AppTextField
import com.example.gridapp.ui.theme.AppTitle

@Composable
fun InsertColumnsScreen(navController: NavController, rows: String?) {

    var cols by remember { mutableStateOf("") }

    InsertColumnsScreenContent(
        cols = cols,
        onColsChange = { cols = it },
        onNavigate = {
            // Navigate when button is clicked
            navController.navigate("gridScreen/$rows/$cols")
        }
    )
}

// Holds the screen content
@Composable
fun InsertColumnsScreenContent(
    cols: String,
    onColsChange: (String) -> Unit,
    onNavigate: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        // title
        AppTitle(text = "Insert Columns")

        // text field
        AppTextField(
            value = cols,
            onValueChange = onColsChange,
            label = "Number of Columns"
        )

        // button
        AppButton(
            text = "Show Grid",
            onClick = onNavigate
        )
    }
}