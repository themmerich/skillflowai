package com.primeux.skillflowai.shared.security.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SkillflowUserDetailsService implements UserDetailsService {

    private final SpringDataLoginUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).map(user -> new SkillflowUserDetails(
                        user.getEmail(),
                        user.getPassword(),
                        user.getTenantId(),
                        user.getRoles()
                ))
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username)));
    }
}
