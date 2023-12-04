public class Contacto {
    private String nombre;
    private String apellidos;
    private int telefono;
    private String email;
    public Contacto(){
        nombre="";
        apellidos = "";
        telefono = -1;
        email = "";
    }

    public Contacto(String nom, String ap, int tlf, String mail){
        nombre=nom;
        apellidos = ap;
        telefono = tlf;
        email = mail;
    }

    public String toString(){
        return nombre+'#'+apellidos+'#'+email+'#'+telefono+'#';
    }
    private void setNombre(String dato){
        nombre = dato;
    }
    private void setApellidos(String dato){
        apellidos = dato;
    }
    private void setTelefono(int dato){
        telefono = dato;
    }
    private void setEmail(String dato){
        email = dato;
    }
    public String getNombre(){
        return nombre;
    }
    private String getApellidos(){
        return apellidos;
    }
    public int getTelefono(){
        return telefono;
    }
    private String getEmail(){
        return email;
    }


}
