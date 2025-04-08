package ui

import model.Operador

class Consola(var operador: Operador? = Operador.SUMAR): IEntradaSalida {

    fun ejecutarPrograma(){
        var salida = false
        while (!salida){
            mostrarMensaje("Introduce el primer número")
            val num1 = pedirDouble()
            mostrarMensaje("Introduce el operador (+, -, *, /)")
            do {
                operador = Operador.SUMAR
                operador = operador?.getOperador(pedirString())
                if (operador == null) mostrarError("Operador no valido")
            } while (operador == null)
            mostrarMensaje("Introduce el segundo número")
            val num2 = pedirDouble()
            when (operador) {
                Operador.SUMAR -> mostrarMensaje("$num1 + $num2 = ${num1+num2}")
                Operador.RESTAR -> mostrarMensaje("$num1 - $num2 = ${num1-num2}")
                Operador.DIVIDIR -> mostrarMensaje("$num1/$num2 = ${num1/num2}")
                Operador.MULTIPLICAR -> mostrarMensaje("$num1 * $num2 = ${num1*num2}")
                null -> mostrarError("Operador no valido")
            }
            salida = preguntarSalida()
        }
    }

}