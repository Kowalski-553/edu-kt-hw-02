import java.util.Random
import java.util.Scanner

// чтение числа из ввода
fun readInt(scanner: Scanner, prompt: String): Int {
    while (true) {
        println(prompt)
        val input = scanner.next().toIntOrNull()
        if (input != null) return input
        println("Неверный ввод, повторите!")
    }
}

// чтение числа при выборе уровня, продолжении или не продолжении игры
fun readIntByCase(scanner: Scanner, case: InputCase): Int {
    while (true) {
        val input = readInt(scanner, case.prompt)
        if (input in case.range) {
            return input
        }
        println(case.error)
    }
}

// чтение числа при угадывании. Здесь как будто бы дублирование функции выше, но
// я не придумал, как от него избавиться.
fun readIntForGuess(scanner: Scanner, level: Level): Int {
    while (true) {
        val input = readInt(scanner, "Введите число в диапазоне ${level.range}")
        if (input in level.range) {
            return input
        }
        println("Число вне диапазона!")
    }
}

fun generateNumberToGuess(level: Level): Int {
    val random = Random()
    return random.nextInt(level.range.first, level.range.last + 1)
}

fun getResult(guess: Int, secret: Int): GuessResult {
    val result = when {
        guess == secret -> GuessResult.WIN
        guess < secret -> GuessResult.HIGHER
        else -> GuessResult.LOWER
    }
    return result
}

fun playGame(scanner: Scanner, level: Level): Boolean {
    val secret = generateNumberToGuess(level)
    var attemptsLeft = level.attempts
    var result: GuessResult

    do {
        println("Попыток осталось: $attemptsLeft")
        val guess = readIntForGuess(scanner, level)
        result = getResult(guess, secret)
        println(result.hint)
    } while (attemptsLeft-- > 1 && result != GuessResult.WIN)
    return result == GuessResult.WIN
}

