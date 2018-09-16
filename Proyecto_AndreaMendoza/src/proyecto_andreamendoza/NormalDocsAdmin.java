/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_andreamendoza;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.JTextArea;

/**
 *
 * @author andre
 */
public class NormalDocsAdmin implements Serializable {

    File archive;
    JTextArea messages;

    public NormalDocsAdmin(File archive, JTextArea messages) {
        this.archive = archive;
        this.messages = messages;
    }

    public File getArchive() {
        return archive;
    }

    public void setArchive(File archive) {
        this.archive = archive;
    }

    public void readMessages() throws IOException {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(archive);
            br = new BufferedReader(fr);
            String L = "";
            while ((L = br.readLine()) != null) {
                messages.append(L + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        br.close();
        fr.close();

    }

    public void writeMessages() {
        FileWriter fr = null;
        BufferedWriter bw = null;
        try {
            fr = new FileWriter(archive);
            bw = new BufferedWriter(fr);
            bw.write(messages.getText());
            bw.newLine();
            bw.flush();
        } catch (Exception e) {
        }
    }

}
