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
fun InsertRowsScreen(navController: NavController) {

    var rows by remember { mutableStateOf("") }

    InsertRowsScreenContent(
        rows = rows,
        onRowsChange = { rows = it },
        onNavigate = {
            // navigate when button is clicked
            navController.navigate("insertColumns/$rows")
        }
    )
}

@Composable
fun InsertRowsScreenContent(
    rows: String,
    onRowsChange: (String) -> Unit,
    onNavigate: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        // Title
        AppTitle(text = "Insert Rows")

        // Text field
        AppTextField(
            value = rows,
            onValueChange = onRowsChange,
            label = "Number of Rows"
        )

        // Button
        AppButton(
            text = "Next",
            onClick = onNavigate
        )
    }
}