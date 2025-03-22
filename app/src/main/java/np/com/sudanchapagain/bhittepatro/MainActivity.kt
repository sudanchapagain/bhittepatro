package np.com.sudanchapagain.bhittepatro

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import np.com.sudanchapagain.bhittepatro.ui.theme.BhittepatroTheme
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import np.com.sudanchapagain.bhittepatro.bikramSambat.BikramSambat
import np.com.sudanchapagain.bhittepatro.calendar.PreviewBikramSambatCalendar
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val bikramSambat = BikramSambat()
        val td = LocalDate.now()
        val today = bikramSambat.getNepaliDate(td)

        // TODO:
        // render this into a calendar widget/component
        // val allBsDates = bikramSambat.getCalendar()
        setContent {
            BhittepatroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    bhittepatro(modifier = Modifier.padding(innerPadding), today, td)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun bhittepatro(modifier: Modifier = Modifier, today: String, td: LocalDate) {
    Column(modifier = modifier.padding(16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "bhittepatro", fontWeight = FontWeight.Black, style = MaterialTheme.typography.headlineSmall
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Today's Date", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = today,
                fontWeight = FontWeight.Black,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = td.toString(), fontWeight = FontWeight.Normal, style = MaterialTheme.typography.bodySmall
            )
            PreviewBikramSambatCalendar()
        }
    }
}
