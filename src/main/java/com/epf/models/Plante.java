package com.epf.models;
//C'EST DES DTO (DATA TRANSFER OBJECT)
import java.math.BigDecimal;
import java.util.Objects;

public class Plante {
    private int id_plante;
    private String nom;
    private int point_de_vie;
    private BigDecimal attaque_par_seconde;
    private int degat_attaque;
    private int cout;
    private BigDecimal soleil_par_seconde;
    private Effet effet;
    private String chemin_image;

    //on crée un enum pour l'effet de la plante
    public enum Effet{
        NORMAL, SLOW_LOW, SLOW_MEDIUM, SLOW_STOP;
        @com.fasterxml.jackson.annotation.JsonCreator
        public static Effet fromString(String value) {
            return value == null ? null : Effet.valueOf(value.toUpperCase().replace(" ", "_"));
        }
    }

    //Constructeur
    public Plante(int id_plante, String nom, int point_de_vie, BigDecimal attaque_par_seconde, int degat_attaque, int cout, BigDecimal soleil_par_seconde, Effet effet, String chemin_image){
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

    public Effet getEffet(){
        return effet;
    }
    public void setEffet(Effet effet){
        this.effet = effet;
    }

    public String getChemin_image(){
        return chemin_image;
    }
    public void setChemin_image(String chemin_image){
        this.chemin_image = chemin_image;
    }

    @Override
    public boolean equals(Object o) { //pour savoir si 2 plantes sont =
        if (o == null || getClass() != o.getClass()) return false;
        Plante plante = (Plante) o;
        return id_plante == plante.id_plante && point_de_vie == plante.point_de_vie && degat_attaque == plante.degat_attaque && cout == plante.cout && Objects.equals(nom, plante.nom) && Objects.equals(attaque_par_seconde, plante.attaque_par_seconde) && Objects.equals(soleil_par_seconde, plante.soleil_par_seconde) && effet == plante.effet && Objects.equals(chemin_image, plante.chemin_image);
    }

    @Override
    public String toString() {// afficher la plante
        return "plante{" +
                "id_plante=" + id_plante +
                ", nom='" + nom + '\'' +
                ", point_de_vie=" + point_de_vie +
                ", attaque_par_seconde=" + attaque_par_seconde +
                ", degat_attaque=" + degat_attaque +
                ", cout=" + cout +
                ", soleil_par_seconde=" + soleil_par_seconde +
                ", effet=" + effet +
                ", chemin_image='" + chemin_image + '\'' +
                '}';
    }

    @Override
    public int hashCode() { //avoir le hash de la plante
        //return 5;
        return Objects.hash(id_plante, nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image);
    }
}
