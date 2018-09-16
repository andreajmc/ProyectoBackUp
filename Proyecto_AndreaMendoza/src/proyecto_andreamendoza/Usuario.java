package proyecto_andreamendoza;

import java.awt.Color;
import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

public class Usuario implements Serializable {

    private String Nombre;
    private int Edad;
    private Date Bday;
    private String Username;
    private String PW;
    private String RespPW;
    private String Correo;
    private String Pregunta;
    private Color C;
    private String CMusica;
    private String CImagenes;
    private String CCorreo;
    private String CMensaje;
    private String CCalendario;
    private String CDocumentos;
    private boolean msn;

    public Usuario() {
    }

    public Usuario(String Nombre, int Edad, Date Bday, String Username, String PW, String RespPW, String Correo, String Pregunta, Color C) throws Exceptions {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Bday = Bday;
        this.Username = setUsername(Username);
        this.PW = setPW(PW);
        this.RespPW = RespPW;
        this.Correo = setCorreo(Correo);
        this.Pregunta = Pregunta;
        this.C = C;
        this.CMusica = "/Mi Música";
        this.CImagenes = "/Mis Imágenes";
        this.CCorreo = "/Mi Correo";
        this.CMensaje = "/Mis Mensajes";
        this.CCalendario = "/Mi Calendario";
        this.CDocumentos = "/Mis Documentos";
        msn = false;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public Date getBday() {
        return Bday;
    }

    public void setBday(Date Bday) {
        this.Bday = Bday;
    }

    public String getUsername() {
        return Username;
    }

    public String setUsername(String Username) throws Exceptions {
        for (String un : PP.UNs) {
            if (un.equalsIgnoreCase(Username)) {
                System.out.println("entra cons");
                System.out.println(un);
                throw new Exceptions("El nombre de usuario ingresado no está disponible.\nInténtelo de nuevo.");
            }
        }
        this.Username = Username;
        return Username;
    }

    public String getPW() {
        return PW;
    }

    public String setPW(String PW) throws Exceptions {
        boolean caps = false;
        boolean num = false;
        for (int i = 0; i < PW.length(); i++) {
            char t = PW.charAt(i);
            if (Character.isDigit(t)) {
                num = true;
            }
            if (Character.isUpperCase(t)) {
                caps = true;
            }
        }
        if (caps == true && num == true) {
            this.PW = PW;
            return PW;
        } else {
            throw new Exceptions("Contraseña Inválida.\nIngrese una nueva contraseña con al menos un número y una letra mayúscula.");
        }
    }

    public String getRespPW() {
        return RespPW;
    }

    public void setRespPW(String RespPW) {
        this.RespPW = RespPW;
    }

    public String getCorreo() {
        return Correo;
    }

    public String setCorreo(String correo) throws Exceptions {
        String Email_Ideal = "[^@]+@[^@]+\\.[a-z]{2,}";
        if (!Pattern.matches(Email_Ideal, correo)) {
            throw new Exceptions("El texto ingresado no es un correo.\nInténtelo de nuevo.");
        }
        this.Correo = correo;
        return correo;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public void setPregunta(String Pregunta) {
        this.Pregunta = Pregunta;
    }

    public Color getC() {
        return C;
    }

    public void setC(Color C) {
        this.C = C;
    }

    public String getCMusica() {
        return CMusica;
    }

    public void setCMusica(String CMusica) {
        this.CMusica = CMusica;
    }

    public String getCImagenes() {
        return CImagenes;
    }

    public void setCImagenes(String CImagenes) {
        this.CImagenes = CImagenes;
    }

    public String getCCorreo() {
        return CCorreo;
    }

    public void setCCorreo(String CCorreo) {
        this.CCorreo = CCorreo;
    }

    public String getCMensaje() {
        return CMensaje;
    }

    public void setCMensaje(String CMensaje) {
        this.CMensaje = CMensaje;
    }

    public String getCCalendario() {
        return CCalendario;
    }

    public void setCCalendario(String CCalendario) {
        this.CCalendario = CCalendario;
    }

    public String getCDocumentos() {
        return CDocumentos;
    }

    public void setCDocumentos(String CDocumentos) {
        this.CDocumentos = CDocumentos;
    }

    public boolean isMsn() {
        return msn;
    }

    public void setMsn(boolean msn) {
        this.msn = msn;
    }

    @Override
    public String toString() {
        return Nombre;
    }

}
