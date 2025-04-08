package model

enum class Operador {
    MULTIPLICAR, SUMAR, RESTAR, DIVIDIR;

    fun getOperador(operador: Char): Operador?{
        return when (operador) {
            '*' -> MULTIPLICAR
            '/' -> DIVIDIR
            '-' -> RESTAR
            '+' -> SUMAR
            else -> null
        }
    }
}