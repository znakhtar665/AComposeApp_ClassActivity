package com.example.acomposeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.acomposeapp.ui.theme.AComposeAppTheme
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Counter()
                }
            }
        }
    }
}

@Composable
fun Counter() {

    var counter by rememberSaveable {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = {counter++}
        ){
            Text(text = "Increase")
        }
        Text(
            counter.toString(),
            fontSize = 64.sp

        )

        Button(
            onClick = {counter--}
        ){
            Text(text = "Decrease")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AComposeAppTheme {
        Counter()
    }
}