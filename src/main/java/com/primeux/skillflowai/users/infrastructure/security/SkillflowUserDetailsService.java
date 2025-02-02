package com.primeux.skillflowai.users.infrastructure.security;

import com.primeux.skillflowai.users.core.domain.model.Email;
import com.primeux.skillflowai.users.core.ports.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SkillflowUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(new Email(username))
                .map(SkillflowUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username)));
    }
}
