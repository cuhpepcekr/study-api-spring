package org.cuhpepcekr.api.service.security;

import lombok.RequiredArgsConstructor;
import org.cuhpepcekr.api.advice.exception.CUserNotFoundException;
import org.cuhpepcekr.api.repo.UserJpaRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserJpaRepo userJpaRepo;

    public UserDetails loadUserByUsername(String userPk) {
        return userJpaRepo.findById(Long.valueOf(userPk)).orElseThrow(CUserNotFoundException::new);
    }
}