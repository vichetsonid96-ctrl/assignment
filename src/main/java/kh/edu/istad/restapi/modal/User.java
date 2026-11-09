package kh.edu.istad.restapi.modal;

import java.util.UUID;

public record User(
        UUID id,
        String username,
        String password,
        String fullname

) {
}
