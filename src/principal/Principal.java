/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.*;

/**
 *
 * @author Sebastian
 */
public class Principal {

    static Gestor g;

    public static void main(String[] args) throws IOException {
        g = new Gestor();
        // creo un objeto file y el construtor recibe la ruta del archivo
        File archivo = new File("C:\\Users\\scalf\\OneDrive\\Escritorio\\Gestor de Archivo\\archivo.txt");
//        File cm = new File("C:\\Users\\scalf\\OneDrive\\Escritorio\\Gestor de Archivo\\cm.txt");
        try {
            // para saber si el archivo no existe
            if (archivo.createNewFile()) {
                System.out.println("se ha creado el archivo");
                System.out.println("Nombre del archivo " + archivo.getName());
                System.out.println("Camino             " + archivo.getPath());
                System.out.println("Camino absoluto    " + archivo.getAbsolutePath());
                System.out.println("Se puede escribir  " + archivo.canRead());
                System.out.println("Se puede leer      " + archivo.canWrite());
                System.out.println("Tamaño             " + archivo.length());
            }
        } catch (IOException e) {
            System.err.println("No se ha podido crear el archivo");
        }
        g.Writef(archivo, "hola, h, hi");
        g.assign(archivo);
        g.Readf(archivo);
        g.RepeatedData(args);
    }
}
