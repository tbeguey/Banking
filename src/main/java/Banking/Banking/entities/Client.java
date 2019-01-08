package Banking.Banking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {

    @Id
    @Column(name = "id_client")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;

    private String nom;
    private String prenom;

    @JsonIgnoreProperties("client")
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<CompteCourant> compteCourants;

    @JsonIgnoreProperties("client")
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<CompteEpargne> compteEpargnes;


    public Client() {

    }


    public int getIdClient() { return this.idClient; }
    public void setIdClient(int id) { this.idClient = id; }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public Set<CompteCourant> getCompteCourants() {
        return compteCourants;
    }
    public void setCompte(Set<CompteCourant> compteCourants) {
        this.compteCourants = compteCourants;
    }


    @Override
    public String toString(){
        return this.nom + " " + this.prenom;
    }

    public Set<CompteEpargne> getCompteEpargnes() {
        return compteEpargnes;
    }

    public void setCompteEpargnes(Set<CompteEpargne> compteEpargnes) {
        this.compteEpargnes = compteEpargnes;
    }
}