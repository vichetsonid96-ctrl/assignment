package kh.edu.istad.restapi.controller;

import kh.edu.istad.restapi.dto.UserAddDto;
import kh.edu.istad.restapi.dto.UserDto;
import kh.edu.istad.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id){
        userService.deteleById(id);
    }

    // getById
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable UUID id){
        return userService.getById(id);
    }
    // Add new user to data
    @ResponseStatus
    @PostMapping
    public UserDto addNew(@RequestBody UserAddDto userAddDto) {
        return userService.addNew(userAddDto);
    }

    @GetMapping
    public List<UserDto> getAll(
            @RequestParam (required = false, defaultValue = "") String keyword
    ) {
        return userService.getAll(keyword);

    }



}
