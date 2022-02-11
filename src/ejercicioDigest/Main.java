package ejercicioDigest;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

//introducir la cadena donde meter el hash. Usamos MD5 y al final imprimir el mensaje.

public class Main {

    public static void main(String[] args) {
        getHashDeFichero();

    }

    private static void getHashDeFichero() {
        //File fichero = new File("FileHash");
        //
        File fichero = new File("C:\\Users\\macal\\Downloads\\winmd5free\\WinMD5.exe");
        BufferedInputStream bis=null;
        try {
            bis = new BufferedInputStream(new FileInputStream(fichero));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[0];
        try {
            bytes = bis.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(bytes);//comienza a generar los bytes
        byte[] hash = md.digest();
        System.out.println(valorHexadecimal(hash));
    }

    private static void getHashDeCadena() {
        MessageDigest md;
        String cadena;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introducir cadena de caracteres para calcular su hash");
        cadena=scanner.nextLine();
        try {

            byte[] bytes = cadena.getBytes();

            md = MessageDigest.getInstance("SHA-256");
            md.update(bytes);//comienza a generar los bytes
            byte[] hash = md.digest();
            System.out.printf("Cadena: [%s]\nHash: [%s]\n.", bytes, valorHexadecimal(hash));

        } catch (NoSuchAlgorithmException e) {
            System.out.println("No disponible algoritmo de hash");
        }
    }

    private static String valorHexadecimal(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%x", b));
        }
        return result.toString();
    }

}
/*
 public static void main(String[] args) {
        File fichero = new File("ficheiro");
        BufferedInputStream bin = null;
        try {
            bin = new BufferedInputStream(new FileInputStream(fichero));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(bin.readAllBytes());
            byte[] hash = md.digest();
            toHexString(hash);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void toHexString(byte[] hash) {
        StringBuilder result= new StringBuilder();
        for (byte b : hash) {
            result.append(String.format("%x", b));
        }
        System.out.println(result);
    }
 */
