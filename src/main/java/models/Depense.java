package models;

public class Depense {
    private int id;
    private int montant;
    private int idPrevision;

    public Depense() {}

    public Depense(int id, int montant, int idPrevision) {
        this.id = id;
        this.montant = montant;
        this.idPrevision = idPrevision;
    }

    public Depense(int montant, int idPrevision) {
        this.montant = montant;
        this.idPrevision = idPrevision;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getMontant() { return montant; }
    public void setMontant(int montant) { this.montant = montant; }
    public int getIdPrevision() { return idPrevision; }
    public void setIdPrevision(int idPrevision) { this.idPrevision = idPrevision; }
}