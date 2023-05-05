package com.example.Eshop.domain;

import org.springframework.security.core.GrantedAuthority;

/*!
	\brief Класс роли, описывающий сущность
*/
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
