// Без словарей всё было бы как-то противоестественно.

enum class InputCase(val range: IntRange, val prompt: String, val error: String) {
    LEVEL(1..3, "Выберите уровень:", "Нет такого уровня"),
    REPLAY(0..1, "Повторить? 1 - да, 0 - нет:", "Введите 1 или 0")
}

// Не совсем удобно, что при добавлении уровня мы должны менять и здесь, и выше, в двух местах,
// но я заметил это в конце и просто решил учесть это в будущем :)
enum class Level(val levelNumber: Int, val attempts: Int, val range: IntRange) {
    FIRST(1, 3,0..10),
    SECOND(2, 5,-10..10),
    THIRD(3, 10, 0..100)
}

enum class GuessResult(val hint: String) {
    WIN("Вы выиграли!"),
    LOWER("Загаданное число меньше"),
    HIGHER("Загаданное число больше")
}