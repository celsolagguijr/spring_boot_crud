package com.example.crud_project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.crud_project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User save(User user);

    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

    public List<User> findAll();

    public Page<User> findAll(Pageable pageable);

    long countByUsername(String username);

    void deleteById(Long id);

    long deleteByUsername(String username);

}
