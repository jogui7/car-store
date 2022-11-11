package br.pucpr.car_store.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.pucpr.car_store.users.entities.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long>, UsersRepositoryCustom {
    
}
