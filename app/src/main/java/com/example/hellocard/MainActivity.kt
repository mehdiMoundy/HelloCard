package com.example.hellocard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hellocard.ui.theme.HelloCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    BirthdayGreetingWithImage(message = stringResource(R.string.happy_birthday_text),stringResource(
                                            R.string.signature_text))
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    Column (modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = message,
            fontSize = 40.sp,
            modifier = Modifier.padding( top = 20.dp)

)
        Text(
            text = from,
            fontSize = 20.sp,
            modifier = (Modifier
                .padding(10.dp)
                .align(Alignment.End))
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bunny)
    Box {
        Image(
            painter = painterResource(id = R.drawable.androidparty),
            contentDescription = "Cupcake",
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from =from )
    }
}

@Preview(showBackground = true,
    name = "Mon app",
    showSystemUi = true
)
@Composable
fun BirthdayCardPreview() {
    HelloCardTheme {
BirthdayGreetingWithImage(message = stringResource(id = R.string.happy_birthday_text), from = stringResource(
    id = R.string.signature_text
) )
    }
}