package dev.loslca.cinematrix.repository;

import dev.loslca.cinematrix.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);
    public List<User> findByFirstNameContainingIgnoreCase(String firstName);
    public List<User> findByLastNameContainingIgnoreCase(String lastName);
    public List<User> findByActive(Boolean active);
    public List<User> findByRoleRoleId(Long roleId);
}