import java.util.Scanner


fun main() {
    val scanner = Scanner(System.`in`)
    var gameInProgress = 1
    while (gameInProgress == 1) {
        val levelInput = readIntByCase(scanner, InputCase.LEVEL)
        val selectedLevel = Level.entries.find { it.levelNumber == levelInput }!!
        val isItWin = playGame(scanner, selectedLevel)
        if (!isItWin) {
            println("Вы проиграли...")
        }
        gameInProgress = readIntByCase(scanner, InputCase.REPLAY)
    }
}