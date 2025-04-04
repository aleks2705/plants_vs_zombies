package com.epf.dto;

public class MapDTO {
    private int id_map;
    private int ligne;
    private int colonne;
    private String cheminImage;

    public MapDTO(int id_map, int ligne, int colonne, String cheminImage) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.cheminImage = cheminImage;
    }

    public int getId_map() {
        return id_map;
    }

    public void setId_map(int id) {
        this.id_map = id;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }
}
