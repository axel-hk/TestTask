package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;


public class Main {

    public static void main(String[] args) {
        Digger digger = new Digger();
        try{
            FileWriter writer = new FileWriter("D://somefile.txt", false);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            File folder = new File(reader.readLine());
            reader.close();
            digger.addToPath(folder);

            for(File f: digger.files){

                BufferedReader fileReader = new BufferedReader(new FileReader(f));
                while (fileReader.ready()){
                    String s = fileReader.readLine();

                    writer.write(s);
                    writer.flush();
                }
                fileReader.close();
            }

            writer.close();
        } catch (IOException io) {
        }
    }


}

