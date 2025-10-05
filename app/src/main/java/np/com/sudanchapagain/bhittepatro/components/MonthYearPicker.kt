package np.com.sudanchapagain.bhittepatro.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import np.com.sudanchapagain.bhittepatro.bikramSambat.BikramSambat


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonthYearPickerSheet(
    currentMonth: Int, currentYear: Int, onSelect: (monthIndex: Int, year: Int) -> Unit, onDismiss: () -> Unit
) {
    val yearStart = 2000
    val yearEnd = 2090

    val bs = remember { BikramSambat() }
    val years = remember { (yearStart..yearEnd).toList() }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
//        modifier = Modifier.background(Color.hsl(0F, 0F, 0F, 0.2F))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
//                .background(Color.White)
        ) {
            Text(
                "Select month",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(Modifier.height(12.dp))

            val monthNames = (0..11).map {
                bs.getNepaliMonthName(it)
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(3), modifier = Modifier.heightIn(
                    min = 160.dp, max = 260.dp
                )
            ) {
                items(monthNames.size) { i ->
                    val name = monthNames[i]
                    val selected = i == currentMonth

                    FilterChip(
                        onClick = { onSelect(i, currentYear) },
                        label = {
                            Text(name, maxLines = 1)
                        },
                        selected = selected,
                        modifier = Modifier.padding(6.dp),
                        leadingIcon = if (selected) {
                            {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Done icon",
                                    modifier = Modifier.size(
                                        FilterChipDefaults.IconSize
                                    )
                                )
                            }
                        } else {
                            null
                        },
                    )
                }
            }

            Spacer(Modifier.height(12.dp))

            Text(
                "Select year",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(Modifier.height(4.dp))

            LazyColumn(
                modifier = Modifier.heightIn(
                    min = 140.dp, max = 240.dp
                )
            ) {
                items(years.size) { idx ->
                    val y = years[idx]
                    val selected = y == currentYear

                    ListItem(
                        headlineContent = { Text("$y") },
                        modifier = Modifier.clickable { onSelect(currentMonth, y) },
                        colors = ListItemDefaults.colors(
                            containerColor = if (selected) {
                                MaterialTheme.colorScheme.primaryContainer
                            } else {
                                Color.Transparent
                            }
                        )
                    )
                }
            }
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = onDismiss) {
                    Text("Close")
                }
            }
        }
    }
}
