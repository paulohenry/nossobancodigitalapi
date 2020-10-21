package com.paulohenry.zup.nbdigital.repositories;


import com.paulohenry.zup.nbdigital.entities.LocalRegisterEntity1;

import org.springframework.data.jpa.repository.JpaRepository;


public interface LocalRegisterRepository1 extends JpaRepository<LocalRegisterEntity1, String> {
        
  LocalRegisterEntity1 findOneByCpf(String cpf) ;
  
}
