package `chapter 4`

// 4-07 Challenge Sealed Classes - Starter

/*
Challenge
Create a function that can take a `List` of `AcceptedCurrency` objects and the cost of an item
in Dollars, and return whether the user has sufficient funds in the list of currency objects
to pay for what they’re trying to buy.

Hint: Try a companion object!
*/

sealed class AcceptedCurrency {
    abstract val valueInDollars: Float
    var amount: Float = 0.0f

    class Dollar : AcceptedCurrency() {
        override val valueInDollars = 1.0f
    }

    class Euro : AcceptedCurrency() {
        override val valueInDollars = 1.25f
    }

    class Crypto : AcceptedCurrency() {
        override val valueInDollars = 2534.92f
    }

    val name: String
        get() = when (this) {
            is Euro -> "Euro"
            is Dollar -> "Dollars"
            is Crypto -> "MeowCoin"
        }

    fun totalValueInDollars(): Float {
        return amount * valueInDollars
    }

    // Challenge
    companion object {
        fun hasSufficientFunds(availableCurrency: List<AcceptedCurrency>, costInDollars: Float): Boolean {
            var totalFunds = 0.0f
            availableCurrency.forEach { currency -> totalFunds += currency.totalValueInDollars() }
            return totalFunds >= costInDollars
        }
    }

}

fun main() {
    val currency = AcceptedCurrency.Crypto()
    currency.amount = .27541f

    val dollars = AcceptedCurrency.Dollar()
    dollars.amount = 2000f

    // Test
    println(
        AcceptedCurrency.hasSufficientFunds(availableCurrency = listOf(currency, dollars), costInDollars = 1200f)
    )
    println(
        AcceptedCurrency.hasSufficientFunds(availableCurrency = listOf(currency, dollars), costInDollars = 3000f)
    )
}