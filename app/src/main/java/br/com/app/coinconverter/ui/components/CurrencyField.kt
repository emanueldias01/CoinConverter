package br.com.app.coinconverter.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import br.com.app.coinconverter.ui.theme.CoinConverterTheme

@Composable
fun CurrencyField(
    currencies: List<String>,
    selectCurrency: String,
    currencyAmount: String,
    onCurrencySelector: (String) -> Unit,
    onCurrencyAmountChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CurrencySelector(
                currencies = currencies,
                selectCurrency = selectCurrency,
                onCurrencySelector = onCurrencySelector
            )

            OutlinedTextField(
                value = currencyAmount,
                onValueChange = onCurrencyAmountChanged,
                modifier = Modifier.weight(1f),
                textStyle = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                ),
                placeholder = {
                    Text(
                        text = "0",
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End
                        )
                        )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )
        }
    }
}

@Preview
@Composable
private fun CurrencyFieldPreview() {
    CoinConverterTheme {
        CurrencyField(
            currencies = listOf("USD", "BRL", "EUR"),
            selectCurrency = "USD",
            currencyAmount = "0.00",
            onCurrencySelector = {},
            onCurrencyAmountChanged = {},
        )
    }

}