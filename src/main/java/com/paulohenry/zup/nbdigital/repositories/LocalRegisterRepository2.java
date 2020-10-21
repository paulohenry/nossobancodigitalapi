package com.paulohenry.zup.nbdigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.paulohenry.zup.nbdigital.entities.LocalRegisterEntity2;

public interface LocalRegisterRepository2 extends JpaRepository<LocalRegisterEntity2, String> {
        
  LocalRegisterEntity2 findOneByCpf(String cpf) ;
}
