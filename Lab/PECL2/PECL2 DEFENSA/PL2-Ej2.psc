//inicio de recursividad: preparar los parámetros de llamada
Funcion LlamaFibonacci ( repeticiones )
	Escribir 0
	Escribir 1
	Fibonacci(0,1,repeticiones-2)
Fin Funcion

//recursiva tradicional
Funcion Fibonacci ( numero1, numero2, repeticion )
	Si repeticion>0 Entonces
		Escribir numero1+numero2
		Fibonacci(numero2, numero1+numero2, repeticion-1)
	Fin Si
Fin Funcion



Algoritmo MostrarFibonacci
	
	LlamaFibonacci(100)
	
FinAlgoritmo
