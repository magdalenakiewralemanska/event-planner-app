package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.entity.User;
import io.mkolodziejczyk92.eventplannerapp.data.enums.AddressType;
import io.mkolodziejczyk92.eventplannerapp.data.enums.Role;
import io.mkolodziejczyk92.eventplannerapp.data.exception.EmailExistException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UserNotFoundException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UsernameExistException;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.UserRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.AddressService;
import io.mkolodziejczyk92.eventplannerapp.data.service.UserService;
import io.mkolodziejczyk92.eventplannerapp.data.validation.UsernameAndEmailValidator;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final AddressService addressService;
    private final UsernameAndEmailValidator validator;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, AddressService addressService, UsernameAndEmailValidator validator,
                           BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.addressService = addressService;
        this.validator = validator;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserDto userDto) throws UserNotFoundException, EmailExistException, UsernameExistException {
        validator.checkThatNewUsernameAndEmailNotRepeat(StringUtils.EMPTY, userDto.getUsername(), userDto.getPassword());
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(Role.USER.getValue());
        AddressDto addressDto = userDto.getAddress();
        if(addressDto != null) {
            Address address = addressService.saveAddress(addressDto);
            address.setAddressType(AddressType.RESIDENCE);
            address.setUser(user);
            user.setAddress(address);
        }
        user.setUserEvents(userDto.getUserEvents());
        repository.save(user);
    }

}
