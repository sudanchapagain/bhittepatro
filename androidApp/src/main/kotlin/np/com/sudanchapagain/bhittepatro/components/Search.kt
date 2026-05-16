package np.com.sudanchapagain.bhittepatro.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import np.com.sudanchapagain.bhittepatro.model.eventsByMonth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSheet(
    currentYear: Int, onNavigate: (Int, Int) -> Unit, onDismiss: () -> Unit
) {
    var query by remember { mutableStateOf("") }
    val results = remember(query, currentYear) {
        if (currentYear != 2082 || query.isBlank()) emptyList() else buildList {
            eventsByMonth.forEach { (month, list) ->
                list.forEach { entry ->
                    entry.events.forEach { ev ->
                        if (fuzzyMatch(ev, query)) {
                            add(Triple(month, entry.bs, ev))
                        }
                    }
                }
            }
        }.sortedBy { (month, bs, ev) -> -fuzzyScore(ev, query) }
    }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ModalBottomSheet(
        onDismissRequest = onDismiss, sheetState = sheetState
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Search events", style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Type to search") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))

            if (results.isEmpty()) {
                Text(
                    text = "No results", color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            } else {
                LazyColumn(modifier = Modifier.heightIn(max = 320.dp)) {
                    items(results.size) { i ->
                        val (month, bs, text) = results[i]
                        ListItem(
                            headlineContent = { Text(text) },
                            supportingContent = { Text(bs) },
                            modifier = Modifier.clickable {
                                onNavigate(month - 1, 2082)
                                onDismiss()
                            })
                    }
                }
            }

            Spacer(
                Modifier.height(8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = onDismiss) { Text("Close") }
            }
        }
    }
}
