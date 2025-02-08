package com.primeux.skillflowai.users.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SkillflowUserDetailsService implements UserDetailsService {

    private final SpringDataLoginUserRepository userRepository;
    private final LoginUserEntityMapper userEntityMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).map(userEntityMapper::toUser)
                .map(SkillflowUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username)));
    }
}
