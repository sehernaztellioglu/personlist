package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static List<Person> personlar = new LinkedList<>();




    public static void nationalityOku(String nation){

        int sayac = 0;

        for(int i = 0; i < personlar.size(); i++) {

            if(nation.equals(personlar.get(i).uyruk)){
                sayac++;
            }



        }
        System.out.println(sayac);
    }









    public static List<Person> kisileriOku() {


        try (BufferedReader reader = new BufferedReader(
                new FileReader("/Users/sehernaztellioglu/IdeaProjects/personlist/src/main/java/org/example/persons.csv"))) {

            String satir;

            while ((satir = reader.readLine()) != null) {
                String[] bilgiler = satir.split(",");

                Person kisi = new Person();
                kisi.isim = bilgiler[0];
                kisi.soyad = bilgiler[1];
                kisi.uyruk = bilgiler[2];

                personlar.add(kisi);
            }

        } catch (IOException e) {
            System.out.println("Dosya okunamadı: " + e.getMessage());
        }

        return personlar;
    }




    public static void main(String[] args) {
        
        kisileriOku();
        nationalityOku("TR");
    }




}