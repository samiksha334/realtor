package com.realtor.service.impl;

import com.realtor.entity.User;
import com.realtor.payload.UserDto;
import com.realtor.repository.UserRepository;
import com.realtor.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private ModelMapper modelMapper;
   @Autowired
    private UserRepository userRepository;
    @Override
    public long createUser(UserDto userDto) {
        User user=mapToEntity(userDto);
        User savedUser=userRepository.save(user);
        return savedUser.getId();
    }
    User mapToEntity(UserDto userDto){
        User user=modelMapper.map(userDto,User.class);
   return user;
    }
}
