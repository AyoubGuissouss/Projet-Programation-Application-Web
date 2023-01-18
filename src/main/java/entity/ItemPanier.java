package entity;

public class ItemPanier {
    //Attributs
    private String nom;
    private int quantite;
    private double totalItem;

    //Constructeurs

    public ItemPanier() {
    }

    public ItemPanier(String nom, int quantite) {
        this.nom = nom;
        this.quantite = quantite;
    }

    public ItemPanier(String nom, int quantite, double totalItem) {
        this.nom = nom;
        this.quantite = quantite;
        this.totalItem = totalItem;
    }

    //Getter et Setter


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(double totalItem) {
        this.totalItem = totalItem;
    }

    //ToString

    @Override
    public String toString() {
        return "ItemPanier{" +
                "nom='" + nom + '\'' +
                ", quantite=" + quantite +
                ", totalItem=" + totalItem +
                '}';
    }
}
