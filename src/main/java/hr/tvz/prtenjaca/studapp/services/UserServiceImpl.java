package hr.tvz.prtenjaca.studapp.services;

import hr.tvz.prtenjaca.studapp.domain.Authority;
import hr.tvz.prtenjaca.studapp.domain.User;
import hr.tvz.prtenjaca.studapp.dto.UserDTO;
import hr.tvz.prtenjaca.studapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return userRepository.findOneByUsername(username).map(this::mapUserToDTO);
    }

    public UserDTO mapUserToDTO(final User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName((user.getFirstName()));
        userDTO.setLastName(user.getLastName());
        userDTO.setAuthorities(user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));

        return userDTO;
    }

}
