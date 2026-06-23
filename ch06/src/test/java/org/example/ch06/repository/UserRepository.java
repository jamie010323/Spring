package org.example.ch06.repository;

import org.example.ch06.entity.board.User;
import org.springframework.data.repository.Repository;

interface UserRepository extends Repository<User, String> {
}
