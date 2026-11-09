package kh.edu.istad.restapi.controller;

import kh.edu.istad.restapi.dto.UserDto;
import kh.edu.istad.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getAll(
            @RequestParam (required = false, defaultValue = "") String keyword
    ) {
        return userService.getAll(keyword);

    }
}
