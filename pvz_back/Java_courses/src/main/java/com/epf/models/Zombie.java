package com.epf.models;
//C'EST DES DTO (DATA TRANSFER OBJECT)
import java.math.BigDecimal;
import java.util.Objects;

public class Zombie {
    private int id_zombie;
    private String nom;
    private int point_de_vie;
    private BigDecimal attaque_par_seconde;
    private int degat_attaque;
    private BigDecimal vitesse_de_deplacement;
    private String chemin_image;
    private Integer id_map; //peut etre NULL donc Integer pas Int

    //Constructeur
    public Zombie(int id_zombie, String nom, int point_de_vie, BigDecimal attaque_par_seconde, int degat_attaque, BigDecimal vitesse_de_deplacement, String chemin_image, Integer id_map){
        this.id_zombie = id_zombie;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.vitesse_de_deplacement = vitesse_de_deplacement;
        this.chemin_image = chemin_image;
        this.id_map = id_map;
    }

    //getteurs et setteurs
    public int getId_zombie(){
        return id_zombie;
    }
    public void setId_zombie(int id_zombie){
        this.id_zombie = id_zombie;
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
    public void setPoint_de_vie(int pointDeVie){
        this.point_de_vie = pointDeVie;
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

    public BigDecimal getVitesse_de_deplacement(){
        return vitesse_de_deplacement;
    }
    public void setVitesse_de_deplacement(BigDecimal vitesse_de_deplacement){
        this.vitesse_de_deplacement = vitesse_de_deplacement;
    }

    public String getChemin_image(){
        return chemin_image;
    }
    public void setChemin_image(String chemin_image){
        this.chemin_image = chemin_image;
    }

    public Integer getId_map(){
        return id_map;
    }
    public void setId_map(Integer id_map){
        this.id_map = id_map;
    }

    @Override
    public boolean equals(Object o) { //pour savoir si 2 zombies sont egaux
        if (o == null || getClass() != o.getClass()) return false;
        Zombie zombie = (Zombie) o;
        return id_zombie == zombie.id_zombie && point_de_vie == zombie.point_de_vie && degat_attaque == zombie.degat_attaque && Objects.equals(nom, zombie.nom) && Objects.equals(attaque_par_seconde, zombie.attaque_par_seconde) && Objects.equals(vitesse_de_deplacement, zombie.vitesse_de_deplacement) && Objects.equals(chemin_image, zombie.chemin_image) && Objects.equals(id_map, zombie.id_map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_zombie, nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map);
    }

    @Override
    public String toString() { //afficher le zombie
        return "zombie{" +
                "id_zombie=" + id_zombie +
                ", nom='" + nom + '\'' +
                ", point_de_vie=" + point_de_vie +
                ", attaque_par_seconde=" + attaque_par_seconde +
                ", degat_attaque=" + degat_attaque +
                ", vitesse_de_deplacement=" + vitesse_de_deplacement +
                ", chemin_image='" + chemin_image + '\'' +
                ", id_map=" + id_map +
                '}';
    }
}
