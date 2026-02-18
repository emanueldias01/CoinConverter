package br.com.app.coinconverter.data.repository

import br.com.app.coinconverter.data.network.KtorClient
import br.com.app.coinconverter.domain.model.CurrencyConversion
import br.com.app.coinconverter.domain.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val ktorClient: KtorClient,
) : CurrencyRepository {

    override suspend fun convertCurrency(
        fromCurrency: String,
        toCurrency: String,
        amount: Double
    ): Result<CurrencyConversion> {
        return runCatching {
            val response = ktorClient.convertCurrency(
                fromCurrency = fromCurrency,
                toCurrency = toCurrency,
                amount = amount,
            )

            CurrencyConversion(
                baseCode = response.baseCode,
                targetCode = response.targetCode,
                conversionRate = response.conversionRate.toString(),
                conversionResult = response.conversionResult.toString()
            )
        }
    }
}