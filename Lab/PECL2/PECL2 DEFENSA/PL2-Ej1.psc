Algoritmo SubirEscaleraMientras2
	
	
	Definir contadorDePasos Como Entero
	contadorDePasos<-0
	
	Definir  HeLlegado Como Logico
	HeLlegado=Falso
	
	Mientras HeLlegado=Falso Hacer
		Escribir "subo", "no bajo", HeLlegado, contadorDePasos
		
		contadorDePasos<-contadorDePasos+1
		// Verificar la condición
		Si contadorDePasos>5 Entonces
			HeLlegado=Verdadero
		Fin Si
		
	Fin Mientras
	
FinAlgoritmo
