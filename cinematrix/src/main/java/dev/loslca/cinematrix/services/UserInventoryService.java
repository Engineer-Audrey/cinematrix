package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.entity.User;
import dev.loslca.cinematrix.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserInventoryService {

    private final UserRepository repository;

    public UserInventoryService(UserRepository repository) { this.repository = repository; }

    public List<User> findAllUsers() {
        return this.repository.findAll();
    }

    public Optional<User> findUserByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    public List<User> findUsersByFirstName(String firstName) {
        return this.repository.findByFirstNameContainingIgnoreCase(firstName);
    }

    public List<User> findUsersByLastName(String lastName) {
        return this.repository.findByLastNameContainingIgnoreCase(lastName);
    }

    public List<User> findUsersByActive(Boolean active) {
        return this.repository.findByActive(active);
    }

    public List<User> findUsersByRole(Long roleId) {
        return this.repository.findByRoleRoleId(roleId);
    }
}