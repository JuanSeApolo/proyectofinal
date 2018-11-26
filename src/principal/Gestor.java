/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Sebastian
 */
public class Gestor {

    public void Writef(File archivo, String SCadena) {
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), "utf-8"));
            Fescribe.write(SCadena + "\r\n");
            Fescribe.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Readf(File archivo) {
        try {
            if (archivo.exists()) {
                BufferedReader buffer = new BufferedReader(new FileReader(archivo));
                String Slinea;
                System.out.println("**********Leyendo Fichero***********");
                while ((Slinea = buffer.readLine()) != null) {
                    System.out.println(Slinea);
                }
                System.out.println("*********Fin Leer Fichero**********");
                buffer.close();
            } else {
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void assign(File archivo) {
        Random rnd = new Random();
        try {
            FileWriter output = new FileWriter("C:\\Users\\scalf\\OneDrive\\Escritorio\\Gestor de Archivo\\archivo.txt");
            for (int i = 0; i < 700; i++) {
                output.write((char) (rnd.nextInt(65) + 62) + ",");
            }
            output.close();
        } catch (IOException e) {
            System.err.println("An error has ocurred");

        }

    }

    public void Modifyf(File archivo, String Satigualinea, String Snuevalinea) {
        Random numaleatorio = new Random(3816L);
        String SnombFichNuev = archivo.getParent() + "/auxiliar" + String.valueOf(Math.abs(numaleatorio.nextInt())) + ".txt";
        File FficheroNuevo = new File(SnombFichNuev);
        try {
            if (archivo.exists()) {
                BufferedReader Flee = new BufferedReader(new FileReader(archivo));
                String Slinea;
                while ((Slinea = Flee.readLine()) != null) {
                    if (Slinea.toUpperCase().trim().equals(Satigualinea.toUpperCase().trim())) {
                        Writef(FficheroNuevo, Snuevalinea);
                    } else {
                        Writef(FficheroNuevo, Slinea);
                    }
                }
                String SnomAntiguo = archivo.getName();
                FficheroNuevo.renameTo(archivo);
                Flee.close();
            } else {
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void RepeatedData(String[] args) throws IOException {
        String fileName = "C:\\Users\\scalf\\OneDrive\\Escritorio\\Gestor de Archivo\\archivo.txt";
        Set<String> list = new HashSet<String>();
        Path path = Paths.get(fileName);

        try (Stream<String> lines = Files.lines(path)) {
            list = lines.collect(Collectors.toSet());
        } catch (IOException ex) {
            //capturar la excepción
        }
        //imprimir en consola
        list.forEach(e -> System.out.println(e));
        //Reemplazar archivo
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            out.write(it.next());
            out.newLine();
        }
        out.close();
    }
}
