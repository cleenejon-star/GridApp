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

// 13. Manages state and logic [cite: 27]
@Composable
fun GridScreen(rows: String?, cols: String?) {
    // 13. Holds the screen state [cite: 27]
    // Convert text input to integers, defaulting to 0 if null or invalid
    val rowCount = rows?.toIntOrNull() ?: 0
    val colCount = cols?.toIntOrNull() ?: 0

    GridScreenContent(rowCount = rowCount, colCount = colCount)
}

// 13. Holds the screen content [cite: 27]
@Composable
fun GridScreenContent(rowCount: Int, colCount: Int) {
    Column(modifier = Modifier.padding(16.dp)) {
        AppTitle(text = "Generated Grid")

        // 9. Use LazyColumn for the columns (vertical scroll)
        LazyColumn {
            items(rowCount) { row ->

                // 9. Each row scrolls independently using LazyRow (horizontal scroll)
                LazyRow {
                    items(colCount) { col ->
                        // 10. Display text "Item [row] [column]"
                        GridItem(text = "Item $row $col")
                    }
                }
            }
        }
    }
}