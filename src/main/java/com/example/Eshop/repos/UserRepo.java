package com.example.Eshop.repos;

import com.example.Eshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*!
	\brief Интерфейс описывающий поведение репозитория с пользователями
*/
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
