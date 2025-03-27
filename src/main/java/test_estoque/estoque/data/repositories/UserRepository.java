package test_estoque.estoque.data.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test_estoque.estoque.application.dto.UserDTO;
import test_estoque.estoque.data.context.UserRepositoryJPA;
import test_estoque.estoque.domain.entities.User;
import test_estoque.estoque.domain.repositories.IUserRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UserRepository implements IUserRepository {
    private final UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public UserRepository(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    @Override
    public UserDTO GetUserById(UUID userId) {
        return userRepositoryJPA.GetUserById(userId);
    }

    @Override
    public User create(User user) {
        if(user == null)
            return null;

        return userRepositoryJPA.save(user);
    }
}
