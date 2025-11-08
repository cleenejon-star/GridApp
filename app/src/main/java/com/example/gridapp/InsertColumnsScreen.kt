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

// 11. Manages state and logic [cite: 25]
@Composable
fun InsertColumnsScreen(navController: NavController, rows: String?) {
    // 11. Holds the screen state [cite: 25]
    var cols by remember { mutableStateOf("") }

    InsertColumnsScreenContent(
        cols = cols,
        onColsChange = { cols = it },
        onNavigate = {
            // 7. Navigate when button is clicked
            navController.navigate("gridScreen/$rows/$cols")
        }
    )
}

// 11. Holds the screen content [cite: 25]
@Composable
fun InsertColumnsScreenContent(
    cols: String,
    onColsChange: (String) -> Unit,
    onNavigate: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        // 6. Has a title
        AppTitle(text = "Insert Columns")

        // 6. Has a text field
        AppTextField(
            value = cols,
            onValueChange = onColsChange,
            label = "Number of Columns"
        )

        // 6. Has a button
        AppButton(
            text = "Show Grid",
            onClick = onNavigate
        )
    }
}