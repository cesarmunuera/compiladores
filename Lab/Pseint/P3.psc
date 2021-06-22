Algoritmo P1SumaDeDosNumeros
	
	Definir nombre Como Caracter
	Escribir "Dime tu nombre:"
	Leer nombre
	
	Escribir "Hola " + nombre
	
	Definir numero1 Como Entero
	Definir numero2 Como Entero
	Definir resultado Como Entero
	
	//Cómo puedo pedirle al usuario los números?
	//numero1 <-3
	//numero2 <-4
	
	Escribir "Dame el primer número a sumar"
	Leer numero1
	Escribir "Dame el segundo número a sumar"
	Leer numero2
	resultado <- numero1 + numero2
	
	Escribir "El resultado de la suma es: "
	Escribir resultado
	
	// FASE 2 --------------------------------------
	// Flujo de ejecución
	Si resultado>50 Entonces
		Escribir "El resultado es mayor que cincuenta"
	SiNo
		Si resultado<50 Entonces
			Escribir "El resultado es menor que cincuenta"
		SiNo
			Escribir "El resultado es exactamente cincuenta"
		FinSi
	Fin Si
	
	Segun nombre Hacer
		"Antonio":
			Escribir "Bienvenido a tu casa"
		"Juan":
			Escribir "Juan, te esperan en la oficina"
			Escribir "buen viaje"
		"María":
			Escribir "Ha ganado 1 millon de"
		De Otro Modo:
			Escribir "No le conozco, llamando a la policía"
	FinSegun
	
	
	
FinAlgoritmo