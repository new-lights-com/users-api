package com.lights.users.repository;
import com.lights.users.model.entity.CartEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {

}
