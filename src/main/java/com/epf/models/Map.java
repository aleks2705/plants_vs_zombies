package com.epf.models;
//C'EST DES DTO (DATA TRANSFER OBJECT)
import java.util.Objects;

public class Map {
    private int id_map;
    private int ligne;
    private int colonne;
    private String chemin_image;

    //Constructeur
    public Map(int id_map, int ligne, int colonne, String chemin_image){
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }

    //setters et getters
    public int getId_map(){
        return id_map;
    }
    public void setId_map(int id_map){
        this.id_map = id_map;
    }

    public int getLigne(){
        return ligne;
    }
    public void setLigne(int ligne){
        this.ligne = ligne;
    }

    public int getColonne(){
        return colonne;
    }
    public void setColonne(int colonne){
        this.colonne = colonne;
    }

    public String getChemin_image(){
        return chemin_image;
    }
    public void setChemin_image(String chemin_image){
        this.chemin_image = chemin_image;
    }

    @Override
    public boolean equals(Object o) { //pour savoir si 2 map sont egales
        if (o == null || getClass() != o.getClass()) return false;
        Map map = (Map) o;
        return id_map == map.id_map && ligne == map.ligne && colonne == map.colonne && Objects.equals(chemin_image, map.chemin_image);
    }

    @Override
    public int hashCode() { //hash unique de chaque map
        return Objects.hash(id_map, ligne, colonne, chemin_image);
    }

    @Override
    public String toString() { //afficher la map
        return "map{" +
                "id_map=" + id_map +
                ", ligne=" + ligne +
                ", colonne=" + colonne +
                ", chemin_image='" + chemin_image + '\'' +
                '}';
    }
}
