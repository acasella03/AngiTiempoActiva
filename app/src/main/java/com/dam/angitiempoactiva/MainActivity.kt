package com.dam.angitiempoactiva

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Chronometer
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dam.angitiempoactiva.ui.theme.AngiTiempoActivaTheme

class MainActivity : ComponentActivity() {

    private val TAG: String = "Estado"
    private val NAME: String = "Android"
    private var startTime: Long = 0
    private var elapsedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AngiTiempoActivaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(NAME)
                }
            }
        }
        Log.d(TAG, "onCreate")
        startTime=SystemClock.elapsedRealtime()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")

        // Calcular el tiempo activo
        val tiempoActual=SystemClock.elapsedRealtime()
        val tiempoActivo = tiempoActual - startTime

        // Imprimir el tiempo activo en el logcat
        Log.d(TAG, "Tiempo activo: $tiempoActivo ms")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AngiTiempoActivaTheme {
        Greeting("Android")
    }
}