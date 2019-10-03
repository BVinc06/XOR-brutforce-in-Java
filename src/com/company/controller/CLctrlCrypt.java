package com.company.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.company.model.*;
public class CLctrlCrypt {

    static CLcad cad = new CLcad("jdbc:mysql://localhost:3306/tb_personne?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false& serverTimezone=UTC", "root", "");
    static String req_all="SELECT mot FROM dictionnaire";
    static ArrayList<String> res_mot = cad.m_getAllRows(req_all);;
    static int incr=0;
    static long startTime = System.nanoTime();



    public void ecrireFichierSimple(String path, String texte) {
        try {
            String str = texte;
            FileOutputStream outputStream = new FileOutputStream(new File(path));
            byte[] strToBytes = str.getBytes();
            outputStream.write(strToBytes);

            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String lireFichierSimple(String path) {
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            BufferedReader buf = new BufferedReader(new InputStreamReader(fis));
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }
            String fileAsString = sb.toString();
            return fileAsString;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String crypter(String msg, String key) {

        String encrypHexa = "";
        int keyItr = 0;
        for (int i = 0; i < msg.length(); i++) {
            // XOR Operation
            int temp = msg.charAt(i) ^ key.charAt(keyItr);

            encrypHexa += String.format("%02x", (byte) temp);
            keyItr++;
            if (keyItr >= key.length()) {
                // once all of key's letters are used, repeat the key
                keyItr = 0;
            }

        }

        return encrypHexa;

    }

    public String decrypter(String msg, String key) {

        String hexToDeci = "";
        for (int i = 0; i < msg.length() - 1; i += 2) {
            // splitting hex into a pair of two
            String output = msg.substring(i, (i + 2));
            int decimal = Integer.parseInt(output, 16);
            hexToDeci += (char) decimal;
        }

        // decryption
        String decrypText = "";
        int keyItr = 0;
        for (int i = 0; i < hexToDeci.length(); i++) {
            // XOR Operation
            int temp = hexToDeci.charAt(i) ^ key.charAt(keyItr);

            decrypText += (char) temp;
            keyItr++;
            if (keyItr >= key.length()) {
                // once all of key's letters are used, repeat the key
                keyItr = 0;
            }



        }
        return decrypText;
    }
    public void generate_alphabet(String key_entered,int lenght, String reponse,String dest){
        char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int n = alphabet.length;
        printAllKLengthRec(alphabet, "", n, lenght,key_entered, reponse, dest);
    }

    static void printAllKLengthRec(char[] set,
                                   String prefix,
                                   int n, int k,String key_entered, String reponse,String dest)
    {

        // Base case: k is 0,
        // print prefix
        if (k == 0)
        {
            String Key_gen=key_entered+prefix;
            //System.out.println(Key_gen);
            CLctrlCrypt o1 = new CLctrlCrypt();

            /*String  PATH = "C:\\Users\\josep\\Desktop\\Folder\\";
            o1.ecrireFichierSimple( PATH + "a.txt", "Bonjour a tous. Comment Allez vous?");


            reponse = o1.lireFichierSimple(PATH + "a.txt");
            System.out.println(reponse);

            reponse = o1.crypter(reponse, "abcdefghkdjd");
            o1.ecrireFichierSimple(PATH + "b.txt", reponse);
            */
            // Mettre la FCT ici pour les decodage
            reponse = o1.decrypter(reponse, Key_gen);
            //System.out.println(reponse);
            // METTRE ICI LA FCT POUR CHECK LE DICO
            String[] reponse_split = reponse.split("[\\s,.?!'\"]+");
            int size = reponse_split.length;
            int words_ok=0;
            int prog_continue=1;
            //System.out.println(size);
            for (int i = 0; i < reponse_split.length; i++) {
                if (prog_continue==1) {

                    System.out.println(reponse);
                    String reponse_slashed = reponse_split[i];
                    //String no_chat_response = reponse_slashed.replaceAll("[^A-Za-z0-9]", "");
/*
                    String request = "SELECT count(*) FROM dictionnaire WHERE mot='" + no_chat_response + "'";
                    //System.out.println(request);
                    //reponse_split[i]
                    ResultSet res_mot = cad.m_getRows(request);
*/
                    //int results = afficher(res_mot);
                    // METTRE LE IF POUR CHECK SI LE MOT EST OK
                    //System.out.println(prefix);
                    if (res_mot.contains(reponse_slashed.toLowerCase())) {
                        words_ok++;
                        incr++;

                    }
                    else{
                        prog_continue=0;
                        //System.out.println(reponse_split[i]);
                        incr++;
                        //System.out.println(incr);
                    }

                    //try {

                    // System.out.println(res_mot);
                    //} catch (SQLException e){

                    //}
                }
            }
            //m_actionRows
            if(words_ok==size){
                long findtime   = System.nanoTime();
                long totalTime = findtime - startTime;
                totalTime=totalTime/1000000000;
                totalTime=totalTime/60;
                System.out.println("DECRYPT OK: "+reponse);
                System.out.println("FOR KEY: "+Key_gen);
                System.out.println("EXEC TIME: Approx. "+totalTime+"Mins");
                o1.ecrireFichierSimple(dest, reponse+"\n"+"FOR KEY: "+Key_gen);
                System.exit(0);
            }

            return;
        }

        // One by one add all characters
        // from set and recursively
        // call for k equals to k-1
        for (int i = 0; i < n; ++i)
        {

            // Next character of input added
            String newPrefix = prefix + set[i];

            // k is decreased, because
            // we have added a new character
            printAllKLengthRec(set, newPrefix,
                    n, k - 1,key_entered, reponse, dest);
        }
    }
    public static String[] afficher(ResultSet dataRows) {
        /* Récupération des données du résultat de la requête de lecture */
        try {
            /* Récupération des données du résultat de la requête de lecture */
            String[] ret=new String[dataRows.getMetaData().getColumnCount()+1];
            while ( dataRows.next() ) {

                for (int i = 1; i <= dataRows.getMetaData().getColumnCount(); i++) {
                    //System.out.print(dataRows.getString(i) + " ; ");
                    //return Integer.parseInt(dataRows.getString(i));
                    ret[i]=dataRows.getString(i);
                }

                //System.out.println("");
            }
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static <T> List<T> convertArrayToList(T array[])
    {

        // Create the List by passing the Array
        // as parameter in the constructor
        List<T> list = Arrays.asList(array);

        // Return the converted List
        return list;
    }
}

