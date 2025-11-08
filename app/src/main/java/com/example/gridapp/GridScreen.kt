package com.example.gridapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gridapp.ui.theme.AppTitle
import com.example.gridapp.ui.theme.GridItem

// Manages state and logic
@Composable
fun GridScreen(rows: String?, cols: String?) {
    // Convert text input to integers
    val rowCount = rows?.toIntOrNull() ?: 0
    val colCount = cols?.toIntOrNull() ?: 0

    GridScreenContent(rowCount = rowCount, colCount = colCount)
}


@Composable
fun GridScreenContent(rowCount: Int, colCount: Int) {
    Column(modifier = Modifier.padding(16.dp)) {
        AppTitle(text = "Generated Grid")

        // LazyColumn for the columns (vertical scroll)
        LazyColumn {
            items(rowCount) { row ->

                // Each row scrolls independently using LazyRow (horizontal scroll)
                LazyRow {
                    items(colCount) { col ->
                        // Display text "Item [row] [column]"
                        GridItem(text = "Item $row $col")
                    }
                }
            }
        }
    }
}