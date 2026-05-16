package np.com.sudanchapagain.bhittepatro.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import np.com.sudanchapagain.bhittepatro.model.EventEntry
import np.com.sudanchapagain.bhittepatro.model.eventsByMonth

@Composable
fun BikramSambatEvents(currentMonth: Int, currentYear: Int) {
    val isSupportedYear = currentYear == 2082
    val monthEvents = remember(currentMonth, currentYear) {
        if (isSupportedYear) {
            eventsByMonth[currentMonth + 1] ?: emptyList()
        } else {
            emptyList()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        if (!isSupportedYear) {
            Text(
                text = "No data available for $currentYear",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
        } else if (monthEvents.isEmpty()) {
            Text(
                text = "No events for this month",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(monthEvents) { event ->
                    EventItem(event)
                }
            }
        }
    }
}

@Composable
private fun EventItem(event: EventEntry) {
    val dayNumber = event.bs.split("-").lastOrNull()?.toIntOrNull() ?: 0

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp), colors = CardDefaults.cardColors(
            containerColor = if (event.holiday) {
                MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.50F)
            } else {
                MaterialTheme.colorScheme.surface
            }
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$dayNumber", fontWeight = FontWeight.Bold, color = if (event.holiday) {
                        MaterialTheme.colorScheme.error.copy()
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )

                Text(
                    text = event.tithi,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = event.events.joinToString(separator = ", "),
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
