package br.com.app.coinconverter.ui.components

import android.icu.util.Currency
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.app.coinconverter.R
import br.com.app.coinconverter.ui.theme.CoinConverterTheme

@Composable
fun CurrencySelector(
    currencies: List<String>,
    selectCurrency: String,
    onCurrencySelector: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    var expaned by remember{
        mutableStateOf(false)
    }

    Row(
        modifier = modifier
            .clickable {
                expaned = true
            }.padding(16.dp)
    ) {
        Text(
            text = selectCurrency,
            fontWeight = FontWeight.Bold,
            
            )

        Icon(
            painter = painterResource(R.drawable.ic_keyboardarrow),
            contentDescription = null,
            modifier = Modifier.padding(start = 8.dp)
            )
    }

    Box {
        DropdownMenu(
            expanded = expaned,
            onDismissRequest = {
                expaned = false
            }
        ) {
            currencies.forEach { currency ->
                DropdownMenuItem(
                    text = {
                        Text(text = currency)
                    },
                    onClick = {
                        onCurrencySelector(currency)
                        expaned = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CurrencySelectorPreview() {
    CoinConverterTheme {
        CurrencySelector(
            currencies = listOf("USD", "BRL", "EUR"),
            selectCurrency = "USD",
            onCurrencySelector = {},
            modifier = Modifier
        )
    }
    
}