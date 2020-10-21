package com.paulohenry.zup.nbdigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.paulohenry.zup.nbdigital.entities.UserEntity;

public interface UsersRepository extends JpaRepository<UserEntity, String> {
        
  UserEntity findOneByCpf(String cpf) ;
  
}