package org.example.ch06.repository;


import org.example.ch06.entity.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repository는 JPA에서 데이터 엑세스 객체(DAO)
@Repository
public interface User2Repository extends JpaRepository<User2, String> {

}