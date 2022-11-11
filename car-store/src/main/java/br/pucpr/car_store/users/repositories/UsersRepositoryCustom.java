package br.pucpr.car_store.users.repositories;

import br.pucpr.car_store.users.entities.User;

public interface UsersRepositoryCustom {
    User findByEmail(String email);
}
