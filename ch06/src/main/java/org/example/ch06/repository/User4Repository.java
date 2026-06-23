package org.example.ch06.repository;


import org.example.ch06.entity.User4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository는 JPA에서 데이터 엑세스 객체(DAO)
@Repository
public interface User4Repository extends JpaRepository<User4, String> {

}