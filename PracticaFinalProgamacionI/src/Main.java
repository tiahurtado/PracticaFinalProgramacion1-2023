import java.awt.*;

class Main{
    //DECLARACIONES
    //Una constante String para resumir las lineas separadoras en el menú
    private static final String SEPARADOR = "*************************************************";
    private static final String SALTO_DE_LINEA = "\n";
    private static final String NOMBRE_FICHERO_AGENDA = "ficheros/agenda.txt";
    //Variable char que representa la opción escogida por el usuario
    private static Character opcion;
    public static void main(String [] args)throws Exception{
        new Main().menuPrincipal();
    }

    //METODOS
    //Metodo menú principal
    public static void menuPrincipal()throws Exception{
        System.out.print(SALTO_DE_LINEA);
        //Visual del menú principal
        System.out.println(SEPARADOR);
        System.out.println("MENÚ PRINCIPAL");
        System.out.println(SEPARADOR);
        System.out.println("1 Generar cartas");
        System.out.println("2 Administrar agenda");
        System.out.println("3 Administrar listas de distribución");
        System.out.println("s Salir");
        System.out.println(SEPARADOR);

        //Lectura de la opción deseada
        opcion = LT.readChar();

        //Bucle para el control de errores y evitar opciones no deseadas
        while (!esOpcionMenu()){
            opcion = LT.readChar();
            if(!esOpcionMenu()){
                System.out.println("Error: Opción NO válida.");
            }
        }

        //Switch que determina la opcion que desea el usuario
        switch (opcion){
            case '1':
                //Lleva al método generarCarta();
                menuGenerarCartas();
                break;
            case '2':
                //Lleva al método administrarAgenda();
                menuAdministrarAgenda();
                break;
            case '3':
                //Lleva al método administrarListas();
                System.out.println("AdLista");
                break;
            case 's':
                System.out.println(SALTO_DE_LINEA);
                //Termina el programa
                System.out.println("FIN DEL PROGRAMA");
                break;
            default:
                //Opción por defecto, no hace nada
        }
    }

    public static void menuGenerarCartas() throws Exception{
        //Visual del menú generar cartas
        System.out.print(SALTO_DE_LINEA);
        System.out.println(SEPARADOR);
        System.out.println("GENERAR CARTAS");
        System.out.println(SEPARADOR);
        System.out.println("ELIGE EL NOMBRE DE LA CARTA: ");
        System.out.println("ELIGE EL NOMBRE DE LA PLANTILLA: ");
        System.out.println("ELIGE EL NOMBRE DE LA LISTA O ESCRIBE " + '"' + "agenda" + '"' + " SI QUIERES USAR TODA LA AGENDA: ");
        System.out.println(SEPARADOR);
        menuPrincipal();
    }

    public static void menuAdministrarAgenda() throws Exception {
        System.out.print(SALTO_DE_LINEA);
        opcion = null;
        //Visual del menú principal
        System.out.println(SEPARADOR);
        System.out.println("ADMINISTRAR AGENDA");
        System.out.println(SEPARADOR);
        System.out.println("1 Añadir contacto");
        System.out.println("2 Consultar datos del contacto");
        System.out.println("3 Eliminar contacto");
        System.out.println("s Salir");
        System.out.println(SEPARADOR);

        //Lectura de la opción deseada
        opcion = LT.readChar();

        //Bucle para el control de errores y evitar opciones no deseadas
        while (!esOpcionMenu()){
            opcion = LT.readChar();
            if(!esOpcionMenu()){
                System.out.println("Error: Opción NO válida.");
            }
        }

        //Switch que determina la opcion que desea el usuario
        switch (opcion){
            case '1':
                anadirContacto();
                menuPrincipal();
                break;
            case '2':
                //CONSULTAR DATOS CONTACTO
                break;
            case '3':
                //ELIMINAR CONTACTO
                System.out.println("eliminar contacto");
                break;
            case 's':
                //SALIR
                menuPrincipal();
                break;
            default:
                //Opción por defecto, no hace nada
        }
    }

    private static boolean esOpcionMenu(){
        if((opcion != '1')&&(opcion != '2')&&(opcion != '3')&&(opcion != 's')){
            return false;
        }
        return true;
    }

    private static void anadirContacto() throws Exception{
        System.out.println("Introduce el campo #NOMBRE#");
        String nombre = LT.readLine();
        System.out.println("Introduce el campo #APELLIDOS#");
        String apellidos = LT.readLine();
        System.out.println("Introduce el campo #E-MAIL#");
        String email = LT.readLine();
        System.out.println("Introduce el campo #TELEFONO#");
        int tlf = LT.readInt();

        Contacto contacto = new Contacto(nombre,apellidos,tlf,email);
        Palabra lineaContacto = new Palabra(contacto.toString());

        PalabraFicherosEscritura fichero = new PalabraFicherosEscritura(NOMBRE_FICHERO_AGENDA);
        fichero.escritura(lineaContacto);
    }
}