/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coder.tutorials.getabsolutepath;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author dell-pc
 */
public class GetAbsolutePath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getAbsolutePath("C:\\Apps");
    }
    
    private static void getAbsolutePath(String path) {
        
        //Check the given path is real path or empty
        if(path.trim().length() <= 0 || path.isEmpty()) {
            System.err.println("Given path cannot be empty!");
            System.exit(1);
        }
        
        final File theDir = new File(path);
        final File[] fileList = theDir.listFiles();
        
        //Here we gonna check in the given pth is file or directory?
        for(File theFile : fileList) {

                if(theFile.isDirectory()) {
                    System.out.println("DIRECTORY : " + theFile.getAbsolutePath());
                    //we have to check again maybe there is some file into this directory.
                    getAbsolutePath(theFile.getPath());
                }
                else {
                    System.out.println("FILE : " + theFile.getAbsolutePath());
                }
        }

    }
}
