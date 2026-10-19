import java.util.Scanner

// чтение числа из ввода
fun readInt(scanner: Scanner, prompt: String): Int {
    println(prompt)
    return scanner.nextInt()
}

// чтение числа при выборе уровня, продолжении или не продолжении игры
fun readIntByCase(scanner: Scanner,  case: InputCase): Int {
    while (true) {
        val input = readInt(scanner, case.prompt)
        if (input in case.range) {
            return input
        }
        println(case.error)
    }
}

// чтение числа при угадывании
fun readIntForGuess(scanner: Scanner, level: Level): Int {
    while (true) {
        val input = readInt(scanner, "Введите число в диапазоне ${level.range}")
        if (input in level.range){
            return input
        }
        println("Число вне диапазона!")
    }
}

