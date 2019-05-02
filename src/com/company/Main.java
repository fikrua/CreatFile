package com.company;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
    //creating a file to my folder C:\\Users\\GBTC440011ur\\testFile.txt it will handel if the folder is not there
    // it show me the file is created or not
    //the creat file done in my main method
    // by creating static method down below i make wright file to it read file from it ;

        try{
        File file = new File("C:\\Users\\GBTC440011ur\\testFile.txt");
        boolean fik = file.createNewFile();
        if(fik)
            System.out.println("the file created success");
        else
            System.out.println("the file is not created ");
        } catch (IOException e) {
            e.getStackTrace();
        }
        wirtingFile();  // calling the method that wright data to my file
        readFile();    // calling a method that read from the file all work perfictly



    }
    public static void wirtingFile(){
        FileOutputStream fos = null;
        File file;
        String toFile  = "this is how i write to the my file ";

        try{
            file = new File("C:\\Users\\GBTC440011ur\\testFile.txt");
            fos = new FileOutputStream(file);
            if(!file.exists());
            file.createNewFile();
            byte[] bytesArray = toFile.getBytes();

            fos.write(bytesArray);
            fos.flush();
            System.out.println("File Written Successfully");

        }catch (IOException e){
            e.getStackTrace();

        }
        finally {
            try{
                if(fos!=null)
                    fos.close();
            }catch (IOException ioe){
                System.out.println("erorring closing the file ");
            }
        }


    }
    public static void readFile(){
        File file = new File("C:\\Users\\GBTC440011ur\\testFile.txt");
        BufferedInputStream bis = null;
        FileInputStream  fis = null;
        try{
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            while (bis.available()>0){
                System.out.print((char)bis.read());
            }
        }catch (FileNotFoundException fnfe){
            System.out.println("file is not found at the address you give "+ fnfe);
        }
        catch (IOException e){
            System.out.println("io exception "+e);
        }
        finally {
            try{
                if(bis!=null&& fis !=null){
                    fis.close();
                    bis.close();
                }
            }catch (IOException ex){
                System.out.println("error closing fis and bis "+ ex);

            }
        }

    }

}
