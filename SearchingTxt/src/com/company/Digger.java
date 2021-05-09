package com.company;

import java.io.File;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
//Ксласс для поиска всех файлов в папках
public class Digger {
    Set<File> files = new TreeSet<>();
    public void addToPath(File folder){
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if(file.isFile()){
                files.add(file);
            }
            else if(file.isDirectory()){
                addToPath(file);
            }
        }


    }

}