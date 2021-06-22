Funcion variable_de_retorno <- Nombre ( Argumentos )
	
Fin Funcion

Algoritmo ej
	Definir contador Como Entero
	Definir cad Como Caracter
	cad <- 'a'
	contador <- 2
	Escribir Longitud(cad), 8 azar(3)
	contador <- Longitud(cad) + azar(3) + 3+ contador
	
	Para contador<-(Longitud(cad) + azar(3) + 3+ contador) Hasta 10   Hacer
		Escribir 'Nos damos vuelta, y estamos en la vuelta ',contador
	FinPara
	
	
FinAlgoritmo



Funcion rdo <- TestDeFuncion ()
	rdo <- 'Esta es la función TestDeFuncion' + '2'
FinFuncion

	
