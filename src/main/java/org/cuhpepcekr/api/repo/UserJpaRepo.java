package org.cuhpepcekr.api.repo;

import org.cuhpepcekr.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepo extends JpaRepository<User, Long> {

}