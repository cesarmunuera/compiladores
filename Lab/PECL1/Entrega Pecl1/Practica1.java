import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Practica1 {

    ArrayList<String> filas;    // [q0, q1, ...]
    ArrayList<String> columnas; // [a, b, ...]
    ArrayList<String> finales;  // [q0, q1, ...] Nodos finales
    ArrayList<ArrayList<Integer>> matriz;

    public static void main (String [] args){
        Practica1 p = new Practica1();
        p.crearMatriz();
        System.out.println(p.validarCadena("aabcccmbqccp"));
        System.out.println(p.validarCadena("abmbo"));
        p.crearCadena(15, 100);

        //Pruebas
        System.out.println(p.validarCadena("aaabpbpbqbqbmbo"));
    }


    public String validarCadena(String cadenaParaValidar){
        String textoSolucion = ("La cadena " + cadenaParaValidar + " , NO es valida para esta expresion regular." + '\n');

        String estadoActual = "q0";
        int indiceFila = traducirEstado(estadoActual);

        for (int i = 0; i < cadenaParaValidar.length(); i++) {
            String letra = cadenaParaValidar.substring(i, i+1);
            if (columnas.contains(letra)){
                int indiceColumna = traducirLetra(letra);
                int valor = this.matriz.get(indiceFila).get(indiceColumna);
                if (valor == 0) {
                    return textoSolucion;
                } else {
                    indiceFila = valor;
                    estadoActual = this.filas.get(indiceFila);
                }
            } else {
                return textoSolucion;
            }
        }
        if (this.finales.contains(estadoActual)){
            return ("La cadena " + cadenaParaValidar + " , SI es valida para esta expresion regular." + '\n');
        }
        return textoSolucion;
    }

    public void crearMatriz(){
        List listaNodosIniciales= new ArrayList<ArrayList<String>>(
                List.of(
                        new ArrayList<String>(List.of("q0", "a", "q1")),

                        new ArrayList<String>(List.of("q1", "b", "q3")),
                        new ArrayList<String>(List.of("q1", "a", "q2")),

                        new ArrayList<String>(List.of("q2", "a", "q2")),
                        new ArrayList<String>(List.of("q2", "b", "q3")),

                        new ArrayList<String>(List.of("q3", "m", "q6")),
                        new ArrayList<String>(List.of("q3", "c", "q7")),
                        new ArrayList<String>(List.of("q3", "p", "q4")),
                        new ArrayList<String>(List.of("q3", "n", "q5")),
                        new ArrayList<String>(List.of("q3", "o", "q9")),
                        new ArrayList<String>(List.of("q3", "q", "q8")),

                        new ArrayList<String>(List.of("q4", "b", "q10")),

                        new ArrayList<String>(List.of("q5", "b", "q10")),

                        new ArrayList<String>(List.of("q6", "b", "q10")),

                        new ArrayList<String>(List.of("q7", "c", "q7")),
                        new ArrayList<String>(List.of("q7", "m", "q6")),
                        new ArrayList<String>(List.of("q7", "p", "q4")),
                        new ArrayList<String>(List.of("q7", "n", "q5")),
                        new ArrayList<String>(List.of("q7", "o", "q9")),
                        new ArrayList<String>(List.of("q7", "q", "q8")),

                        new ArrayList<String>(List.of("q8", "b", "q10")),

                        new ArrayList<String>(List.of("q9", "b", "q10")),

                        new ArrayList<String>(List.of("q10", "n", "q12")),
                        new ArrayList<String>(List.of("q10", "c", "q14")),
                        new ArrayList<String>(List.of("q10", "m", "q13")),
                        new ArrayList<String>(List.of("q10", "q", "q15")),
                        new ArrayList<String>(List.of("q10", "p", "q11")),
                        new ArrayList<String>(List.of("q10", "o", "q16")),

                        new ArrayList<String>(List.of("q11", "b", "q10")),

                        new ArrayList<String>(List.of("q12", "b", "q10")),

                        new ArrayList<String>(List.of("q13", "b", "q10")),

                        new ArrayList<String>(List.of("q14", "c", "q14")),
                        new ArrayList<String>(List.of("q14", "q", "q15")),
                        new ArrayList<String>(List.of("q14", "o", "q16")),
                        new ArrayList<String>(List.of("q14", "p", "q11")),
                        new ArrayList<String>(List.of("q14", "m", "q13")),
                        new ArrayList<String>(List.of("q14", "n", "q12")),

                        new ArrayList<String>(List.of("q15", "b", "q10")),
                        
                        new ArrayList<String>(List.of("q16", "b", "q10"))
                )
        );
        listaNodosIniciales = (ArrayList<ArrayList<String>>) listaNodosIniciales;

        this.finales = new ArrayList<String>(List.of("q4", "q5", "q6", "q8", "q9","q11", "q12", "q13", "q15", "q16"));

        //Inicializamos las filas  y columnas
        this.filas = new ArrayList();
        this.columnas = new ArrayList();
        for (Object fila: listaNodosIniciales) {
            ArrayList<String> fila2 = (ArrayList<String>) fila;
            String nodoFila = fila2.get(0);
            String letraColumna = fila2.get(1);

            if (!filas.contains(nodoFila)){
                filas.add(nodoFila);
            }
            if (!columnas.contains(letraColumna)){
                columnas.add(letraColumna);
            }
        }

        //Ordenamos alfabeticamente el array de las columnas
        Collections.sort(columnas, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        //Creamos la matriz; Por cada fila de la matriz, creamos un array con tantas columnas a 0, y lo seteamos a la matriz.
        this.matriz = new ArrayList<ArrayList<Integer>>(this.filas.size());
        for (int i = 0; i < this.filas.size(); i++){
            ArrayList<Integer> fila = new ArrayList(this.columnas.size());
            for (int j = 0; j < this.columnas.size(); j++){
                fila.add(0);
            }
            this.matriz.add(fila);
        }

        //Rellenamos la matriz
        for (Object fila: listaNodosIniciales) {
            ArrayList<String> fila2 = (ArrayList<String>) fila;

            String nodoFila = fila2.get(0);
            String letraColumna = fila2.get(1);
            String nodoValor = fila2.get(2);

            int indiceFila = traducirEstado(nodoFila);
            int indiceColumna = traducirLetra(letraColumna);
            int valor = traducirEstado(nodoValor);

            this.matriz.get(indiceFila).set(indiceColumna, valor);
        }

    }

    public Integer traducirEstado(String estado){
        estado = estado.toLowerCase();
        return this.filas.indexOf(estado);
    }

    public Integer traducirLetra(String letra){
        letra = letra.toLowerCase();
        return this.columnas.indexOf(letra);
    }

    public void crearCadena(int tamanoCadena, int nCadenas){
        System.out.println(nCadenas + " Cadenas posibles que cumplen la ER: ");

        int contadorCadenas = 1;
        int indiceFila = 0;
        int posicionAux = 0;
        int posicion = 0;

        String cadena = "";
        ArrayList<String> cadenas = new ArrayList<String>(nCadenas);


        while(contadorCadenas <= nCadenas){
            cadena = "";
            indiceFila = 0;
            ArrayList<Integer> auxiliar = new ArrayList<Integer>(this.filas.size());

            //Bucle para crear cada cadena
            for (int k = 0; k < tamanoCadena; k++){
                //Almacenamos en un array auxiliar, las posiciones de la fina donde hay valores
                for (int i = 0; i<this.matriz.get(indiceFila).size(); i++) {
                    if (this.matriz.get(indiceFila).get(i) != 0) {
                        auxiliar.add(i);
                        posicion = i;
                    }
                }

                //Elegimos una posición al azar. Cada posición es una letra
                // Ejemplo: Si la posición al azar era la 1, es la B.
                //Con la posición, sacamos que letra es por el array ordenado de letras
                if (auxiliar.size() == 1){
                    cadena += this.columnas.get(posicion);
                }else{
                    double random = Math.random()*auxiliar.size();
                    posicionAux = (int) random;
                    cadena += this.columnas.get(auxiliar.get(posicionAux));
                    posicion = auxiliar.get(posicionAux);
                }
                //Actualizamos la fila a donde debemos ir, y el array auxiliar lo limpiamos
                //Teniendo la letra y la fila, obtenemos el nuevo valor (nueva fila)
                auxiliar.clear();
                indiceFila = (this.matriz.get(indiceFila)).get(posicion);
            }

            //Comprobamos si ya existe, y si es final.
            if ((this.finales.contains(this.filas.get(indiceFila))) && (!cadenas.contains(cadena))){
                cadenas.add(cadena);
                System.out.println((contadorCadenas) + " - " + cadena);
                contadorCadenas +=1;
            }

        }
    }


}
