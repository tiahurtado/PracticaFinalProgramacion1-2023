/*
CLASE Palabra
PREPARADA PARA EL JUEGO DE CARACTERES SIGUIENTE:
    - CARACTERES ALFABÉTICOS MINÚSCULAS.
    - CARACTERES ALFABÉTICOS MAYÚSCULAS.
    - CARACTER ESPACIO.
    - CARACTER '.' Y CARACTER SALTO DE LINEA CÓMO CARACTERES DE FIN DE SECUENCIA.
*/
public class Palabra {
    //DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE que posibilitan la
    //descripción del estado de un objeto palabra
    //declaración atributo de clase para representar el máximo número de 
    //caracteres que puede tener un objeto palabra
    private static final int MAXIMO_NUMERO_CARACTERES = 20;
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control SALTO DE LINEA
    private static final char SALTO_LINEA = '\n';
    //declaración atributo de clase para representar el caracter de final
    //de secuencia de caracteres
    private static final char FIN_SECUENCIA = '.';
    //declaración atributo de clase para representar el caracter espacio
    private static final char ESPACIO = ' ';
    //declaración atributo de objeto para almacenar los caracteres de un 
    //objeto Palabra
    private char[] caracteres = new char[MAXIMO_NUMERO_CARACTERES];
    //declaración atributo de objeto para representar el número de caracteres
    //de un objeto palabra
    private int numeroCaracteres;
    //declaración atributo de clase para almacenar el último caracter
    //leído de la secuencia
    private static char caracter = ESPACIO;

    //MÉTODOS
    //MÉTODOS CONSTRUCTORES
    //método constructor sin parámetros que posibilita la instanciación de
    //un objeto Palabra vacio
    public Palabra() {
        numeroCaracteres = 0;
    }

    public Palabra(String dato) {

        caracteres = dato.toCharArray();
        numeroCaracteres = longitud(caracteres);
    }

    //MÉTODOS FUNCIONALES que posibilitan la descripción del comportamiento
    //de un objeto Palabra
    //método de clase función booleano hayPalabras que responde a la pregunta
    //de si quedan palabras en la secuencia de caracteres de entrada
    public static boolean hayPalabras() throws Exception {  
        buscarPalabra();
        if ((caracter != FIN_SECUENCIA) && (caracter != SALTO_LINEA)) {
            return true;
        } else {
            //vaciar buffer de entrada
            if (caracter == FIN_SECUENCIA) {
                //vaciar el buffer de entrada
                LT.skipLine();
            }
            //inicializar el atributo caracter a espacio para poder estar preparados
            //para la lectura de la palabras desde una nueva secuencia de caracteres
            //introducida por teclado
            caracter = ESPACIO;
            //devolver false como resultado de este método
            return false;
        }
    }

    private int longitud(char [] array){
        int longitud=0;

        for (char c : array) {
            longitud++;
        }
        return longitud;
    }

    //método de clase procedimiento buscarPalabra que posibilita buscar un
    //objeto palabra en la secuencia de caracteres de entrada
    private static void buscarPalabra() throws Exception {
        //mientras el caracter leído sea un caracter separador (espacio) de palabras en una linea
        //se seguirá leyendo
        while (caracter == ESPACIO) {
            caracter = LT.readChar();
        }
    }

    private boolean esAlfabeto(char caracter){
        if ((int)caracter>=97 && (int)caracter<=122){
            return true;
        }
        return false;
    }

    //método de objeto procedimiento readPalabra que posibilita la lectura
    //y almacenamiento de un objeto Palabra, caracter a caracter, desde
    //la secuencia de caracteres de entrada
    public void readPalabra() throws Exception {
        //inicializar el atributo numeroCaracteres a 0
        numeroCaracteres = 0;
        //bucle de lectura y almacenamiento de un objeto Palabra
        //a nivel de caracteres
        while ((caracter != FIN_SECUENCIA) && (caracter != ESPACIO) && (caracter != SALTO_LINEA)) {
            //almacenamiento del caracter de la palabra leído en la
            //componente numeroCaracteres del atributo array caracteres
            caracteres[numeroCaracteres] = caracter;
            //actualizamos numeroCaracteres incrementándolo en una unidad
            //pues acabamos de almacenar un caracter del objeto Palabra
            //en el array caracteres
            numeroCaracteres++;
            //lectura siguiente caracter de la secuencia de entrada
            caracter = LT.readChar();
        }
    }

    //método toString que posibilita la conversión a String de un objeto Palabra
    public String toString() {
        //DECLARACIONES
        //declaración variable String para almacenar el resultado de la conversión
        String conversion = "";

        //ACCIONES
        //bucle de conversión caracter a caracter
        for (int indice = 0; indice < numeroCaracteres; indice++) {
            //concatenación al String conversion del caracter indice-ésimo
            //del objeto Palabra
            conversion = conversion + caracteres[indice];
        }

        //devolución conversión
        return conversion;
    }

    //método numeroVocales obtiene el número de caracteres vocales de un objeto
    //Palabra
    public int numeroVocales() {
        //DECLARACIONES
        //declaración variable entera para almacenar el número de caracteres
        //vocales
        int contador = 0;
        //ACCIONES
        //bucle contabilización caracteres vocales
        for (int indice = 0; indice < numeroCaracteres; indice++) {
            //verificación si el caracter indice-ésimo de la palabra
            //es un caracter vocal
            if (esVocal(caracteres[indice])) {
                //incremento del contador
                contador++;
            }
        }

        //devolución contador
        return contador;
    }

    //método numeroCosonantes obtiene el número de caracteres consonantes de
    //un objeto Palabra
    public int numeroConsonantes() {
        return (numeroCaracteres - numeroVocales());
    }

    public int numeroEspacio() {
        //DECLARACIONES
        //declaración variable entera para almacenar el número de caracteres
        //vocales
        int contador = 0;
        //ACCIONES
        //bucle contabilización caracteres vocales
        for (int indice = 0; indice < numeroCaracteres; indice++) {
            //verificación si el caracter indice-ésimo de la palabra
            //es un caracter vocal
            if ((caracteres[indice]) == ESPACIO) {
                //incremento del contador
                contador++;
            }
        }

        //devolución contador
        return contador;
    }

    //método booleano esVocal verifica si el caracter dado por parámetro
    //es vocal
    private boolean esVocal(char caracter) {
        return ((caracter == 'a') || (caracter == 'e') || (caracter == 'i') ||
                (caracter == 'o') || (caracter == 'u'));
    }
    public char [] obtenerMayus(){
        for (int i = 0; i < numeroCaracteres; i++) {
            if (esMinuscula(caracteres[i])){
                caracteres[i] = (char) ((int) caracteres[i] + 32);

            }
        }
        return caracteres;
    }
    private boolean esMinuscula(char caracter) {
        return (caracter>='a'&&caracter<='z');
    }

    //método numeroCaracteres que posibilita la obtención del
    //número de caracteres de un objeto Palabra
    public int numeroCaracteres() {
        return numeroCaracteres;
    }

    //método todosVocales que verifica si un objeto Palabra tiene
    //todos sus caracteres vocales
    public boolean todosVocales() {
        //bucle de verificación si todos los caractes de un objeto
        //Palabra son vocales
        for (int indice = 0; indice < numeroCaracteres; indice++) {
            //verificar si el caracter indice-ésimo NO es vocal
            if (!esVocal(caracteres[indice])) {
                //devolución valor false pues el objeto palabra no
                //tiene todos los caracteres vocales
                return false;
            }
        }
        //devolución del valor true pues todos los caracteres del objeto
        //Palabra son vocales
        return true;
    }

    //metodo masConsonantes verifica si un objeto Palabra tiene más consonantes
    //que vocales
    public boolean masConsonantes() {
        return (numeroVocales() < numeroConsonantes());
    }

    //método copiar que posibilita el copiar el objeto Palabra en el objeto Palabra
    //dado por parámetro
    public void copiar(Palabra pal) {
        //copiar el atributo numeroCaracteres
        pal.numeroCaracteres = numeroCaracteres;
        //copiar de los caracteres
        pal.caracteres = caracteres;
    }

    //método numeroParCaracteres verifica si un objeto Palabra tiene un número
    //par de caracteres
    public boolean numeroParCaracteres() {
        return (numeroCaracteres % 2 == 0);
    }

    //método pesoCodigo cálcula el peso de código de objeto Palabra teniendo 
    //en cuenta que el peso de código viene definido por la suma de los
    //códigos de caracteres de los caracteres de un objeto Palabra
    public int pesoCodigo() {
        //DECLARACIONES
        //declaración variable entera para almacenar la suma de los códigos
        //de caracteres
        int suma = 0;

        //ACCIONES
        //bucle de suma de códigos de caracteres
        for (int indice = 0; indice < numeroCaracteres; indice++) {
            //acumular código del caracter indice-ésimo de la palabra en
            //la variable suma
            suma = suma + (int) caracteres[indice];
        }

        //devolución resultado
        return suma;
    }

    //MÉTODO adicionCaracter LLEVA A CABO LA ADICIÓN DE UN CARACTER DADO POR PARÁMETRO
    //EN UN OBJETO Palabra
    public void adicionCaracter(char caracter) {
        //almacenar el caracter dado en la primera componente libre del atributo
        //caracteres del objeto Palabra. El índice de dicha componente coincide
        //con el valor del atributo numeroCaracteres del mismo objeto Palabra
        caracteres[numeroCaracteres] = caracter;
        //incrementar el atributo numeroCaracteres del objeto Palabra para que
        //tenga en cuenta el caracter que acabamos de añadir en la palabra
        numeroCaracteres++;
    }

    //MÉTODO obtenerCaracter LLEVA A CABO LA OBTENCIÓN DEL CARACTER DE UNA
    //PALABRA QUE ESTÁ ALMACENADO EN LA POSICIÓN DADA DENTRO DEL ATRIBUTO
    //caracteres DE DICHO OBJETO Palabra
    public char obtenerCaracter(int posicion) {
        //devolver el caracter del objeto Palabra que está en la posición
        //dada dentro del atributo array caracteres
        return (caracteres[posicion]);
    }

    //Metodo que devuelve el primer caracter vocal de una palabra si no tiene devuelve null
    public Character obtenerPrimeraVocal() {
        for (int i = 0; i < numeroCaracteres; i++) {
            //verificar si el caracter es vocal
            if (esVocal(caracteres[i])) {
                return caracteres[i];
            }
        }
        return null;
    }

    public int numeroParejas(){
        int contador = 0;
        for (int i = 0; i < numeroCaracteres; i++) {
            //verificar si el caracter  es l
            if (caracteres[i] == 'l') {
                i++;
                if(caracteres[i] == 'a'){
                    contador++;
                }
            }
        }
        return contador;
    }

}
