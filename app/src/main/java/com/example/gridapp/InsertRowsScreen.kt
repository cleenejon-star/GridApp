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

// 9. Manages state and logic [cite: 23]
@Composable
fun InsertRowsScreen(navController: NavController) {
    // 9. Holds the screen state [cite: 22]
    var rows by remember { mutableStateOf("") }

    InsertRowsScreenContent(
        rows = rows,
        onRowsChange = { rows = it },
        onNavigate = {
            // 5. Navigate when button is clicked
            navController.navigate("insertColumns/$rows")
        }
    )
}

// 9. Holds the screen content [cite: 23]
@Composable
fun InsertRowsScreenContent(
    rows: String,
    onRowsChange: (String) -> Unit,
    onNavigate: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        // 4. Has a title
        AppTitle(text = "Insert Rows")

        // 4. Has a text field
        AppTextField(
            value = rows,
            onValueChange = onRowsChange,
            label = "Number of Rows"
        )

        // 4. Has a button
        AppButton(
            text = "Next",
            onClick = onNavigate
        )
    }
}