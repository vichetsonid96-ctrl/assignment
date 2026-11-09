package kh.edu.istad.restapi.service;

import kh.edu.istad.restapi.dto.UserDto;

import java.util.List;

public interface UserService {

    // Define business logic
    List<UserDto> getAll(String keyword);

}
