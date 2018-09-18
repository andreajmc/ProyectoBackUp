package proyecto_andreamendoza;

import java.util.ArrayList;
import java.util.Date;

public class Posts {

    private String author;
    private String titulo;
    private String desc;
    private ArrayList <String> paths;
    private String PathFoto1;
    private String PathFoto2;
    private String PathFoto3;
    private String PathFoto4;
    private int likes;
    private String tipo;
    private Date create;

    public Posts(String author, String titulo, int likes, Date create) {
        this.author = author;
        this.titulo = titulo;
        this.likes = likes;
        tipo = "txt";
        this.create = create;
    }

    public Posts(String author, String desc, String PathFoto1, int likes, Date create) {
        this.author = author;
        this.desc = desc;
        this.PathFoto1 = PathFoto1;
        this.likes = likes;
        tipo = "img";
        this.create = create;
    }

    public Posts(String author, String titulo, String desc, ArrayList <String> paths, int likes, Date create) {
        this.author = author;
        this.titulo = titulo;
        this.desc = desc;
        this.paths = paths;
        if (paths.size() == 1) {
            PathFoto1 = paths.get(0);
        } else if (paths.size() == 2) {
            PathFoto1 = paths.get(0);
            PathFoto2 = paths.get(1);
        } else if (paths.size() == 3) {
            PathFoto1 = paths.get(0);
            PathFoto2 = paths.get(1);
            PathFoto3 = paths.get(2);
        } else if (paths.size() == 4) {
            PathFoto1 = paths.get(0);
            PathFoto2 = paths.get(1);
            PathFoto3 = paths.get(2);
            PathFoto4 = paths.get(3);
        }
        this.likes = likes;
        tipo = "albm";
        this.create = create;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPathFoto1() {
        return PathFoto1;
    }

    public void setPathFoto1(String PathFoto1) {
        this.PathFoto1 = PathFoto1;
    }

    public String getPathFoto2() {
        return PathFoto2;
    }

    public void setPathFoto2(String PathFoto2) {
        this.PathFoto2 = PathFoto2;
    }

    public String getPathFoto3() {
        return PathFoto3;
    }

    public void setPathFoto3(String PathFoto3) {
        this.PathFoto3 = PathFoto3;
    }

    public String getPathFoto4() {
        return PathFoto4;
    }

    public void setPathFoto4(String PathFoto14) {
        this.PathFoto4 = PathFoto14;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getCreate() {
        return create;
    }
    
    
    
    

    @Override
    public String toString() {
        return titulo + " -- Publicación de " + author + ".";
    }

}
