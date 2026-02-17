package br.com.app.coinconverter.ui.feature.converter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import br.com.app.coinconverter.R
import br.com.app.coinconverter.ui.components.CurrencyField
import br.com.app.coinconverter.ui.theme.CoinConverterTheme

@Composable
fun ConverterScreen() {
    
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConverterContent() {
    Scaffold(
        modifier = Modifier.imePadding(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Coin Converter",
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .consumeWindowInsets(innerPadding)
                .systemBarsPadding()
            ,
            contentAlignment = Alignment.Center
        ) {

            Column {
                CurrencyField(
                    currencies = listOf("USD", "BRL", "EUR"),
                    selectCurrency = "USD",
                    currencyAmount = "0.00",
                    onCurrencySelector = {},
                    onCurrencyAmountChanged = {},
                )

                Spacer(Modifier.height(8.dp))

                CurrencyField(
                    currencies = listOf("USD", "BRL", "EUR"),
                    selectCurrency = "BRL",
                    currencyAmount = "0.00",
                    onCurrencySelector = {},
                    onCurrencyAmountChanged = {},
                )
            }

            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primary,
                border = BorderStroke(0.5.dp, Color.LightGray)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_downward),
                    contentDescription = null,
                    modifier = Modifier.padding(6.dp),
                    tint = Color.White
                )
            }
        }
    }
}


@Preview
@Composable
private fun ConvertContentPreview() {
    CoinConverterTheme {
        ConverterContent()
    }
    
}