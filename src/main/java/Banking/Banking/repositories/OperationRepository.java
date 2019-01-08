package Banking.Banking.repositories;

import Banking.Banking.entities.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OperationRepository extends CrudRepository<Operation, Integer> {
    @Query(value="select o.* from operation as o " +
            "join compte_courant as cc on id_compte_courant = id_compte_debite OR id_compte_courant = id_compte_credite " +
            "join compte_epargne as ce on id_compte_epargne = id_compte_debite OR id_compte_epargne = id_compte_credite " +
            "where cc.id_client = ?1 " +
            "OR ce.id_client = ?1", nativeQuery = true)
    Iterable<Operation> findByClient(int id);
}
