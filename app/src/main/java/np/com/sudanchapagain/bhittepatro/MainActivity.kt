package np.com.sudanchapagain.bhittepatro

import android.os.Build
import android.os.Bundle
import android.content.res.Configuration
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import np.com.sudanchapagain.bhittepatro.ui.theme.BhittepatroTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import np.com.sudanchapagain.bhittepatro.components.BikramSambatCalendar
import np.com.sudanchapagain.bhittepatro.components.BikramSambatEvents
import np.com.sudanchapagain.bhittepatro.bikramSambat.BikramSambat
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
//        TODO:
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 8.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(
//                text = "bhittepatro",
//                fontWeight = FontWeight.Black,
//                style = MaterialTheme.typography.headlineSmall,
//                textAlign = TextAlign.Left,
//            )
//            IconButton(onClick = {}) {
//                Icon(
//                    Icons.Default.Search,
//                    contentDescription = "Search",
//                    tint = Color.Gray,
//                )
//            }
//        }

        if (isLandscape) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    BikramSambatCalendar(
                        currentMonth = currentMonth,
                        currentYear = currentYear,
                        onMonthYearChange = { month, year ->
                            currentMonth = month
                            currentYear = year
                        }
                    )
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
                    onMonthYearChange = { month, year ->
                        currentMonth = month
                        currentYear = year
                    }
                )
                BikramSambatEvents(currentMonth, currentYear)
            }
        }
    }
}
