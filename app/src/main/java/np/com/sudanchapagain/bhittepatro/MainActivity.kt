package np.com.sudanchapagain.bhittepatro

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import np.com.sudanchapagain.bhittepatro.bikramSambat.BikramSambat
import np.com.sudanchapagain.bhittepatro.components.BikramSambatCalendar
import np.com.sudanchapagain.bhittepatro.components.BikramSambatEvents
import np.com.sudanchapagain.bhittepatro.data.EventsRepository.holidaysFor
import np.com.sudanchapagain.bhittepatro.ui.theme.BhittepatroTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BhittepatroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Bhittepatro(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun Bhittepatro(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    val bikramSambat = remember { BikramSambat() }
    val todayBs = bikramSambat.getNepaliDate(LocalDate.now())
    val (initialYear, initialMonth) = bikramSambat.getYearMonthFromBsString(todayBs)

    var currentMonth by remember { mutableIntStateOf(initialMonth) }
    var currentYear by remember { mutableIntStateOf(initialYear) }

    Column(modifier = modifier.padding(16.dp)) {
        if (isLandscape) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    BikramSambatCalendar(
                        currentMonth = currentMonth,
                        currentYear = currentYear,
                        holidayDays = holidaysFor(currentYear, currentMonth),
                        onMonthYearChange = { month, year ->
                            currentMonth = month
                            currentYear = year
                        })
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    BikramSambatEvents(currentMonth, currentYear)
                }
            }
        } else {
            Column {
                BikramSambatCalendar(
                    currentMonth = currentMonth,
                    currentYear = currentYear,
                    holidayDays = holidaysFor(currentYear, currentMonth),
                    onMonthYearChange = { month, year ->
                        currentMonth = month
                        currentYear = year
                    })

//                TODO: ADD a upcoming events or events text as subheading
//                Text(
//                    "Events",
//                    modifier = Modifier
//                )
                BikramSambatEvents(currentMonth, currentYear)
            }
        }
    }
}
