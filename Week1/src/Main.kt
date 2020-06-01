data class card(
    val pip:String,
    val suit:Char
)

fun main() {
    fun createDeck():MutableSet<card> {
        val suits = arrayOf('\u2663', '\u2660', '\u2666', '\u2665')
        val pips = arrayOf("A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2")
        val deck = mutableSetOf<card>()

        for (p in pips) {
            for (s in suits) {
                deck.add(card(p, s))
            }
        }
        return deck
    }

    fun dealHand(deck: MutableSet<card>, numberOfCards: Int, hand: MutableList<card>):MutableList<card> {
        var Hand = hand
        var i = numberOfCards
        while (i > 0) {
            val cardOut = deck.random()
            deck.remove(cardOut)
            hand.add(cardOut)
            i-=1
        }
        return Hand
    }

    fun evaluateHand(hand: MutableList<card>):Int {
        var total = 0
        for (i in 0 until hand.size) {
            var cardInEvaluation = hand.elementAt(i)
            when (cardInEvaluation.pip) {
                "A" -> total += 11
                "K" -> total += 10
                "Q" -> total += 10
                "J" -> total += 10
                else -> total += cardInEvaluation.pip.toInt()
            }
        }
        return total
    }

    fun printResults(total:Int, hand:MutableList<card>) {
        println("Your hand is:")
        for (i in 0 until hand.size) {
            var cardToShow = hand.elementAt(i)
            println("${cardToShow.pip} ${cardToShow.suit}")
        }
        println("For a total of $total")

    }

    //creates initial variables for the code to run
    var hand = mutableListOf<card>()
    val deck = createDeck()
    var total = 0
    //loop for the game
    println("Welcome to the Cassino, let's play BlackJack")
    println("Press any key to begin")
    readLine()
    hand + dealHand(deck, 2, hand)
    total += evaluateHand(hand)
    printResults(total, hand)
    loop@while (total<21) {
        if (total < 21){
            println("Press 'y' to draw 1 more card or any other key to finish.")
            var res = readLine()
                if (res == null ) {
                    println("Please enter a key.")
                } else if (res == "y"){
                    hand + dealHand(deck, 1, hand)
                    total += evaluateHand(hand)
                } else {
                    break@loop //print(" ")
                }
        } else {
            println("You lose, too bad, better luck next time!")
        }
        printResults(total, hand)
    }

    if (total == 21) {
        println("Congrats, you win, good for you!")
    }  else {
        println("You lose, too bad, better luck next time!")
    }
}