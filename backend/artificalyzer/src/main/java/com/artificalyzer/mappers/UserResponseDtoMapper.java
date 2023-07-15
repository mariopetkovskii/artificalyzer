package com.artificalyzer.mappers;

import com.artificalyzer.models.userroles.entity.User;
import com.artificalyzer.records.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserResponseDtoMapper implements Function<User, UserResponseDto> {
    @Override
    public UserResponseDto apply(User user) {
        return new UserResponseDto(
                user.getEmail(),
                user.getFirstName(),
                user.getLastName());
    }
}
