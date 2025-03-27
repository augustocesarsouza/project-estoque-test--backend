package test_estoque.estoque.data.context;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test_estoque.estoque.application.dto.UserDTO;
import test_estoque.estoque.domain.entities.User;

import java.util.UUID;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User, UUID> {
    @Query("SELECT new test_estoque.estoque.application.dto." +
            "UserDTO(x.Id, x.Name, x.LastName) " +
            "FROM User AS x " +
            "WHERE x.Id = :userId")
    UserDTO GetUserById(UUID userId);
}
//UserDTO(UUID id, String name, String lastName)

//User(UUID id, String name, String lastName)