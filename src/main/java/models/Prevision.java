package models;

public class Prevision {
    private int id;
    private String nom;
    private int montant;

    public Prevision() {}

    public Prevision(int id, String nom, int montant) {
        this.id = id;
        this.nom = nom;
        this.montant = montant;
    }

    public Prevision(String nom, int montant) {
        this.nom = nom;
        this.montant = montant;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getMontant() { return montant; }
    public void setMontant(int montant) { this.montant = montant; }
}