package proyecto_andreamendoza;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BinaryArchivesAdmin {

    private ArrayList<Usuario> Users = new ArrayList();
    private File archive;

    public BinaryArchivesAdmin(String path) {
        archive = new File(path);
    }

    public ArrayList<Usuario> getUsers() {
        return Users;
    }

    public void setUsers(ArrayList<Usuario> Users) {
        this.Users = Users;
    }

    public File getArchive() {
        return archive;
    }

    public void setArchive(File archive) {
        this.archive = archive;
    }

    public void setUsuario(Usuario u) {
        this.Users.add(u);
    }

    public void loadArchive() {
        try {
            Users = new ArrayList();
            Usuario temp;
            if (archive.exists()) {
                FileInputStream input
                        = new FileInputStream(archive);
                ObjectInputStream object
                        = new ObjectInputStream(input);
                try {
                    while ((temp = (Usuario) object.readObject()) != null) {
                        Users.add(temp);
                    }
                } catch (EOFException e) {
                }
                object.close();
                input.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void overrideArchive() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archive);
            bw = new ObjectOutputStream(fw);
            for (Usuario u : Users) {
                bw.writeObject(u);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }

}
