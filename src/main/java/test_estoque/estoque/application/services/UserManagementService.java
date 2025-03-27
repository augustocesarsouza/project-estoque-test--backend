package test_estoque.estoque.application.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test_estoque.estoque.application.dto.UserDTO;
import test_estoque.estoque.application.services.interfaces.IUserManagementService;
import test_estoque.estoque.domain.entities.User;
import test_estoque.estoque.domain.repositories.IUserRepository;

import java.util.UUID;

@Service
public class UserManagementService implements IUserManagementService {
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserManagementService(IUserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResultService<UserDTO> findById(String userId) {
        try {
            UserDTO userDTO = userRepository.GetUserById(UUID.fromString(userId));

            if(userDTO == null){
                return ResultService.Fail("not found");
            }

            return ResultService.Ok(userDTO); // testar isso para ver se o "Mapper" vai funcionar
        }catch (Exception ex){
            return ResultService.Fail(ex.getMessage());
        }
    }

    @Override
    public ResultService<UserDTO> create(UserDTO userDTO) {
        if(userDTO == null)
            return ResultService.Fail("error DTO Is Null");


        try {
            UUID uuid_user_id = UUID.randomUUID();

            User userCreate = new User(uuid_user_id, userDTO.getName(), userDTO.getLastName());

            var userData = userRepository.create(userCreate);

            var userMap = modelMapper.map(userData, UserDTO.class);
            return ResultService.Ok(userMap);
        }catch (Exception ex){
            return ResultService.Fail(ex.getMessage());
        }
    }
}
