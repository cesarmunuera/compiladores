Funcion dato <- Llamada ( arg1,arg2,arg3 )
	dato<-arg1	
Fin Funcion

Algoritmo test3
	
	definir Personas Como Caracter
	dimension personas[1,7]   //Comrobar extensión: arrays
	Definir contador1 Como Entero 
	Definir swap Como Caracter
	Definir contador2 Como Entero
	Dimension swap[1,4]
	Para contador1<-2 hasta nropersonas con paso 1 Hacer
		swap[1,1]<-Personas[contador1-1,1]
		swap[1,2]<-Personas[contador1-1,2]
		swap[1,3]<-Personas[contador1-1,3]
		swap[1,4]<-Personas[contador1-1,4]
		
		contador2<-contador1-1   //comprobar condiciones compuestas:
		Mientras (Personas[contador2,4]<swap[1,4]) & contador2>=1 Hacer
			Escribir contador1, contador2
			Personas[contador2+1,1]<-Personas[contador2,1]
			Personas[contador2+1,2]<-Personas[contador2,2]
			Personas[contador2+1,3]<-Personas[contador2,3]
			Personas[contador2+1,4]<-Personas[contador2,4]
			contador2<-contador2-1			
		FinMientras
		Si Personas[contador2,4]<swap[1,4] 
			Personas[contador2+1,1]<-swap[1,1]
			Personas[contador2+1,2]<-swap[1,2]
			Personas[contador2+1,3]<-swap[1,3]
			Personas[contador2+1,4]<-swap[1,4]
		SiNo
			Personas[contador2+1,1]<-Personas[contador2,1]
			Personas[contador2+1,2]<-Personas[contador2,2]
			Personas[contador2+1,3]<-Personas[contador2,3]
			Personas[contador2+1,4]<-Personas[contador2,4]
			
			Personas[contador2,1]<-swap[1,1]
			Personas[contador2,2]<-swap[1,2]
			Personas[contador2,3]<-swap[1,3]
			Personas[contador2,4]<-swap[1,4]
		FinSi
		
	FinPara
	
	// Comprobar flexibilidad
	DefiniR dimension2, dimension4,xxx Como Entero
	dimension2<-1
	dimension4<-4
	DeFiNIr matrizX Como Caracter
	DiMeNsIOn matrizX[1,3,4,dimension4]
	matrizX[1,dimension2,3,dimension4]<-"hola"
	
	xxx<-Llamada(Llamada(Llamada(1,2,3),2,3),2,dimension4+4)
	matrizX[2,dimension2,Llamada(dimension2+dimension4,3,1),dimension4] <- "adios"

	Escribir "hola mundo", xxx, dimension4, dimension2, matrizX[1,1,1,dimension4-1]
	
FinAlgoritmo
