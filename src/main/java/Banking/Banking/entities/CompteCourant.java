package Banking.Banking.entities;


import javax.persistence.*;

@Entity
@Table(name = "compte_courant")
public class CompteCourant extends Compte{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompteCourant;

    private Float decouvert;


    public CompteCourant() {

    }

    public int getIdCompteCourant() { return idCompteCourant; }
    public void setIdCompteCourant(int idCompteCourant) { this.idCompteCourant = idCompteCourant; }

    public Float getDecouvert() { return decouvert; }
    public void setDecouvert(Float decouvert) { this.decouvert = decouvert; }


}