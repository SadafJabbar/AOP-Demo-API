package aop_demo_api.aop_demo_api.controller;

import aop_demo_api.aop_demo_api.dto.UserRequest;
import aop_demo_api.aop_demo_api.entity.UserEntity;
import aop_demo_api.aop_demo_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable Long id){
        return userService.getRecordById(id);
    }

    @GetMapping
    public List<UserEntity> getAll(){
        return userService.getAllRecords();
    }

    @PostMapping
    public UserEntity createRecord(@RequestBody UserRequest user){
        return userService.userCreation(user);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id,@RequestBody UserRequest userRequest){
        return userService.userUpdation(id,userRequest);
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.userDeletion(id);
    }


}
