package Banking.Banking.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@MappedSuperclass
@JsonIgnoreProperties({"compteDebite", "compteCredite"})
public abstract class Compte {

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client client;
    private String intitule;
    private Float solde;

    @OneToMany(mappedBy = "idCompteDebite", fetch = FetchType.LAZY)
    private Set<Operation> debits;

    @OneToMany(mappedBy = "idCompteCredite", fetch = FetchType.LAZY)
    private Set<Operation> credits;

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public String getIntitule() { return intitule; }
    public void setIntitule(String intitule) { this.intitule = intitule; }

    public Float getSolde() { return solde; }
    public void setSolde(Float solde) { this.solde = solde; }

    public String toString(){
        return this.intitule + ", de " + this.client + " (" + this.solde + "€)";
    }

    public Set<Operation> getDebits() {
        return debits;
    }

    public void setDebits(Set<Operation> debits) {
        this.debits = debits;
    }

    public Set<Operation> getCredits() {
        return credits;
    }

    public void setCredits(Set<Operation> credits) {
        this.credits = credits;
    }
}
