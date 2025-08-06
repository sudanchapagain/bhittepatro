package np.com.sudanchapagain.bhittepatro.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class EventEntry(
    val bs: String,
    val tithi: String,
    val holiday: Boolean,
    val events: List<String>
)

@Preview
@Composable
fun BikramSambatEvents(curentMonth: Int, curentYear: Int) {
    val monthEvents = remember(curentMonth, curentYear) {
        eventsByMonth[curentMonth + 1] ?: emptyList()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        if (monthEvents.isEmpty()) {
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
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (event.holiday) MaterialTheme.colorScheme.errorContainer else MaterialTheme.colorScheme.surface
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
                    text = "$dayNumber",
                    fontWeight = FontWeight.Bold,
                    color = if (event.holiday) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                )

                Text(
                    text = event.tithi,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            event.events.forEach { eventText ->
                Text(
                    text = "• $eventText",
                    modifier = Modifier.padding(vertical = 2.dp),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

val eventsByMonth: Map<Int, List<EventEntry>> = mapOf(
    1 to listOf(
        EventEntry(
            bs = "2082-01-01",
            tithi = "प्रतिपदा",
            holiday = true,
            events = listOf("नव वर्ष २०८२ (बिदा)", "ल. पु मत्स्येन्द्रनाथ स्नान (बुंगन्हव)", "विशालनगरमा वैष्णवीदेवी जात्रा", "वैशाख संक्रान्ति", "टोखाको सपन तीर्थमास्नान", "भ.पु विश्वध्वजपातनम्")
        ),
        EventEntry(
            bs = "2082-01-02",
            tithi = "द्वितीया",
            holiday = false,
            events = listOf("मध्यपुर (ठिमी) बालकुमारी जात्रा", "भक्तपुर महाकाली-महालक्ष्मी जात्रा", "टोखा चन्देश्वरी जात्रा")
        ),
        EventEntry(
            bs = "2082-01-03",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("साखुमा जात्रा( सक्व यां:)", "भक्तपुर ब्रह्मायणी यात्रा")
        ),
        EventEntry(
            bs = "2082-01-04",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("भक्तपुरमा छुमा गणेश यात्रा")
        ),
        EventEntry(
            bs = "2082-01-05",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("विश्व सम्पदा दिवस")
        ),
        EventEntry(
            bs = "2082-01-07",
            tithi = "सप्तमी",
            holiday = false,
            events = listOf("रवि सप्तमी ब्रत", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-01-08",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("गोरखकाली पूजा", "छन्द दिवस")
        ),
        EventEntry(
            bs = "2082-01-09",
            tithi = "नवमी",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय पृथ्वि दिवस")
        ),
        EventEntry(
            bs = "2082-01-10",
            tithi = "दशमी",
            holiday = false,
            events = listOf("पासाङ ल्हामु स्मृति दिवस", "विश्व पुस्तक तथा प्रतिलिपि अधिकार दिवस")
        ),
        EventEntry(
            bs = "2082-01-11",
            tithi = "एकादशी",
            holiday = true,
            events = listOf("लोकतन्त्र दिवस (बिदा)", "वरुथिनी एकादशी व्रत")
        ),
        EventEntry(
            bs = "2082-01-12",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("प्रदोष व्रत", "औलो दिवस")
        ),
        EventEntry(
            bs = "2082-01-13",
            tithi = "त्रयोदशी",
            holiday = true,
            events = listOf("माताति च:ह्रे पूजा")
        ),
        EventEntry(
            bs = "2082-01-14",
            tithi = "औंसी",
            holiday = false,
            events = listOf("माता सम्मान दिवस (आमाको मुख हेर्ने)", "चांगुनारायणमा छिन्नमस्ता किलेश्वोर मूलरथ जात्रा", "दर्शश्राद्ध", "स्नानदान गर्ने औँशी", "हलो बार्ने", "निशि बार्ने")
        ),
        EventEntry(
            bs = "2082-01-15",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("ल.पु. मत्स्येन्द्रनाथ रथारोहण", "राष्ट्रिय चिया दिवस")
        ),
        EventEntry(
            bs = "2082-01-16",
            tithi = "द्वितीया",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय नृत्य दिवस", "परशुराम जयन्ती", "चन्द्रोदय:")
        ),
        EventEntry(
            bs = "2082-01-17",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("अक्षय तृतीया", "त्रेतायुगादी")
        ),
        EventEntry(
            bs = "2082-01-18",
            tithi = "चतुर्थी",
            holiday = true,
            events = listOf("श्रमिक दिवस  (बिदा)", "ल.पु. मत्स्येन्द्रनाथ रथ जात्रा सुरु")
        ),
        EventEntry(
            bs = "2082-01-19",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("रामानुजाचार्य जयन्ती", "आद्यगुरु शंकराचार्य जयन्ती")
        ),
        EventEntry(
            bs = "2082-01-20",
            tithi = "षष्ठी",
            holiday = true,
            events = listOf("अन्तर्राष्ट्रिय प्रेस स्वतन्त्रता दिवस")
        ),
        EventEntry(
            bs = "2082-01-21",
            tithi = "सप्तमी",
            holiday = false,
            events = listOf("गंगोत्पत्त / गङ्गा सप्तमी", "रवि सप्तमी ब्रत")
        ),
        EventEntry(
            bs = "2082-01-22",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("पशुपतिनाथमा दमन पुष्पार्पण", "गोरखकाली पूजा", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-01-23",
            tithi = "नवमी",
            holiday = false,
            events = listOf("सीता जयन्ती")
        ),
        EventEntry(
            bs = "2082-01-24",
            tithi = "दशमी",
            holiday = false,
            events = listOf("समाज सुधार दिवस (किराँत)")
        ),
        EventEntry(
            bs = "2082-01-25",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("मोहिनी एकादशी व्रत", "रेडक्रस दिवस")
        ),
        EventEntry(
            bs = "2082-01-26",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("कानून दिवस", "प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-01-28",
            tithi = "चतुर्दशी",
            holiday = false,
            events = listOf("नृसिंह जयन्ती", "माहिला ज्योतिस संघ स्थापना")
        ),
        EventEntry(
            bs = "2082-01-29",
            tithi = "पूर्णिमा",
            holiday = true,
            events = listOf("बुद्ध जयन्ती  (बिदा)", "उभौली पर्व (बिदा)", "विश्व नर्स दिवस", "चण्डी पूर्णिमा", "पूर्णिमाव्रत", "कूर्म जयन्ती", "गोरखनाथ जयन्ती")
        )
    ),
    2 to listOf(
        EventEntry(
            bs = "2082-02-01",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय परिवार दिवस", "ज्येष्ठ संक्रान्ति")
        ),
        EventEntry(
            bs = "2082-02-03",
            tithi = "पञ्चमी",
            holiday = true,
            events = listOf("विश्व उच्च रक्तचाप दिवस", "विश्व दूरसञ्चार दिवस", "मदन–आश्रीत स्मृति दिवस")
        ),
        EventEntry(
            bs = "2082-02-06",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("गोरखकाली पूजा", "भौमाष्टमी ब्रत")
        ),
        EventEntry(
            bs = "2082-02-08",
            tithi = "दशमी",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय जैविक विविधता दिवस")
        ),
        EventEntry(
            bs = "2082-02-09",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("अपरा एकादशी व्रत", "युगकवि सिद्धिचरण श्रेष्ठ जन्म-जयन्ति")
        ),
        EventEntry(
            bs = "2082-02-10",
            tithi = "द्वादशी",
            holiday = true,
            events = listOf("शनि प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-02-11",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("सिथि च:ह्रे पूजा")
        ),
        EventEntry(
            bs = "2082-02-12",
            tithi = "चतुर्दशी",
            holiday = false,
            events = listOf("वटसावित्री व्रत", "दर्शश्राद्ध", "निशि बार्ने")
        ),
        EventEntry(
            bs = "2082-02-13",
            tithi = "औंसी",
            holiday = false,
            events = listOf("शनि जयन्ती", "स्नानदान गर्ने औँशी", "हलो बार्ने")
        ),
        EventEntry(
            bs = "2082-02-14",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("दशहरा–स्नान आरम्भ", "गोसाइँकुण्ड-स्नान आरम्भ", "विश्व महिला स्वास्थ्य दिवस", "चन्द्रोदय:")
        ),
        EventEntry(
            bs = "2082-02-15",
            tithi = "तृतीया",
            holiday = true,
            events = listOf("राष्ट्रिय गणतन्त्र दिवस (बिदा)", "सगरमाथा आरोहण दिवस", "शान्ति सेना दिवस")
        ),
        EventEntry(
            bs = "2082-02-17",
            tithi = "पञ्चमी",
            holiday = true,
            events = listOf("विश्व धुम्रपान विरुद्धको दिवस")
        ),
        EventEntry(
            bs = "2082-02-18",
            tithi = "षष्ठी",
            holiday = false,
            events = listOf("सिथिनखः", "वन उपभोक्ता दिवस", "कुुमार षष्ठी", "भक्तपुरमा चण्डीभगवती जात्रा")
        ),
        EventEntry(
            bs = "2082-02-19",
            tithi = "सप्तमी",
            holiday = false,
            events = listOf("कुमार यात्रा")
        ),
        EventEntry(
            bs = "2082-02-20",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("वायु अष्टमी", "भौमाष्टमी ब्रत", "गोरखकाली पूजा")
        ),
        EventEntry(
            bs = "2082-02-21",
            tithi = "नवमी",
            holiday = false,
            events = listOf("जातीय भेदभाव तथा छुवाछूत उन्मूलन दिवस")
        ),
        EventEntry(
            bs = "2082-02-22",
            tithi = "दशमी",
            holiday = false,
            events = listOf("गोसाइँकुण्ड स्नान समाप्ति", "विश्व वातावरण दिवस", "रामेश्वर पूजा", "गंगा दशहरा स्नान मेला", "हत्यामोचन स्नान")
        ),
        EventEntry(
            bs = "2082-02-24",
            tithi = "एकादशी",
            holiday = true,
            events = listOf("स्मार्तको निर्जला एकादशी व्रत", "तुलसीको बीज रोप्न")
        ),
        EventEntry(
            bs = "2082-02-25",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-02-27",
            tithi = "चतुर्दशी",
            holiday = false,
            events = listOf("पूर्णिमाव्रत")
        ),
        EventEntry(
            bs = "2082-02-28",
            tithi = "पूर्णिमा",
            holiday = false,
            events = listOf("मष्ट पूर्णिमा", "ज्याःपून्हि", "पनौतीमा स्नानमेला", "पनौतीमा भैरव–भद्रकाली–इन्द्रेश्वरकोजात्रा")
        ),
        EventEntry(
            bs = "2082-02-29",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("बालश्रमविरुद्धको दिवस")
        ),
        EventEntry(
            bs = "2082-02-31",
            tithi = "तृतीया",
            holiday = true,
            events = listOf("विश्व रक्तदाता दिवस")
        )
    ),
    3 to listOf(
        EventEntry(
            bs = "2082-03-01",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("असार संक्रान्ति")
        ),
        EventEntry(
            bs = "2082-03-02",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय परिवार रेमिटेयान्स दिवस")
        ),
        EventEntry(
            bs = "2082-03-03",
            tithi = "षष्ठी",
            holiday = false,
            events = listOf("विश्व खडेरी राेकथाम दिवस")
        ),
        EventEntry(
            bs = "2082-03-04",
            tithi = "सप्तमी",
            holiday = false,
            events = listOf("गोरखकाली पूजा", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-03-05",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("भल-भल अष्टमी", "देवपाटनमा त्रिशूलजात्रा")
        ),
        EventEntry(
            bs = "2082-03-06",
            tithi = "नवमी",
            holiday = false,
            events = listOf("विश्व शरणार्थी दिवस", "नक्वाःदिसि")
        ),
        EventEntry(
            bs = "2082-03-07",
            tithi = "एकादशी",
            holiday = true,
            events = listOf("विश्व योग दिवस", "योगिनी एकादशी व्रत", "विश्व संगीत दिवस")
        ),
        EventEntry(
            bs = "2082-03-08",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("भूमिरज", "वैष्णवहरुको योगिनी एकादशी व्रत")
        ),
        EventEntry(
            bs = "2082-03-09",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("सोम प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-03-10",
            tithi = "चतुर्दशी",
            holiday = false,
            events = listOf("दिलाच:ह्रे पूजा")
        ),
        EventEntry(
            bs = "2082-03-11",
            tithi = "औंसी",
            holiday = false,
            events = listOf("दर्शश्राद्ध", "हलो बार्ने", "भूमी पूजा")
        ),
        EventEntry(
            bs = "2082-03-12",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("चन्द्रोदय:", "विश्व लागूपदार्थ ओसार-पसार विरुद्धको दिवस")
        ),
        EventEntry(
            bs = "2082-03-13",
            tithi = "द्वितीया",
            holiday = false,
            events = listOf("जगन्नाथ रथ जात्रा")
        ),
        EventEntry(
            bs = "2082-03-15",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("दही-चिउरा खाने दिन", "राष्ट्रिय धान दिवस (रोपईं महोत्सव )")
        ),
        EventEntry(
            bs = "2082-03-18",
            tithi = "सप्तमी",
            holiday = false,
            events = listOf("सूर्य पूजा", "देवपाटनमा गंगामाई रथयात्रा", "विश्व खेलकुद पत्रकार दिवस")
        ),
        EventEntry(
            bs = "2082-03-19",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("गोरखकाली पूजा", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-03-21",
            tithi = "दशमी",
            holiday = true,
            events = listOf("अन्तर्राष्ट्रिय सहकारी दिवस")
        ),
        EventEntry(
            bs = "2082-03-22",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("तुलसी रोपण", "चतुर्मास व्रत शुरु", "हरिशयनी एकादशी व्रत")
        ),
        EventEntry(
            bs = "2082-03-23",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("तुलसीपिए")
        ),
        EventEntry(
            bs = "2082-03-24",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-03-26",
            tithi = "पूर्णिमा",
            holiday = false,
            events = listOf("गुरु पूर्णिमा", "गुरु(व्यास) पूजा", "दिल्ला: पुन्ही", "पुर्णिमा व्रत")
        ),
        EventEntry(
            bs = "2082-03-27",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("विश्व जनसंख्या दिवस")
        ),
        EventEntry(
            bs = "2082-03-29",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("भानु जयन्ती")
        ),
        EventEntry(
            bs = "2082-03-31",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("बीतक कथा प्रारम्भ", "विश्व युवा दक्षता दिवस")
        )
    ),
    4 to listOf(
        EventEntry(
            bs = "2082-04-01",
            tithi = "सप्तमी",
            holiday = false,
            events = listOf("लूतो फाल्ने", "अष्टमीब्रत", "थारूहरूको गुरही-गुरिया पर्व", "श्रावण संक्रान्ति", "दक्षिणायन शुरु", "कण्डकारक पूजा")
        ),
        EventEntry(
            bs = "2082-04-02",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("कमैया मुक्ति दिवस", "गोरखकाली पूजा")
        ),
        EventEntry(
            bs = "2082-04-05",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("कामिका एकादशी व्रत")
        ),
        EventEntry(
            bs = "2082-04-06",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("विपी स्मृति दिवस", "प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-04-07",
            tithi = "चतुर्दशी",
            holiday = false,
            events = listOf("गथाँमुग च:ह्रे पूजा", "घण्टाकर्ण चतुर्दशी (गठेमंगल)")
        ),
        EventEntry(
            bs = "2082-04-08",
            tithi = "औंसी",
            holiday = false,
            events = listOf("दर्शश्राद्ध", "हलो बार्ने", "निशि बार्ने")
        ),
        EventEntry(
            bs = "2082-04-09",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("गुँला पर्वशुरु")
        ),
        EventEntry(
            bs = "2082-04-10",
            tithi = "द्वितीया",
            holiday = true,
            events = listOf("चन्द्रोदय:")
        ),
        EventEntry(
            bs = "2082-04-11",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("वराह जयन्ती")
        ),
        EventEntry(
            bs = "2082-04-13",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("नाग–पञ्चमी")
        ),
        EventEntry(
            bs = "2082-04-14",
            tithi = "षष्ठी",
            holiday = false,
            events = listOf("कल्की जयन्ती")
        ),
        EventEntry(
            bs = "2082-04-15",
            tithi = "सप्तमी",
            holiday = false,
            events = listOf("खीर खाने", "गोस्वामी तुलासीदास जयन्ती")
        ),
        EventEntry(
            bs = "2082-04-16",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("यलपञ्चदान", "गोरखकाली पूजा", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-04-17",
            tithi = "अष्टमी",
            holiday = true,
            events = listOf("विश्व स्तनपान सप्ताह प्रारम्भ")
        ),
        EventEntry(
            bs = "2082-04-20",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("पुत्रदा एकादशी")
        ),
        EventEntry(
            bs = "2082-04-21",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("प्रदोष व्रत", "बहिध्यब्बोय")
        ),
        EventEntry(
            bs = "2082-04-23",
            tithi = "चतुर्दशी",
            holiday = false,
            events = listOf("ह्यग्रीवोत्पत्ति:", "पूर्णिमाव्रत", "श्री शिव-पवित्र रोपण", "विश्व भू- संरक्षण दिवस")
        ),
        EventEntry(
            bs = "2082-04-24",
            tithi = "पूर्णिमा",
            holiday = true,
            events = listOf("रक्षाबन्धन (बिदा)", "ऋषितर्पणी (जनै पूर्णिमा)", "विश्व आदिवासी दिवस", "संस्कृत दिवस")
        ),
        EventEntry(
            bs = "2082-04-25",
            tithi = "प्रतिपदा",
            holiday = true,
            events = listOf("गोयात्रा (गाईजात्रा) सापारु")
        ),
        EventEntry(
            bs = "2082-04-26",
            tithi = "द्वितीया",
            holiday = false,
            events = listOf("रोपाई जात्रा")
        ),
        EventEntry(
            bs = "2082-04-27",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय युवा दिवस")
        ),
        EventEntry(
            bs = "2082-04-28",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय युवा दिवस")
        ),
        EventEntry(
            bs = "2082-04-29",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("ल. पू. नृसिंह यात्रा")
        ),
        EventEntry(
            bs = "2082-04-31",
            tithi = "अष्टमी",
            holiday = true,
            events = listOf("श्रीकृष्ण जन्माष्टमी व्रत (मोहरात्री) (बिदा)", "मोहरात्री", "गोरखकाली पूजा", "अष्टमीब्रत")
        )
    ),
    5 to listOf(
        EventEntry(
            bs = "2082-05-01",
            tithi = "नवमी",
            holiday = false,
            events = listOf("गुँगा नवमी", "भाद्र संक्रान्ति", "कीर्तिपुरमा बाघभैरव जात्रा", "श्री कृष्ण रथ यात्रा", "राधा कृष्ण रथ यात्रा", "वल्केपर्व")
        ),
        EventEntry(
            bs = "2082-05-03",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("स्मार्तको अजा एकादशी व्रत")
        ),
        EventEntry(
            bs = "2082-05-04",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-05-05",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("जुग: चह्रे पूजा")
        ),
        EventEntry(
            bs = "2082-05-06",
            tithi = "चतुर्दशी",
            holiday = false,
            events = listOf("दर्शश्राद्ध", "निशि बार्ने")
        ),
        EventEntry(
            bs = "2082-05-07",
            tithi = "औंसी",
            holiday = true,
            events = listOf("कुशेऔंसी / पिता सम्मान दिवस / बुवाको मुख हेर्ने", "हलो बार्ने", "मोतीराम जयन्ती")
        ),
        EventEntry(
            bs = "2082-05-08",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("गुँला पर्व समाप्त", "चन्द्रोदय:")
        ),
        EventEntry(
            bs = "2082-05-09",
            tithi = "द्वितीया",
            holiday = false,
            events = listOf("तीजको दर खाने")
        ),
        EventEntry(
            bs = "2082-05-10",
            tithi = "तृतीया",
            holiday = true,
            events = listOf("हरितालिका (तीज) व्रत (महिला मात्र) (बिदा)", "चन्द्रदर्शन, दोष:चथा")
        ),
        EventEntry(
            bs = "2082-05-11",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("राष्ट्रिय धर्मसभा दिवस", "गणेश चतुर्थी")
        ),
        EventEntry(
            bs = "2082-05-12",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("ऋषिपञ्चमी व्रत (सप्तर्षी पूजा )", "कोखजा विये", "सप्तऋषि पूजा", "विरूडा पञ्चमी")
        ),
        EventEntry(
            bs = "2082-05-13",
            tithi = "षष्ठी",
            holiday = false,
            events = listOf("सूर्य षष्ठी")
        ),
        EventEntry(
            bs = "2082-05-14",
            tithi = "सप्तमी",
            holiday = true,
            events = listOf("गौरा सप्तमी व्रत", "अमुक्तभरण सप्तमी", "महालक्ष्मी ब्रत शुरु")
        ),
        EventEntry(
            bs = "2082-05-15",
            tithi = "अष्टमी",
            holiday = true,
            events = listOf("गौरापर्व (सम्बन्धित क्षेत्रमा) (बिदा)", "काय:अष्टमी", "गोरखकाली पूजा", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-05-16",
            tithi = "नवमी",
            holiday = false,
            events = listOf("अदु:ख नवमी ब्रत")
        ),
        EventEntry(
            bs = "2082-05-17",
            tithi = "दशमी",
            holiday = false,
            events = listOf("निवृत्तिभरण दिवस")
        ),
        EventEntry(
            bs = "2082-05-18",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("हरिपरिवर्तिनी एकादशी व्रत")
        ),
        EventEntry(
            bs = "2082-05-19",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("ईन्द्रधोजोत्थान", "बामन द्वादशी")
        ),
        EventEntry(
            bs = "2082-05-20",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("प्रदोष व्रत", "मानव बेचविखन विरुद्धको राष्ट्रिय दिवस")
        ),
        EventEntry(
            bs = "2082-05-21",
            tithi = "चतुर्दशी",
            holiday = true,
            events = listOf("इन्द्रजात्रा (स्वाँछ्या) (कुमारी-भैरव्-गणेशको रथ जात्रा) (बिदा)", "अनन्त चतुर्दशी ब्रत")
        ),
        EventEntry(
            bs = "2082-05-22",
            tithi = "पूर्णिमा",
            holiday = false,
            events = listOf("निजामती सेवा दिवस (निजामती कर्मचारी मात्र)", "दहचोक (कान्तिपुर)मा इन्द्रदह–स्नान", "भक्तपुर सिद्धपोखरी मेला", "चोनामपर्व (चेपाङ)", "पूर्णिमाव्रत", "खग्रास चन्द्रग्रहण")
        ),
        EventEntry(
            bs = "2082-05-23",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("सोह्रश्राद्ध प्रारम्भ", "विश्व शिक्षा तथा साक्षरता दिवस", "पुञ्चली भुजा", "श्राद्ध शुरु -प्रतिपदा श्राद्ध")
        ),
        EventEntry(
            bs = "2082-05-24",
            tithi = "द्वितीया",
            holiday = false,
            events = listOf("द्वितीया श्राद्ध")
        ),
        EventEntry(
            bs = "2082-05-25",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("गातिला", "तृतीया श्राद्ध")
        ),
        EventEntry(
            bs = "2082-05-26",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("चौथी श्राद्ध", "नानिचाया:", "इन्द्र धोजपातनं")
        ),
        EventEntry(
            bs = "2082-05-27",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("पञ्चमी श्राद्ध", "षष्ठी श्राद्ध", "निवृत्तिभरण दिवस")
        ),
        EventEntry(
            bs = "2082-05-28",
            tithi = "षष्ठी",
            holiday = true,
            events = listOf("सप्तमी श्राद्ध")
        ),
        EventEntry(
            bs = "2082-05-29",
            tithi = "सप्तमी",
            holiday = false,
            events = listOf("रवि सप्तमी ब्रत", "बाल दिवस", "गोरखकाली पूजा", "महालक्ष्मी व्रत समाप्त", "अष्टमी श्राद्ध", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-05-30",
            tithi = "अष्टमी",
            holiday = true,
            events = listOf("जीवतपुतृका ब्रत (जितियापर्व) (बिदा)", "नवमी श्राद्ध", "मातृ नवमी")
        ),
        EventEntry(
            bs = "2082-05-31",
            tithi = "दशमी",
            holiday = false,
            events = listOf("दशमी श्राद्ध")
        )
    ),
    6 to listOf(
        EventEntry(
            bs = "2082-06-01",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("विश्वकर्मा पूजा", "इन्दिरा एकादशी व्रत", "एकादशी श्राद्ध", "वास्तु दिवस", "राष्ट्रिय विज्ञान दिवस", "आश्विन संक्रान्ति")
        ),
        EventEntry(
            bs = "2082-06-02",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("फर्पिङमा हरिशंकर यात्रा", "द्वादशी श्राद्ध")
        ),
        EventEntry(
            bs = "2082-06-03",
            tithi = "त्रयोदशी",
            holiday = true,
            events = listOf("संविधान दिवस (बिदा)", "त्रयोदशी श्राद्ध", "कलियुगादि", "प्रदोष व्रत", "मघा श्राद्ध")
        ),
        EventEntry(
            bs = "2082-06-04",
            tithi = "चतुर्दशी",
            holiday = true,
            events = listOf("चतुर्दशी श्राद्ध", "न:लास्वने च:ह्रे पूजा")
        ),
        EventEntry(
            bs = "2082-06-05",
            tithi = "औंसी",
            holiday = false,
            events = listOf("विश्व शान्ति दिवस", "सोह्रश्राद्ध पुर्ति (पितृ विसर्जन)", "औंसी श्राद्ध", "निशि बार्ने", "दर्शश्राद्ध", "हलो बार्ने", "विश्व अल्जाइमर दिवस")
        ),
        EventEntry(
            bs = "2082-06-06",
            tithi = "प्रतिपदा",
            holiday = true,
            events = listOf("घटस्थापना (न:ला स्वने ) (बिदा)", "नवरात्रत्राम्भ:", "सामाजिक सेवा दिवस")
        ),
        EventEntry(
            bs = "2082-06-07",
            tithi = "द्वितीया",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय सांकेतिक भाषा दिवस", "चन्द्रोदय:")
        ),
        EventEntry(
            bs = "2082-06-09",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("विश्व फार्मेसिस्ट दिवस")
        ),
        EventEntry(
            bs = "2082-06-10",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय परमाणु हतियार निर्मुल दिवस", "उपाङ्गललिता व्रत")
        ),
        EventEntry(
            bs = "2082-06-11",
            tithi = "पञ्चमी",
            holiday = true,
            events = listOf("विश्व पर्यटन दिवस", "पचली भैरव यात्रा")
        ),
        EventEntry(
            bs = "2082-06-12",
            tithi = "षष्ठी",
            holiday = false,
            events = listOf("रेबिजविरुद्ध दिवस", "विल्वनिमन्त्रण")
        ),
        EventEntry(
            bs = "2082-06-13",
            tithi = "सप्तमी",
            holiday = true,
            events = listOf("फूलपाती (बिदा)", "विश्व हृदय दिवस", "नवपत्रिका प्रवेश (फूलपाती)", "सरस्वतीलाई आवाहनगर्ने")
        ),
        EventEntry(
            bs = "2082-06-14",
            tithi = "अष्टमी",
            holiday = true,
            events = listOf("महाष्टमी व्रत (बिदा)", "कालरात्री", "कुलछिभ्वय्‌", "भौमाष्टमी ब्रत", "गोरखकाली पूजा")
        ),
        EventEntry(
            bs = "2082-06-15",
            tithi = "नवमी",
            holiday = true,
            events = listOf("महानवमी (बिदा)", "अन्तर्राष्ट्रिय वृद्ध-वृद्धा दिवस", "स्याक्वत्याक्व", "बौद्धावतार", "मन्वादिः")
        ),
        EventEntry(
            bs = "2082-06-16",
            tithi = "दशमी",
            holiday = true,
            events = listOf("विजया दशमी (दशैको टिका ) (बिदा)", "खड्ग यात्रा", "देवीविसर्जन", "अन्तर्राष्ट्रिय अहिंसा दिवस")
        ),
        EventEntry(
            bs = "2082-06-17",
            tithi = "एकादशी",
            holiday = true,
            events = listOf("अन्नपूर्णयात्रा/असंचालं (बिदा)", "पापाकुशां एकादशी व्रत")
        ),
        EventEntry(
            bs = "2082-06-18",
            tithi = "द्वादशी",
            holiday = true,
            events = listOf("शनि प्रदोष व्रत", "विश्व प्राणी दिवस")
        ),
        EventEntry(
            bs = "2082-06-19",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("विश्व शिक्षक दिवस")
        ),
        EventEntry(
            bs = "2082-06-20",
            tithi = "चतुर्दशी",
            holiday = false,
            events = listOf("कोजाग्रतब्रत", "अखिलवलि पुर्ति:", "श्रीघ:या:", "पूर्णिमाव्रत")
        ),
        EventEntry(
            bs = "2082-06-21",
            tithi = "पूर्णिमा",
            holiday = false,
            events = listOf("कार्तिकस्नान/आकाशदीपदानशुरु")
        ),
        EventEntry(
            bs = "2082-06-23",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("विश्व हुलाक दिवस")
        ),
        EventEntry(
            bs = "2082-06-24",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("विश्व मानसिक स्वास्थ दिवस")
        ),
        EventEntry(
            bs = "2082-06-25",
            tithi = "पञ्चमी",
            holiday = true,
            events = listOf("गैर-आवासीय नेपाली दिवस")
        ),
        EventEntry(
            bs = "2082-06-27",
            tithi = "सप्तमी",
            holiday = false,
            events = listOf("अष्टमीब्रत", "प्राकृतिक विपत्ति न्यूनीकरण दिवस")
        ),
        EventEntry(
            bs = "2082-06-28",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("विश्व गुणस्तर दिवस", "राधाष्टमी", "भौमाष्टमी ब्रत", "गोरखकाली पूजा")
        ),
        EventEntry(
            bs = "2082-06-29",
            tithi = "नवमी",
            holiday = false,
            events = listOf("ग्रामीण महिला दिवस", "विश्व हात धुने दिवस")
        ),
        EventEntry(
            bs = "2082-06-30",
            tithi = "दशमी",
            holiday = false,
            events = listOf("विश्व खाद्य दिवस")
        ),
        EventEntry(
            bs = "2082-06-31",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय गरिबी उन्मूलन दिवस", "रमा एकादशी ब्रत", "गोवत्स द्वादशी")
        )
    ),
    7 to listOf(
        EventEntry(
            bs = "2082-07-01",
            tithi = "द्वादशी",
            holiday = true,
            events = listOf("धनत्रयोदशी (धनतेरस)", "यमदीप–दान", "शनि प्रदोष व्रत", "कार्तिक संक्रान्ति")
        ),
        EventEntry(
            bs = "2082-07-02",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("धन्वन्तरि जयन्ती", "काकवलि (काग तिहार)", "स्वन्तिचःह्रे पूजा")
        ),
        EventEntry(
            bs = "2082-07-03",
            tithi = "चतुर्दशी",
            holiday = true,
            events = listOf("दीपावली (लक्ष्मी पूजा) (बिदा)", "श्वानपूजा (कुकुर तिहार)", "नरक चतुर्दशी", "महाकवि लक्ष्मीप्रसाद देवकोटा जयन्ती", "सुखरात्री", "दीपमालिका", "निशि बार्ने", "विहान झिसमिसेमा तेल लगाएर नुहाउने")
        ),
        EventEntry(
            bs = "2082-07-04",
            tithi = "औंसी",
            holiday = true,
            events = listOf("दर्शश्राद्ध (बिदा)", "हलो बार्ने")
        ),
        EventEntry(
            bs = "2082-07-05",
            tithi = "प्रतिपदा",
            holiday = true,
            events = listOf("गाई तिहार (बिदा)", "म्हः पूजा", "गोवर्द्धन पूजा", "नेपाल सम्वत् ११४६ शुरु", "गोरु तिहार- पूजा", "वलिपूजा", "हलि तिहार")
        ),
        EventEntry(
            bs = "2082-07-06",
            tithi = "द्वितीया",
            holiday = true,
            events = listOf("भाइटीका (किजा पूजा) (बिदा)", "यम–द्वितीया", "चन्द्रोदय:")
        ),
        EventEntry(
            bs = "2082-07-07",
            tithi = "तृतीया",
            holiday = true,
            events = listOf("विश्व विकास सूचना दिवस (बिदा)", "संयुक्त राष्ट्रसङ्घ दिवस")
        ),
        EventEntry(
            bs = "2082-07-10",
            tithi = "षष्ठी",
            holiday = true,
            events = listOf("छठपर्व")
        ),
        EventEntry(
            bs = "2082-07-12",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("गोपाष्टमी", "बुधाष्टमी व्रत", "सिन्लङा (बैतडी) महारुद्रकोटिहोम मेला", "मुखःअष्टमी", "गोरखकाली पूजा")
        ),
        EventEntry(
            bs = "2082-07-13",
            tithi = "नवमी",
            holiday = false,
            events = listOf("सत्ययुगादि", "कुष्माण्ड नवमी", "सक्व चंगु वने", "हेटौडामा कुष्माण्ड सरोवरमेला")
        ),
        EventEntry(
            bs = "2082-07-14",
            tithi = "दशमी",
            holiday = false,
            events = listOf("विश्व शहरीकरण दिवस", "बलम्बु महालक्ष्मी जात्रा", "फूलखर्क (धादिङ ) गंगाजमुनामेला")
        ),
        EventEntry(
            bs = "2082-07-15",
            tithi = "एकादशी",
            holiday = true,
            events = listOf("हरिबोधिनी एकादशी व्रत", "भीष्मपञ्चक शूरु", "तुलसी विवाह")
        ),
        EventEntry(
            bs = "2082-07-16",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("चाँगुनारायण अखण्डदीप दर्शन")
        ),
        EventEntry(
            bs = "2082-07-17",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("सोम प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-07-18",
            tithi = "चतुर्दशी",
            holiday = false,
            events = listOf("युनेस्को दिवस")
        ),
        EventEntry(
            bs = "2082-07-19",
            tithi = "पूर्णिमा",
            holiday = true,
            events = listOf("गुरु नानक जयन्ती (शिख धर्मावलम्बी)", "चतुर्मास व्रत पूर्ण", "कार्तिक स्नानब्रत पूर्ण", "पूर्णिमाव्रत")
        ),
        EventEntry(
            bs = "2082-07-20",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("थानकोटमा महालक्ष्मी यात्रा", "त्रिजटालाई अर्घ्य दिने")
        ),
        EventEntry(
            bs = "2082-07-22",
            tithi = "तृतीया",
            holiday = true,
            events = listOf("विश्व रेडियोग्राफी दिवस")
        ),
        EventEntry(
            bs = "2082-07-23",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("विश्व स्वतन्त्रता दिवस")
        ),
        EventEntry(
            bs = "2082-07-24",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("शान्ति र विकासको लागि विश्व विज्ञान दिवस")
        ),
        EventEntry(
            bs = "2082-07-25",
            tithi = "षष्ठी",
            holiday = true,
            events = listOf("फाल्गुनानन्द जयन्ती (किराँत धर्मावलम्बी मात्र)")
        ),
        EventEntry(
            bs = "2082-07-26",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("बुधाष्टमी व्रत", "गोरखकाली पूजा")
        ),
        EventEntry(
            bs = "2082-07-28",
            tithi = "दशमी",
            holiday = false,
            events = listOf("विश्व मधुमेह दिवस", "गुह्येश्वरी यात्रा")
        ),
        EventEntry(
            bs = "2082-07-29",
            tithi = "एकादशी",
            holiday = true,
            events = listOf("उत्पत्तिका एकादशी व्रत")
        ),
        EventEntry(
            bs = "2082-07-30",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय सहनशीलता दिवस")
        )
    ),
    8 to listOf(
        EventEntry(
            bs = "2082-08-01",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("सोम प्रदोष व्रत", "मार्ग शीर्ष संक्रान्ति", "अन्तर्राष्ट्रिय विद्यार्थी दिवस")
        ),
        EventEntry(
            bs = "2082-08-02",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("अर्जुनधारा मेला", "बालाचह्रे पूजा")
        ),
        EventEntry(
            bs = "2082-08-03",
            tithi = "चतुर्दशी",
            holiday = false,
            events = listOf("बाला चतुर्दशी (शत बीज छर्ने)", "विश्व शौचालय दिवस", "दर्शश्राद्ध", "निशि बार्ने")
        ),
        EventEntry(
            bs = "2082-08-04",
            tithi = "औंसी",
            holiday = false,
            events = listOf("विश्व बाल दिवस", "स्नानदान गर्ने औँशी", "हलो बार्ने")
        ),
        EventEntry(
            bs = "2082-08-05",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("टेलिभिजन दिवस", "चन्द्रोदय:")
        ),
        EventEntry(
            bs = "2082-08-09",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("विवाहपञ्चमी(सर्वत्र श्री सीतारामको विवाह-उत्सव)", "महिला हिंसा अन्त्य दिवस")
        ),
        EventEntry(
            bs = "2082-08-12",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("बखुमद", "गोरखकाली पूजा", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-08-13",
            tithi = "नवमी",
            holiday = true,
            events = listOf("पाँगामा वैष्णवी देवी जात्रा")
        ),
        EventEntry(
            bs = "2082-08-14",
            tithi = "दशमी",
            holiday = false,
            events = listOf("कीर्तिपुरमा इन्द्रायणी जात्रा")
        ),
        EventEntry(
            bs = "2082-08-15",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("मोक्षदा एकादशी ब्रत", "विश्व एड्स दिवस", "गीता जयन्ती")
        ),
        EventEntry(
            bs = "2082-08-16",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("विश्व दासता उन्मूलन दिवस", "प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-08-17",
            tithi = "त्रयोदशी",
            holiday = true,
            events = listOf("विश्व अपाङ्ग दिवस (विशेष क्षमताभएकाहरु मात्र) (बिदा)", "काशीको पिशाचमोचन तीर्थमा श्राद्ध")
        ),
        EventEntry(
            bs = "2082-08-18",
            tithi = "चतुर्दशी",
            holiday = true,
            events = listOf("उँधौली पर्व (बिदा)", "दत्तात्रय जयन्ती", "य:मरी पुन्ही", "धान्य पूर्णिमा", "नुवाकोट दुप्चेश्वर मेला", "गैडु पूजा", "पूर्णिमाव्रत")
        ),
        EventEntry(
            bs = "2082-08-19",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("मतिना पारु", "स्वयंसेवक दिवस", "विश्व माटो दिवस", "कोका-कौशिकी संगममा मेला")
        ),
        EventEntry(
            bs = "2082-08-21",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय नागरिक उड्डयन दिवस")
        ),
        EventEntry(
            bs = "2082-08-22",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय मर्यादित महिनावारी दिवस")
        ),
        EventEntry(
            bs = "2082-08-23",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("भ्रष्टाचारविरुद्धको अन्तर्राष्ट्रिय दिवस")
        ),
        EventEntry(
            bs = "2082-08-24",
            tithi = "षष्ठी",
            holiday = false,
            events = listOf("विश्व मानव अधिकार दिवस")
        ),
        EventEntry(
            bs = "2082-08-25",
            tithi = "सप्तमी",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय पर्वत दिवस")
        ),
        EventEntry(
            bs = "2082-08-26",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("गोरखकाली पूजा", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-08-28",
            tithi = "दशमी",
            holiday = false,
            events = listOf("दिशी पूजा")
        ),
        EventEntry(
            bs = "2082-08-29",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("सफला एकादशी ब्रत")
        )
    ),
    9 to listOf(
        EventEntry(
            bs = "2082-09-01",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("राष्ट्रिय झण्डा दिवस", "पौष संक्रान्ति")
        ),
        EventEntry(
            bs = "2082-09-02",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-09-03",
            tithi = "चतुर्दशी",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय आप्रवासी दिवस", "दिशी चर्हे पूजा")
        ),
        EventEntry(
            bs = "2082-09-04",
            tithi = "औंसी",
            holiday = false,
            events = listOf("गयामौनी कोका-कौषिका औँशी", "दर्शश्राद्ध", "हलो बार्ने", "निशि बार्ने")
        ),
        EventEntry(
            bs = "2082-09-05",
            tithi = "प्रतिपदा",
            holiday = true,
            events = listOf("तोल ल्होसार")
        ),
        EventEntry(
            bs = "2082-09-06",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("चन्द्रोदय:")
        ),
        EventEntry(
            bs = "2082-09-10",
            tithi = "पञ्चमी",
            holiday = true,
            events = listOf("क्रिसमस (इसाई धर्म मात्र)")
        ),
        EventEntry(
            bs = "2082-09-13",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("श्री श्वेत मत्स्येन्द्रनाथ स्नान (जन बहद्य: न्हवं)", "गोरखकाली पूजा", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-09-15",
            tithi = "एकादशी",
            holiday = true,
            events = listOf("तमु (गुरुङ) ल्होसार (बिदा)", "पुत्रदा एकादशी ब्रत", "कवि शिरोमणि लेखनाथ जयन्ती")
        ),
        EventEntry(
            bs = "2082-09-16",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("राष्ट्रिय मेलमिलाप दिवस", "मुस्याडुली")
        ),
        EventEntry(
            bs = "2082-09-17",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("राष्ट्रिय टोपी दिवस", "प्रदोष व्रत", "राष्ट्रिय पोशाक दिवस", "सन. २०२६ प्रारम्भ")
        ),
        EventEntry(
            bs = "2082-09-19",
            tithi = "पूर्णिमा",
            holiday = true,
            events = listOf("माघस्नान आरम्भ", "श्री स्वस्थानी व्रत शुरु", "चाँगुुनारायणमा कलश जात्रा (चाँगुुनारायण हैगु)", "पूर्णिमाव्रत", "माधव नारायण महोत्सव", "धार्मिक सांस्कृतिक पत्रकार समाज स्थापना दिवस")
        ),
        EventEntry(
            bs = "2082-09-21",
            tithi = "द्वितीया",
            holiday = false,
            events = listOf("श्री गुरु गोविन्द सिंह जयन्ती")
        ),
        EventEntry(
            bs = "2082-09-22",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("काशीमा (भारत) बडागणेशको उत्सब:")
        ),
        EventEntry(
            bs = "2082-09-23",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("अरनिको स्मृति दिवस")
        ),
        EventEntry(
            bs = "2082-09-24",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("नेपाल ज्योतिष परिषदको वार्षिकोत्सव")
        ),
        EventEntry(
            bs = "2082-09-26",
            tithi = "सप्तमी",
            holiday = true,
            events = listOf("अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-09-27",
            tithi = "अष्टमी",
            holiday = true,
            events = listOf("पृथ्वी जयन्ती (बिदा)", "राष्ट्रिय एकता दिवस", "गोरखकाली पूजा", "स्वामी परमानन्द स्मृति दिवस")
        ),
        EventEntry(
            bs = "2082-09-29",
            tithi = "दशमी",
            holiday = false,
            events = listOf("राष्ट्रिय भक्का दिवस")
        ),
        EventEntry(
            bs = "2082-09-30",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("षटतिला एकादशी व्रत")
        )
    ),
    10 to listOf(
        EventEntry(
            bs = "2082-10-01",
            tithi = "द्वादशी",
            holiday = true,
            events = listOf("माघे संक्रान्ति (घ्यौ:चाकु:सँन्हु ) (बिदा)", "माघीपर्व (थारु, मगर, छन्त्यालादिको पर्व)", "उत्तरायण शुरु", "देवघाटमा मकरस्नान", "राष्ट्रिय योग दिवस", "मकर स्नान")
        ),
        EventEntry(
            bs = "2082-10-02",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("प्रदोष व्रत", "भूकम्प सुरक्षा दिवस")
        ),
        EventEntry(
            bs = "2082-10-03",
            tithi = "चतुर्दशी",
            holiday = true,
            events = listOf("लै च:ह्रे पूजा")
        ),
        EventEntry(
            bs = "2082-10-04",
            tithi = "औंसी",
            holiday = false,
            events = listOf("पशुपतिनाथको आर्यघाटमा माधवनारायण मेला", "दर्शश्राद्ध", "हलो बार्ने", "निशि बार्ने")
        ),
        EventEntry(
            bs = "2082-10-05",
            tithi = "प्रतिपदा",
            holiday = true,
            events = listOf("सोनाम (तामाङ) ल्होसार (बिदा)", "श्री बल्लभ जयन्ती")
        ),
        EventEntry(
            bs = "2082-10-06",
            tithi = "द्वितीया",
            holiday = false,
            events = listOf("चन्द्रोदय:")
        ),
        EventEntry(
            bs = "2082-10-08",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("तिलकुन्द चतुर्थी")
        ),
        EventEntry(
            bs = "2082-10-09",
            tithi = "पञ्चमी",
            holiday = true,
            events = listOf("सरस्वती जयन्ती  (बिदा)", "वसन्त पञ्चमी", "श्री पञ्चमी (वसन्त श्रवण) (स्कूलहरूको लागि मात्र)", "हलो सारो गर्ने")
        ),
        EventEntry(
            bs = "2082-10-10",
            tithi = "षष्ठी",
            holiday = true,
            events = listOf("स्कन्द षष्ठी", "अन्तर्राष्ट्रिय शिक्षा दिवस")
        ),
        EventEntry(
            bs = "2082-10-11",
            tithi = "सप्तमी",
            holiday = false,
            events = listOf("रवि सप्तमी ब्रत", "अचला सप्तमी")
        ),
        EventEntry(
            bs = "2082-10-12",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("अन्तर्राष्ट्रिय भन्सार दिवस", "भीष्माष्टमी", "गोरखकाली पूजा", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-10-13",
            tithi = "नवमी",
            holiday = false,
            events = listOf("द्रोण नवमी")
        ),
        EventEntry(
            bs = "2082-10-14",
            tithi = "दशमी",
            holiday = false,
            events = listOf("शल्य दशमी")
        ),
        EventEntry(
            bs = "2082-10-15",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("नेपाल नर्सिङ दिवस", "भीमा एकादशी व्रत")
        ),
        EventEntry(
            bs = "2082-10-16",
            tithi = "द्वादशी",
            holiday = true,
            events = listOf("शहीद दिवस (बिदा)", "वटु (कान्तिपुर)मा माघयात्रा (सन्यादुलि)", "भीष्म द्वादशी", "प्रदोष व्रत", "चाँगु माधव नारायण मेला")
        ),
        EventEntry(
            bs = "2082-10-17",
            tithi = "त्रयोदशी",
            holiday = true,
            events = listOf("शौभाग्यशुर्पदान", "पशुुपतीनाथ छायाँ दर्शन")
        ),
        EventEntry(
            bs = "2082-10-18",
            tithi = "पूर्णिमा",
            holiday = false,
            events = listOf("श्री स्वस्थानी व्रत समाप्त", "माघस्नान पुर्ति", "पूर्णिमाव्रत", "माघयात्रा, सिपुन्ही")
        ),
        EventEntry(
            bs = "2082-10-19",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("विश्व सिमसार दिवस")
        ),
        EventEntry(
            bs = "2082-10-21",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("विश्व क्यान्सर दिवस")
        ),
        EventEntry(
            bs = "2082-10-25",
            tithi = "सप्तमी",
            holiday = false,
            events = listOf("रवि सप्तमी ब्रत")
        ),
        EventEntry(
            bs = "2082-10-26",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("गोरखकाली पूजा", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-10-28",
            tithi = "नवमी",
            holiday = false,
            events = listOf("विज्ञानमा महिला पहुँचको अन्तर्राष्ट्रिय दिवस", "सुरक्षित इन्टरनेट दिवस")
        )
    ),
    11 to listOf(
        EventEntry(
            bs = "2082-11-01",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("विश्व रेडियो दिवस", "विजया एकादशी ब्रत", "फाल्गुण संक्रान्ति", "जनयुद्ध दिवस")
        ),
        EventEntry(
            bs = "2082-11-02",
            tithi = "द्वादशी",
            holiday = true,
            events = listOf("प्रणय दिवस", "शनि प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-11-03",
            tithi = "त्रयोदशी",
            holiday = true,
            events = listOf("महाशिवरात्रि व्रत (बिदा)", "नेपाली सेना दिवस", "अन्तर्राष्ट्रिय बाल्यकाल क्यान्सर दिवस", "शिलाचह्रे पूजा", "काठमाडौंको पशुपतिनाथ, खोटाङमा हलेसी महादेवको मेला")
        ),
        EventEntry(
            bs = "2082-11-04",
            tithi = "चतुर्दशी",
            holiday = false,
            events = listOf("निशि बार्ने")
        ),
        EventEntry(
            bs = "2082-11-05",
            tithi = "औंसी",
            holiday = false,
            events = listOf("द्वापरयुगादि", "दर्शश्राद्ध", "हलो बार्ने")
        ),
        EventEntry(
            bs = "2082-11-06",
            tithi = "प्रतिपदा",
            holiday = true,
            events = listOf("ग्याल्पो ल्होसार")
        ),
        EventEntry(
            bs = "2082-11-07",
            tithi = "द्वितीया",
            holiday = true,
            events = listOf("राष्ट्रिय प्रजातन्त्र दिवस (बिदा)", "निर्वाचन दिवस", "चन्द्रोदय:")
        ),
        EventEntry(
            bs = "2082-11-08",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("सामाजिक न्याय दिवस")
        ),
        EventEntry(
            bs = "2082-11-09",
            tithi = "चतुर्थी",
            holiday = true,
            events = listOf("विश्व मातृभाषा दिवस")
        ),
        EventEntry(
            bs = "2082-11-12",
            tithi = "सप्तमी",
            holiday = false,
            events = listOf("चिरको उत्थान (चिर स्वाये)", "भौमाष्टमी ब्रत", "गोरखकाली पूजा")
        ),
        EventEntry(
            bs = "2082-11-15",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("राष्ट्रिय मगर दिवस", "आमलकी एकादशी")
        ),
        EventEntry(
            bs = "2082-11-16",
            tithi = "द्वादशी",
            holiday = true,
            events = listOf("गोविन्द द्वादशी")
        ),
        EventEntry(
            bs = "2082-11-17",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-11-18",
            tithi = "चतुर्दशी",
            holiday = true,
            events = listOf("पहाडमा होली (बिदा)", "पूर्णिमाव्रत")
        ),
        EventEntry(
            bs = "2082-11-19",
            tithi = "पूर्णिमा",
            holiday = true,
            events = listOf("तराईमा होली (बिदा)", "फागुपूर्णिमा", "ग्रस्तोदित खण्डग्रास चन्द्रग्रहण")
        ),
        EventEntry(
            bs = "2082-11-20",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("तेल लगाउने र आँपको मुजुरा खाने")
        ),
        EventEntry(
            bs = "2082-11-22",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("नाला मत्स्येन्द्रनाथ स्नान")
        ),
        EventEntry(
            bs = "2082-11-24",
            tithi = "पञ्चमी",
            holiday = true,
            events = listOf("अन्तर्राष्ट्रिय नारी दिवस")
        ),
        EventEntry(
            bs = "2082-11-27",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("शीतलाष्टमी", "बुधाष्टमी व्रत", "गोरखकाली पूजा")
        ),
        EventEntry(
            bs = "2082-11-30",
            tithi = "दशमी",
            holiday = true,
            events = listOf("पाई डे")
        )
    ),
    12 to listOf(
        EventEntry(
            bs = "2082-12-01",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("पापमोचनी एकादशी", "देवपत्तनमा देशोद्धार पूजा", "चैत्र संक्रान्ति", "विश्व उपभोक्ता दिवस")
        ),
        EventEntry(
            bs = "2082-12-02",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("सोम प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-12-03",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("पिशाच चतुर्दशी ( पाशाचह्रे पूजा )")
        ),
        EventEntry(
            bs = "2082-12-04",
            tithi = "चतुर्दशी",
            holiday = true,
            events = listOf("घोडेजात्रा (काठमाडौं मात्र) (बिदा)", "दर्शश्राद्ध", "निशि बार्ने")
        ),
        EventEntry(
            bs = "2082-12-05",
            tithi = "औंसी",
            holiday = false,
            events = listOf("स्नानदान गर्ने औँशी", "तेल लगाउने र नीमको पात खाने", "ज्योतिष दिवस")
        ),
        EventEntry(
            bs = "2082-12-06",
            tithi = "द्वितीया",
            holiday = false,
            events = listOf("चन्द्रोदय:")
        ),
        EventEntry(
            bs = "2082-12-07",
            tithi = "तृतीया",
            holiday = true,
            events = listOf("मत्स्यनारायण मेला", "मत्स्यजयन्ती (मच्छेगाउं कान्तिपुर )", "गौरी व्रत", "अन्तर्राष्ट्रिय जातिय उत्पीडन विरुद्धको दिवस")
        ),
        EventEntry(
            bs = "2082-12-08",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("विश्व पानी दिवस")
        ),
        EventEntry(
            bs = "2082-12-09",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("विश्व मौसम दिवस")
        ),
        EventEntry(
            bs = "2082-12-10",
            tithi = "षष्ठी",
            holiday = false,
            events = listOf("विश्व क्षयरोग दिवस")
        ),
        EventEntry(
            bs = "2082-12-12",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("चैते दशैँ (चैत्राष्टमी ब्रत)", "सेतो मत्स्येन्द्रनाथको रथजात्रा (जवया:)", "गोरखकाली पूजा", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-12-13",
            tithi = "नवमी",
            holiday = true,
            events = listOf("रामनवमी ब्रत (रामजयन्ती ) (बिदा)", "विश्व हिन्दु महासंघ स्थापना", "आध्यात्मिक पत्रकार समाज स्थापना दिवस", "विश्व रंगमञ्च दिवस")
        ),
        EventEntry(
            bs = "2082-12-15",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("कामदा एकादशी ब्रत")
        ),
        EventEntry(
            bs = "2082-12-16",
            tithi = "द्वादशी",
            holiday = false,
            events = listOf("सोम प्रदोष व्रत")
        ),
        EventEntry(
            bs = "2082-12-17",
            tithi = "त्रयोदशी",
            holiday = false,
            events = listOf("महावीर जयन्ती (जैन धर्मावलम्बी मात्र)")
        ),
        EventEntry(
            bs = "2082-12-18",
            tithi = "चतुर्दशी",
            holiday = false,
            events = listOf("पूर्णिमाव्रत", "विश्व मूर्ख दिवस")
        ),
        EventEntry(
            bs = "2082-12-19",
            tithi = "पूर्णिमा",
            holiday = false,
            events = listOf("बालाजुमा २२ धारा स्नान मेला", "हनुमान जयन्ती", "भक्तपुरमा विश्वध्वज-उत्थान", "बैसाख स्नान सुरु")
        ),
        EventEntry(
            bs = "2082-12-20",
            tithi = "प्रतिपदा",
            holiday = false,
            events = listOf("ल. पु मत्स्येन्द्रनाथ स्नान (बुंगन्हव)")
        ),
        EventEntry(
            bs = "2082-12-21",
            tithi = "द्वितीया",
            holiday = true,
            events = listOf("साखुमा जात्रा( सक्व यां:)")
        ),
        EventEntry(
            bs = "2082-12-22",
            tithi = "तृतीया",
            holiday = false,
            events = listOf("स्वामी शशिधर जयन्ती")
        ),
        EventEntry(
            bs = "2082-12-23",
            tithi = "चतुर्थी",
            holiday = false,
            events = listOf("विश्व खेलकूद दिवस")
        ),
        EventEntry(
            bs = "2082-12-24",
            tithi = "पञ्चमी",
            holiday = false,
            events = listOf("विश्व स्वास्थ्य दिवस")
        ),
        EventEntry(
            bs = "2082-12-27",
            tithi = "अष्टमी",
            holiday = false,
            events = listOf("गोरखकाली पूजा", "अष्टमीब्रत")
        ),
        EventEntry(
            bs = "2082-12-29",
            tithi = "दशमी",
            holiday = false,
            events = listOf("विश्व ज्योतिष महासंघ स्थापना दिवस")
        ),
        EventEntry(
            bs = "2082-12-30",
            tithi = "एकादशी",
            holiday = false,
            events = listOf("वरुथिनी एकादशी व्रत")
        )
    ),
)
