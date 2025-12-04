package com.example.coach.model;


import java.util.Date;

import kotlin.text.UStringsKt;

public class Profil {
    private static final int MIN_FEMME = 25;
    private static final int MAX_FEMME = 30;
    private static final int MIN_HOMME = 15;
    private static final int MAX_HOMME = 20;
    private static final String[] MESSAGE = {"trop faible", "normal", "trop élevé"};
    private static final String[] IMAGE = {"maigre", "normal", "graisse"};
    private int poids;
    private int taille;
    private int age;
    private int sexe;
    private double img;
    private int indice;
    private Date dateMesure;

    public Profil(int poids, int taille, int age, int sexe, Date dateMesure) {
        this.taille = taille;
        this.poids = poids;
        this.age = age;
        this.sexe = sexe;
        this.dateMesure = dateMesure;
        this.img = calculImg();
        this.indice = calculIndice();
    }

    private double calculImg() {
        double tailleMetre = taille / 100.0;
        return (1.2 * poids / (tailleMetre * tailleMetre))
                + (0.23 * age)
                - (10.83 * sexe)
                - 5.4;
    }

    private int calculIndice() {
        int min = (sexe == 0) ? MIN_FEMME : MIN_HOMME;
        int max = (sexe == 0) ? MAX_FEMME : MAX_HOMME;
        if (img > max) {
            return 2; // au-dessus de la norme
        }
        if (img >= min) {
            return 1; // dans la norme
        }
        return 0; // en dessous
    }

    public double getImg(){
        return img;
    }
    public String getMessage(){
        return MESSAGE[indice];
    }
    public String getImage(){
        return IMAGE[indice];
    }
    public Boolean normal(){
        return indice == 1;
    }
    public int getPoids() {
        return poids;
    }
    public int getTaille() {
        return taille;
    }
    public int getAge() {
        return age;
    }
    public int getSexe() {
        return sexe;
    }

    public Date getDateMesure() {
        return dateMesure;
    }
}
