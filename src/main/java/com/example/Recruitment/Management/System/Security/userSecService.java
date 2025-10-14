package com.example.Recruitment.Management.System.Security;


import com.example.Recruitment.Management.System.Entity.User;
import com.example.Recruitment.Management.System.Repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class userSecService implements UserDetailsService {

    private final UserRepository userRepository;

    public userSecService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        userSecEntity secUser = new userSecEntity();
        secUser.setId(user.getId());
        secUser.setEmail(user.getEmail());
        secUser.setPassword(user.getPasswordHash());
        return secUser;
    }
}
