public class Contacto {
    private static final char SEPARADOR = '#';
    private Palabra nombre;
    private Palabra apellidos;
    private int telefono;
    private Palabra email;
    public Contacto(String nom, String ap, int tlf, String mail){
        nombre = new Palabra(nom);
        apellidos = new Palabra(ap);
        telefono = tlf;
        email = new Palabra(mail);
    }

    public String toString(){
        return nombre.toString() + SEPARADOR + apellidos.toString() + SEPARADOR + email.toString() + SEPARADOR + telefono + SEPARADOR;
    }
    public Palabra getNombre(){
        return nombre;
    }
    private String getApellidos(){
        return apellidos.toString();
    }
    public int getTelefono(){
        return telefono;
    }
    private String getEmail(){
        return email.toString();
    }

}
