package Banking.Banking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "compte_epargne")
@JsonIgnoreProperties({"compteDebite", "compteCredite"})
public class CompteEpargne extends Compte{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompteEpargne;

    private Float tauxInterets;

    public CompteEpargne() {

    }

    public int getIdCompteEpargne() { return idCompteEpargne; }
    public void setIdCompteEpargne(int idCompteEpargne) { this.idCompteEpargne = idCompteEpargne; }

    public Float getTauxInterets() { return tauxInterets; }
    public void setTauxInterets(Float tauxInterets) { this.tauxInterets = tauxInterets; }
}