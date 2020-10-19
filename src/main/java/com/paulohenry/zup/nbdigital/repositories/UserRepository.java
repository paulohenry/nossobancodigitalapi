package com.paulohenry.zup.nbdigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.paulohenry.zup.nbdigital.entities.userentity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {
        
    
}
