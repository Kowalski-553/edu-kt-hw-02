enum class InputCase(val range: IntRange, val prompt: String, val error: String) {
    LEVEL(1..3, "Выберите уровень:", "Нет такого уровня"),
    REPLAY(0..1, "Повторить? 1 - да, 0 - нет:", "Введите 1 или 0")
}

enum class Level(val levelNumber: Int, val range: IntRange) {
    FIRST(1, 0..10),
    SECOND(2, -10..10),
    THIRD(3, 0..100)
}