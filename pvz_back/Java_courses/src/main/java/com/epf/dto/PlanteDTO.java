package com.epf.dto;

import com.epf.models.Plante;

import java.math.BigDecimal;

public class PlanteDTO {
    private int id_plante;
    private String nom;
    private int point_de_vie;
    private BigDecimal attaque_par_seconde;
    private int degat_attaque;
    private int cout;
    private BigDecimal soleil_par_seconde;
    private Plante.Effet effet;
    private String chemin_image;

    public PlanteDTO() {
    }

    public PlanteDTO(int id_plante, String nom, int point_de_vie, BigDecimal attaque_par_seconde, int degat_attaque, int cout, BigDecimal soleil_par_seconde, Plante.Effet effet, String chemin_image){
        this.id_plante = id_plante;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.cout = cout;
        this.soleil_par_seconde = soleil_par_seconde;
        this.effet = effet;
        this.chemin_image = chemin_image;
    }
    public int getId_plante() {
        return id_plante;
    }

    public void setId_plante(int id_plante) {
        this.id_plante = id_plante;
    }

    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    public int getPoint_de_vie(){
        return point_de_vie;
    }
    public void setPoint_de_vie(int point_de_vie){
        this.point_de_vie = point_de_vie;
    }

    public BigDecimal getAttaque_par_seconde(){
        return attaque_par_seconde;
    }
    public void setAttaque_par_seconde(BigDecimal attaque_par_seconde){
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public int getDegat_attaque(){
        return degat_attaque;
    }
    public void setDegat_attaque(int degat_attaque){
        this.degat_attaque = degat_attaque;
    }

    public int getCout(){
        return cout;
    }
    public void setCout(int cout){
        this.cout = cout;
    }

    public BigDecimal getSoleil_par_seconde(){
        return soleil_par_seconde;
    }
    public void setSoleil_par_seconde(BigDecimal soleil_par_seconde){
        this.soleil_par_seconde = soleil_par_seconde;
    }

    public Plante.Effet getEffet(){
        return effet;
    }
    public void setEffet(Plante.Effet effet){
        this.effet = effet;
    }

    public String getChemin_image(){
        return chemin_image;
    }
    public void setChemin_image(String chemin_image){
        this.chemin_image = chemin_image;
    }
}
