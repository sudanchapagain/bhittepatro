package np.com.sudanchapagain.bhittepatro.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import np.com.sudanchapagain.bhittepatro.bikramSambat.BikramSambat
import java.time.LocalDate

val NEPALI_DAYS: List<String> = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun BikramSambatCalendar(
    currentMonth: Int, currentYear: Int, onMonthYearChange: (Int, Int) -> Unit = { _, _ -> }
) {
    val bikramSambat = remember { BikramSambat() }

    val todayBs = bikramSambat.getNepaliDate(LocalDate.now())
    val (initialYear, initialMonth) = bikramSambat.getYearMonthFromBsString(todayBs)
    val todayDay = todayBs.split(" ")[0].toInt()

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${bikramSambat.getNepaliMonthName(currentMonth)} $currentYear",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Gray,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, 
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    var newMonth = currentMonth - 1
                    var newYear = currentYear
                    if (newMonth < 0) {
                        newMonth = 11
                        newYear--
                    }
                    onMonthYearChange(newMonth, newYear)
                }) {
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Previous Month",
                        tint = Color.Gray
                    )
                }
                IconButton(onClick = {
                    onMonthYearChange(initialMonth, initialYear)
                }) {
                    Icon(
                        Icons.Filled.Home, contentDescription = "Today", tint = Color.Gray
                    )
                }
                IconButton(
                    onClick = {
                        var newMonth = currentMonth + 1
                        var newYear = currentYear
                        if (newMonth > 11) {
                            newMonth = 0
                            newYear++
                        }
                        onMonthYearChange(newMonth, newYear)
                    }) {
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "Next Month",
                        tint = Color.Gray,
                    )
                }
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
            columns = GridCells.Fixed(7), 
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            items(startOffset + daysInMonth.size) { index ->
                val day = if (index >= startOffset) daysInMonth[index - startOffset] else 0
                val isCurrentDay = day == todayDay && currentMonth == initialMonth && currentYear == initialYear

                if (day > 0) {
                    Box(
                        contentAlignment = Alignment.Center, 
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = day.toString(),
                            modifier = Modifier.then(
                                if (isCurrentDay) {
                                    Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.primary)
                                        .padding(4.dp)
                                } else {
                                    Modifier
                                }
                            ),
                            color = if (isCurrentDay) MaterialTheme.colorScheme.onPrimary else Color.Gray,
                            fontWeight = if (isCurrentDay) FontWeight.SemiBold else FontWeight.Normal,
                            textAlign = TextAlign.Center,
                        )
                    }
                } else {
                    Text(
                        text = "",
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                    )
                }
            }
        }
    }
}
