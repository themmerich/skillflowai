package com.primeux.skillflowai.security.infrastructure.security;

import com.primeux.skillflowai.users.domain.model.Email;
import com.primeux.skillflowai.users.domain.repository.UserRepository;
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
