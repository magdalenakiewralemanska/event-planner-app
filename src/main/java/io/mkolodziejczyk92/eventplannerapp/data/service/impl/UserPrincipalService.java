package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.User;
import io.mkolodziejczyk92.eventplannerapp.data.model.UserPrincipal;
import io.mkolodziejczyk92.eventplannerapp.data.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static io.mkolodziejczyk92.eventplannerapp.data.constant.UserServicesConstant.*;

@Service
@Transactional
public class UserPrincipalService implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final UserRepository userRepository;

    public UserPrincipalService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(user == null){
            logger.error(NO_USER_FOUND_BY_USERNAME + username);
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_USERNAME + username);
        } else {
            logger.info(FOUND_USER_BY_USERNAME + username);
            return new UserPrincipal(user);
        }
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
