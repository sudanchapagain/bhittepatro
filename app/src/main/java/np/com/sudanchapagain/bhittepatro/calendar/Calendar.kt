package np.com.sudanchapagain.bhittepatro.calendar

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import np.com.sudanchapagain.bhittepatro.bikramSambat.BikramSambat
import java.time.LocalDate

val NEPALI_DAYS: List<String> = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BikramSambatCalendar() {
    val bikramSambat = remember { BikramSambat() }

    val todayBs = bikramSambat.getNepaliDate(LocalDate.now())
    val (initialYear, initialMonth) = bikramSambat.getYearMonthFromBsString(todayBs)

    var currentMonth by remember { mutableStateOf(initialMonth) }
    var currentYear by remember { mutableStateOf(initialYear) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .padding(top = 40.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                currentMonth--
                if (currentMonth < 0) {
                    currentMonth = 11
                    currentYear--
                }
            }) {
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Previous Month",
                    tint = Color.Gray
                )
            }
            Text(
                text = "${bikramSambat.getNepaliMonthName(currentMonth)} $currentYear",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Gray,
            )
            IconButton(onClick = {
                currentMonth++
                if (currentMonth > 11) {
                    currentMonth = 0
                    currentYear++
                }
            }) {
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Next Month",
                    tint = Color.Gray,
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            NEPALI_DAYS.forEach { day ->
                Text(
                    text = day,
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        val (daysInMonth, startOffset) = bikramSambat.getMonthDaysWithOffset(currentYear, currentMonth)

        LazyVerticalGrid(
            columns = GridCells.Fixed(7), modifier = Modifier.fillMaxWidth()
        ) {
            items(startOffset + daysInMonth.size) { index ->
                val day = if (index >= startOffset) daysInMonth[index - startOffset] else 0
                Text(
                    text = if (day > 0) day.toString() else "",
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    color = Color.Gray,
                )
            }
        }
    }
}

// **Preview**
@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewBikramSambatCalendar() {
    BikramSambatCalendar()
}
