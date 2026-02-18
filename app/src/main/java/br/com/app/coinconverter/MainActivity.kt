package br.com.app.coinconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.app.coinconverter.ui.theme.CoinConverterTheme
import com.example.conversordemoedas.ui.feature.converter.ConverterScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinConverterTheme {
                ConverterScreen()
            }
        }
    }
}