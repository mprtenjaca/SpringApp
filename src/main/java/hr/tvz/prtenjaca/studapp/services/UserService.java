package hr.tvz.prtenjaca.studapp.services;
import hr.tvz.prtenjaca.studapp.dto.UserDTO;

import java.util.Optional;

public interface UserService {

    Optional<UserDTO> findByUsername(String username);

}
