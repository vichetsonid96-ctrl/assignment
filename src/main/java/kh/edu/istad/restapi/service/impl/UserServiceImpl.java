package kh.edu.istad.restapi.service.impl;

import kh.edu.istad.restapi.dto.UserAddDto;
import kh.edu.istad.restapi.dto.UserDto;
import kh.edu.istad.restapi.modal.User;
import kh.edu.istad.restapi.repository.UserRepository;
import kh.edu.istad.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

// User Service Implementation
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void deteleById(UUID id) {
        boolean isFound = userRepository.select().stream().anyMatch(user -> user.id().equals(id));

        if(isFound)
            userRepository.select().removeIf(user -> user.id().equals(id));
        else
            throw new RuntimeException("Not found.");
    }

    @Override
    public UserDto getById(UUID id) {
        return userRepository.select().stream().filter(user -> user.id().equals(id)).findFirst()
                .map(user -> new UserDto(user.id(), user.fullname())).orElseThrow();
    }

    @Override
    public UserDto addNew(UserAddDto userAddDto) {
        User user = new User(
                UUID.randomUUID(),
                userAddDto.username(),
                userAddDto.password(),
                userAddDto.fullName()
        );

        userRepository.select().add(user);
        return new UserDto(user.id(), user.fullname());
    }

    @Override
    public List<UserDto> getAll(String keyword) {
        return userRepository.select()
                .stream()
                .filter(user-> user.fullname().toLowerCase()
                        .contains(keyword.toLowerCase())
                )
                .map(user -> new UserDto(user.id(), user.fullname()))
                .toList();
    }
}
