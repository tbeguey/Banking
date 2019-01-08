package Banking.Banking.repositories;

import Banking.Banking.entities.Client;
import Banking.Banking.entities.CompteCourant;
import Banking.Banking.entities.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    @Query("select cc from #{#entityName} as c inner join c.compteCourants as cc where cc.idCompteCourant = ?1 ")
    Iterable<CompteCourant> findByCompteCourant(int id);
}
