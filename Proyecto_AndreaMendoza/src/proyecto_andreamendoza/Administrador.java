package proyecto_andreamendoza;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

public class Administrador extends Usuario {
    private ArrayList <Usuario> Usuarios;
    private boolean msn;

    public Administrador() {
    }

    public Administrador(ArrayList<Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }

    public Administrador(ArrayList<Usuario> Usuarios, String Nombre, int Edad, Date Bday, String Username, String PW, String RespPW, String Correo, String Pregunta, Color C) throws Exceptions {
        super(Nombre, Edad, Bday, Username, PW, RespPW, Correo, Pregunta, C);
        this.Usuarios = Usuarios;
        msn = false;
    }

    public ArrayList<Usuario> getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }
    
}
