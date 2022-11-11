package br.pucpr.car_store.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.pucpr.car_store.users.entities.User;
import br.pucpr.car_store.users.repositories.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<User> list() {
        return (List<User>) usersRepository.findAll();
    } 

    public User create(User user) throws ResponseStatusException {
        User userAlreadyExists = this.findByEmail(user.getEmail());
        
        if(userAlreadyExists != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "email already in use");
        }

        return usersRepository.save(user);
    }

    public User update(User user) {
        User userAlreadyExists = this.findByEmail(user.getEmail());
        
        if(userAlreadyExists.getId() != user.getId()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "email already in use");
        }

        return usersRepository.save(user);
    }

    public User findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public User findById(Long id) throws ResponseStatusException {
        Optional<User> user = usersRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
    }

    public void deleteById(Long id) {
        User user = this.findById(id);

        usersRepository.delete(user);
    }

}
