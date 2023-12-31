package io.mkolodziejczyk92.eventplannerapp.data.validation;


import io.mkolodziejczyk92.eventplannerapp.data.constant.UserServicesConstant;
import io.mkolodziejczyk92.eventplannerapp.data.entity.User;
import io.mkolodziejczyk92.eventplannerapp.data.exception.EmailExistException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UserNotFoundException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UsernameExistException;
import io.mkolodziejczyk92.eventplannerapp.data.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UsernameAndEmailValidator {

    private final UserRepository userRepository;

    public UsernameAndEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User checkThatNewUsernameAndEmailNotRepeat(String currentUsername, String newUsername, String newEmail)
            throws UserNotFoundException, UsernameExistException, EmailExistException {
        if(StringUtils.isNotBlank(currentUsername)) {
            return checkThatUserExists(currentUsername);
        } else {
            checkThatUsernameNotRepeatForRegistration(newUsername);
            checkThatEmailNotRepeatForRegistration(newEmail);
            return null;
        }
    }

    private void checkThatEmailNotRepeatForRegistration(String newEmail) throws EmailExistException {
        User userByNewEmail = userRepository.findUserByEmail(newEmail);
        if(userByNewEmail != null) {
            throw new EmailExistException(UserServicesConstant.EMAIL_ALREADY_EXISTS);
        }
    }

    private void checkThatUsernameNotRepeatForRegistration(String newUsername) throws UsernameExistException {
        User userByNewUsername = userRepository.findUserByUsername(newUsername);
        if(userByNewUsername != null) {
            throw new UsernameExistException(UserServicesConstant.USERNAME_ALREADY_EXISTS);
        }
    }

    private User checkThatUserExists(String currentUsername) throws UserNotFoundException {
        User currentUser = userRepository.findUserByUsername(currentUsername);
        if(currentUser == null) {
            throw new UserNotFoundException(UserServicesConstant.NO_USER_FOUND_BY_USERNAME + currentUsername);
        }
        return currentUser;
    }
}
