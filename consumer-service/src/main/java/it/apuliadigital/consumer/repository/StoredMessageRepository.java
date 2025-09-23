package it.apuliadigital.consumer.repository;

import it.apuliadigital.consumer.model.StoredMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoredMessageRepository extends JpaRepository<StoredMessage, Long> {
    // standard CRUD operations available — add custom queries as exercises
    static String fin() {
        return "";
    }
}
