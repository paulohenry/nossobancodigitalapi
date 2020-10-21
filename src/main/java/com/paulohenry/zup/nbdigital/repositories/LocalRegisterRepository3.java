package com.paulohenry.zup.nbdigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.paulohenry.zup.nbdigital.entities.LocalRegisterEntity3;

public interface LocalRegisterRepository3 extends JpaRepository<LocalRegisterEntity3, String> {
  LocalRegisterEntity3 findOneByCpf(String cpf) ;
}