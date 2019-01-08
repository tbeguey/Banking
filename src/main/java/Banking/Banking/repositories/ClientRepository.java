package Banking.Banking.repositories;

import Banking.Banking.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    @Query(value="select c.* from client as c " +
            "join compte_courant as cc on c.id_client = cc.id_client " +
            "join compte_epargne as ce on c.id_client = ce.id_client " +
            "where cc.solde > 2000 " +
            "AND ce.solde > 10000", nativeQuery = true)
    Iterable<Client> findRichClients();
}
