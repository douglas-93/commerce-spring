package com.dolts.springcommerce.services;

import com.dolts.springcommerce.entities.User;
import com.dolts.springcommerce.repositories.UserRepository;
import com.dolts.springcommerce.services.exceptions.DatabaseException;
import com.dolts.springcommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User alteredUser) {
        try {
            User user = repository.getReferenceById(id);
            updateData(user, alteredUser);
            return repository.save(user);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User user, User alteredUser) {
        user.setName(alteredUser.getName());
        user.setEmail(alteredUser.getEmail());
        user.setPhone(alteredUser.getPhone());
    }
}
