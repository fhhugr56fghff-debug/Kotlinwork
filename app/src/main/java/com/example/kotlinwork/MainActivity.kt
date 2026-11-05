package com.example.kotlinwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinwork.ui.theme.KotlinWorkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.unit.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinWorkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Hello("Макс")
                    }
                }
                }
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Hello(name: String?){
    if (name == null){
        Text("Имя не задано")
    }
    else{
        Text("Привет $name !")
    }
}
@Preview(
    name = "portrait",
    showSystemUi = true,
    device = "spec:parent=pixel_5,orientation=portrait"
)
@Preview(
    name = "landscape",
    showSystemUi = true,
    device = "spec:parent=pixel_5,orientation=landscape"
)
@Preview(
    name = "round",
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFFFFFF00,
    device = "id:wearos_small_round"
)

@Composable
fun HelloPreview() {
    KotlinWorkTheme {
        Hello("Макс")
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinWorkTheme {
        Greeting("Android")
    }
}
@Composable
fun ComposeText1() {
    Text(
        text = stringResource(R.string.compose_description),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ComposeText2() {
    Text(
        text = stringResource(R.string.compose_description),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun ComposeText3() {
    Text(
        text = stringResource(R.string.compose_description),
        fontSize = 24.sp,
        color = Color.Black,
        textDecoration = TextDecoration.Underline,
        style = TextStyle(textIndent = TextIndent(firstLine = 48.sp)),
        modifier = Modifier.background(Color.Green)
    )
}

@Preview(name = "variant 1", showBackground = true)
@Composable
fun ComposeText1Preview() {
    KotlinWorkTheme { ComposeText1() }
}

@Preview(name = "variant 2", showBackground = true)
@Composable
fun ComposeText2Preview() {
    KotlinWorkTheme { ComposeText2() }
}

@Preview(name = "variant 3", showBackground = true)
@Composable
fun ComposeText3Preview() {
    KotlinWorkTheme { ComposeText3() }
}
@Composable
fun MyButton() {
    Button(
        onClick = { },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text(text = "Нажми на меня", letterSpacing = 1.sp)
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ButtonPreview() {
    KotlinWorkTheme { MyButton() }
}