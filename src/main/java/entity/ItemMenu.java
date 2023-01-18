package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemMenu {
    //Attributs
    private String urlPhoto;
    @Id
    private String nom;
    private String description;
    private double prix;
    private String categorie;

    //Constructeurs
    public ItemMenu() {
    }

    public ItemMenu(String urlPhoto, String nom, String description, double prix, String categorie) {
        this.urlPhoto = urlPhoto;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.categorie = categorie;
    }

    //Getter et Setter
    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    //ToString

    @Override
    public String toString() {
        return "ItemMenu{" +
                "urlPhoto='" + urlPhoto + '\'' +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
