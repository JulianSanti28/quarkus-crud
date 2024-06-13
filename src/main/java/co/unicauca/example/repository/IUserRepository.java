package co.unicauca.example.repository;

import co.unicauca.example.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Objects;

@ApplicationScoped
public class IUserRepository implements PanacheRepository<User> {
    public boolean existsById(final Long userId){
        return Objects.nonNull(find("id", userId).firstResult());
    }
}
