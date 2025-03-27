package test_estoque.estoque.application.services.interfaces;

import test_estoque.estoque.application.dto.UserDTO;
import test_estoque.estoque.application.services.ResultService;

public interface IUserManagementService {
    ResultService<UserDTO> findById(String userId);
    ResultService<UserDTO> create(UserDTO userDTO);
}
