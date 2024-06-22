package com.uep.wap.service;

import com.uep.wap.dto.PhotoDTO;
import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.Photo;
import com.uep.wap.model.User;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public static void addUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setGender(userDTO.getGender());
        user.setEmail(userDTO.getEmail());
        user.setProfilePicture(userDTO.getProfilePicture());
        user.setBio(userDTO.getBio());
        user.setRole(userDTO.getRole());

        userRepository.save(user);

    }

    public static void editUser(int user_id, UserDTO userDTO) {
        User user = userRepository.findById(user_id).get();
        user.setUsername(userDTO.getUsername());
        user.setGender(userDTO.getGender());
        user.setEmail(userDTO.getEmail());
        user.setProfilePicture(userDTO.getProfilePicture());
        user.setBio(userDTO.getBio());
        user.setRole(userDTO.getRole());

        userRepository.save(user);

    }

    public Optional<User> getUserById(int userId) {return userRepository.findById(userId);}
    public void deleteUser(int userId) {userRepository.deleteById(userId);}
    public User findUserByUsername(String username) {return userRepository.findByUsername(username);}
    public User findUserByEmail(String email) {return userRepository.findByEmail(email);}

    public Iterable<User> getAllUsers() {return userRepository.findAll();}
}
