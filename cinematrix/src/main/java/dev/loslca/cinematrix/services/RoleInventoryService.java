package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.entity.Role;
import dev.loslca.cinematrix.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

public class RoleInventoryService {

    private final RoleRepository repository;

    public RoleInventoryService(RoleRepository repository) { this.repository = repository; }

    public List<Role> findAllRoles() {
        return this.repository.findAll();
    }

    public Optional<Role> findRoleByName(String name) {
        return this.repository.findByName(name);
    }
}