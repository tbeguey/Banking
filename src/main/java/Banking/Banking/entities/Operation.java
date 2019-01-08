package Banking.Banking.entities;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOperation;

    private int idCompteDebite;
    private int idCompteCredite;
    private float montant;

    public Operation () {

    }

    /*@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    private Compte compteDebite;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    private Compte compteCredite;*/

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    /*public Compte getCompteDebite() {
        return compteDebite;
    }

    public void setCompteDebite(Compte compteDebite) {
        this.compteDebite = compteDebite;
    }

    public Compte getCompteCredite() {
        return compteCredite;
    }

    public void setCompteCredite(CompteCourant compteCredite) {
        this.compteCredite = compteCredite;
    }*/


    public int getIdCompteDebite() {
        return idCompteDebite;
    }

    public void setIdCompteDebite(int idCompteDebite) {
        this.idCompteDebite = idCompteDebite;
    }

    public int getIdCompteCredite() {
        return idCompteCredite;
    }

    public void setIdCompteCredite(int idCompteCredite) {
        this.idCompteCredite = idCompteCredite;
    }

    @Override
    public String toString() {
        return "Montant de l'opération : " + montant;
    }

}