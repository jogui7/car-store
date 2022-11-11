package br.pucpr.car_store.users.repositories;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.pucpr.car_store.users.entities.User;

public class UsersRepositoryImpl implements UsersRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findByEmail(String email) {
        try {
            Query query = entityManager.createNativeQuery(
                "SELECT * FROM users WHERE email = ?", 
                User.class
            );
    
            query.setParameter(1, email);
    
            User user = (User) query.getSingleResult();
            
            return user;
        } catch (Exception e) {
            
        }
        return null;

    }
    
}
