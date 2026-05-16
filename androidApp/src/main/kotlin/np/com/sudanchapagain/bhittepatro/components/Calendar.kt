package np.com.sudanchapagain.bhittepatro.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import np.com.sudanchapagain.bhittepatro.bikramSambat.BikramSambat
import java.time.LocalDate

val NEPALI_DAYS: List<String> = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BikramSambatCalendar(
    currentMonth: Int,
    currentYear: Int,
    holidayDays: Set<Int> = emptySet(),
    onMonthYearChange: (Int, Int) -> Unit = { _, _ -> }
) {
    val bikramSambat = remember { BikramSambat() }
    var showSearch: Boolean by remember { mutableStateOf(false) }

    val todayBs = bikramSambat.getNepaliDate(LocalDate.now())
    val (initialYear, initialMonth) = bikramSambat.getYearMonthFromBsString(todayBs)
    val todayDay = todayBs.split(" ")[0].toInt()

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            var showPicker by remember { mutableStateOf(false) }

            Box {
                Text(
                    text = "${bikramSambat.getNepaliMonthName(currentMonth)} $currentYear",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                        .clickable { showPicker = true })
            }

            if (showPicker) {
                MonthYearPickerSheet(
                    currentMonth = currentMonth,
                    currentYear = currentYear,
                    onSelect = { m, y -> onMonthYearChange(m, y); showPicker = false },
                    onDismiss = { showPicker = false })
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { showSearch = true }) {
                    Icon(
                        imageVector = Icons.Filled.Search, contentDescription = "Search", tint = Color.Gray
                    )
                }
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

        val (daysInMonth, startOffset) = bikramSambat.getMonthDaysWithOffset(
            currentYear, currentMonth
        )

        if (showSearch) {
            SearchSheet(
                currentYear = currentYear,
                onNavigate = { m, y -> onMonthYearChange(m, y) },
                onDismiss = { showSearch = false })
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .pointerInput(currentMonth, currentYear) {
                    var dragged = 0f

                    detectHorizontalDragGestures(onHorizontalDrag = { _, dragAmount ->
                        dragged += dragAmount

                        if (dragged > 60f) {
                            var newMonth = currentMonth - 1
                            var newYear = currentYear
                            if (newMonth < 0) {
                                newMonth = 11; newYear--
                            }
                            onMonthYearChange(newMonth, newYear)
                            dragged = 0f
                        } else if (dragged < -60f) {
                            var newMonth = currentMonth + 1
                            var newYear = currentYear
                            if (newMonth > 11) {
                                newMonth = 0; newYear++
                            }
                            onMonthYearChange(newMonth, newYear)
                            dragged = 0f
                        }
                    }, onDragEnd = { dragged = 0f }, onDragCancel = { dragged = 0f })
                }) {
            items(startOffset + daysInMonth.size) { index ->
                val day = if (index >= startOffset) daysInMonth[index - startOffset] else 0
                val isCurrentDay = day == todayDay && currentMonth == initialMonth && currentYear == initialYear

                if (day > 0) {
                    Box(
                        contentAlignment = Alignment.Center, modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = day.toString(),
                            modifier = Modifier.then(
                                other = if (isCurrentDay) {
                                    Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.primary)
                                        .padding(4.dp)
                                } else {
                                    Modifier
                                }
                            ),
                            color = when {
                                isCurrentDay -> MaterialTheme.colorScheme.onPrimary
                                holidayDays.contains(day) -> MaterialTheme.colorScheme.error.copy(alpha = 0.95f)
                                else -> MaterialTheme.colorScheme.onSurfaceVariant
                            },
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
