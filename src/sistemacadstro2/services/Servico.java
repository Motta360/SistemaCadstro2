/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacadstro2.services;

import sistemacadstro2.entities.Aluno;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class Servico {

    File path = new File("info.txt");

    public ArrayList read() {
        if (path.exists()) {
            try {
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);

                ArrayList<Aluno> lista = (ArrayList) ois.readObject();

                fis.close();
                ois.close();
                return lista;
            } catch (Exception e) {
                System.out.println(e.getMessage() + "deu ruim");
                return null;
            }
        } else {
            ArrayList<Aluno> vazia= new ArrayList<Aluno>();
            
            try {
                FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(vazia);
                fos.close();
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Servico.class.getName()).log(Level.SEVERE, null, ex);
            }
            return vazia;

        }

    }

    public void atualizarLista(ArrayList lista) {
        try {
            FileOutputStream fops = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fops);

            oos.writeObject(lista);

            fops.close();
            oos.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
