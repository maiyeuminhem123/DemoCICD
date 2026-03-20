package com.example.api.controller;

import com.example.api.model.User;
import com.example.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // GET /api/users - Lấy tất cả người dùng
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET /api/users/{id} - Lấy người dùng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/users - Thêm mới người dùng
    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId(null); // MongoDB tự tạo ID
        user.initCreatedAt(); // Tự set ngày tạo
        return userRepository.save(user);
    }

    // PUT /api/users/{id} - Cập nhật người dùng (bonus)
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id,
                                            @RequestBody User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = optionalUser.get();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()
                && !userDetails.getPassword().equals("defaultPassword")) {
            user.setPassword(userDetails.getPassword());
        }
        user.setRole(userDetails.getRole());
        user.setDateOfBirth(userDetails.getDateOfBirth());
        user.setAddress(userDetails.getAddress());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        return ResponseEntity.ok(userRepository.save(user));
    }

    // DELETE /api/users/{id} - Xóa người dùng (bonus)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
