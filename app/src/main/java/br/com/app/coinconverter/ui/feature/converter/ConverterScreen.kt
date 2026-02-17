package br.com.app.coinconverter.ui.feature.converter

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.app.coinconverter.ui.theme.CoinConverterTheme

@Composable
fun ConverterScreen() {
    
}

@Composable
fun ConverterContent() {
    Column(
    ) {
        Text("Coin Converter")
    }
}

@Preview
@Composable
private fun ConverterConterPreview() {
    CoinConverterTheme {
        ConverterContent()
    }
}