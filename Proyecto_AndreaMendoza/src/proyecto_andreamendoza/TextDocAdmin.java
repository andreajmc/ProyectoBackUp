package proyecto_andreamendoza;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLWriter;

public class TextDocAdmin {

    private File archive;
    private javax.swing.JTextPane txt;

    public TextDocAdmin(File archive, javax.swing.JTextPane txt) {
        this.archive = archive;
        this.txt = txt;
    }

    public File getArchive() {
        return archive;
    }

    public void setArchive(File archive) {
        this.archive = archive;
    }

    public void loadArchive() throws FileNotFoundException, IOException, BadLocationException {
           txt.setContentType("text/html");
        EditorKit kit = txt.getEditorKit();
        Document doc = kit.createDefaultDocument();
        kit.read(new FileInputStream(new File(archive.getPath())), doc, 0);
        txt.setDocument(doc);
    }

    public void writeArchive() throws IOException, BadLocationException {
        try {
     txt.setContentType("text/html");
     EditorKit kit = txt.getEditorKit();
            Document doc = txt.getStyledDocument();
            kit.write(new FileOutputStream(new File(archive.getPath())), doc, 0, doc.getLength());

        } catch (Exception e) {
        }
    }
}
