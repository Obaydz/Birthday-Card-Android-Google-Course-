package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        msg = "Happy Birthday Sam",
                        from = "from Obayd",
                    )
                }
            }
        }
    }


@Composable
fun GreetingText(msg : String, from : String, modifier : Modifier = Modifier){
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = modifier
            ) {
                Text (
                    text = msg,
                    fontSize = 100.sp,
                    lineHeight = 116.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = from,
                    fontSize = 36.sp,
                    modifier = Modifier
                        .padding(top = 16.dp, end = 16.dp)
                        .align(alignment = Alignment.End)
                )
            }
}

@Composable
fun GreetingImage(msg: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            msg = msg,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
    }


@Preview(
    showBackground = true
)
@Composable
fun BirthdayCardPreview() {
    MyApplicationTheme {
        GreetingImage(
            msg = "Happy Birthday Sam!",
            from = "- from Emma"
        )
    }
}
}