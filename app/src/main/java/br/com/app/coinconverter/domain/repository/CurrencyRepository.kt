package br.com.app.coinconverter.domain.repository

import br.com.app.coinconverter.domain.model.CurrencyConversion

interface CurrencyRepository {

    suspend fun convertCurrency(
        fromCurrency: String,
        toCurrency: String,
        amount: Double
    ): Result<CurrencyConversion>
}
