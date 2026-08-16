package aop_demo_api.aop_demo_api.service;

import aop_demo_api.aop_demo_api.annotation.TrackExecution;
import aop_demo_api.aop_demo_api.dto.UserRequest;
import aop_demo_api.aop_demo_api.entity.UserEntity;
import aop_demo_api.aop_demo_api.exception.UserNotFound;
import aop_demo_api.aop_demo_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @TrackExecution
    public UserEntity getRecordById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new UserNotFound(id));
    }

    public List<UserEntity> getAllRecords(){
        return userRepository.findAll();
    }


    @TrackExecution
    public UserEntity userCreation(UserRequest userRequest){
        UserEntity user=UserEntity.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .age(userRequest.age())
                .build();
        userRepository.save(user);
        return user;
    }

    @TrackExecution
    public UserEntity userUpdation(Long id,UserRequest userRequest){
        UserEntity user=userRepository.findById(id).orElseThrow(()-> new UserNotFound(id));
        user.setId(id);
        user.setEmail(userRequest.email());
        user.setName(userRequest.name());
        user.setAge(userRequest.age());
        userRepository.save(user);
        return user;
    }

    public String userDeletion(Long id){
        UserEntity user=userRepository.findById(id).orElseThrow(()->new UserNotFound(id));
       userRepository.deleteById(id);
       return "record deleted.";
    }

}
