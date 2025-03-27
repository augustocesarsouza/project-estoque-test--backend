package test_estoque.estoque.domain.repositories;

import test_estoque.estoque.application.dto.UserDTO;
import test_estoque.estoque.domain.entities.User;

import java.util.UUID;

public interface IUserRepository {
    UserDTO GetUserById(UUID userId);
    User create(User user);
}
