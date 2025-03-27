package test_estoque.estoque.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import test_estoque.estoque.application.dto.UserDTO;
import test_estoque.estoque.application.services.ResultService;
import test_estoque.estoque.application.services.interfaces.IUserManagementService;

@Component
@RestController
@CrossOrigin
@RequestMapping("/v1")
public class UserController {
    private final IUserManagementService userManagementService;

    @Autowired
    public UserController(IUserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @GetMapping("/public/user/get-user/{userId}")
    public ResponseEntity<ResultService<UserDTO>> findById(@PathVariable String userId){
        var result = userManagementService.findById(userId);

        if(result.IsSuccess){
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/public/user/create")
    public ResponseEntity<ResultService<UserDTO>> Create(UserDTO userDTO){
        var result = userManagementService.create(userDTO);

        if(result.IsSuccess){
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

}
