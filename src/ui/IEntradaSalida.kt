package ui

import java.util.Scanner

interface IEntradaSalida {
    fun mostrarMensaje(msj: String){
        println(msj)
    }
    fun mostrarMensajeSinSalto(msj: String){
        print(msj)
    }
    fun mostrarError(msj: String){
        println("**ERROR** $msj")
    }
    fun pedirDouble(): Double{
        val scanner = Scanner(System.`in`)
        var valorValido = false
        var input = 0.0
        while (!valorValido){
            mostrarMensajeSinSalto(">> ")
            try {
                input = scanner.nextDouble()
                valorValido = true
            } catch (e: Exception) {
                mostrarError("Valor no valido")
            }
        }
        return input
    }
    fun pedirString(): Char {
        val scanner = Scanner(System.`in`)
        mostrarMensajeSinSalto(">> ")
        return scanner.next()[0]
    }
    fun preguntarSalida(): Boolean{
        val scanner = Scanner(System.`in`)
        mostrarMensaje("Desea salir (s/n)")
        var decision: Char = 'n'
        var valorValido =  false
        while (!valorValido){
            mostrarMensajeSinSalto(">> ")
            decision = scanner.next()[0].lowercaseChar()
            if (decision.toString() == "s" || decision.toString() == "n") {
                valorValido = true
            } else {
                mostrarError("Valor no valido introduzca s o n")
            }
        }
        return if (decision == 's') true else false
    }
}