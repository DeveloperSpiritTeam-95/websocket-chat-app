package org.websocket.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author prabhakar, @Date 19-07-2024
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void saveUser(Users user) {
        user.setStatus(Status.ONLINE);
        repository.save(user);
    }

    public void disconnect(Users user) {
        var storedUser = repository.findById(user.getNickName()).orElse(null);
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            repository.save(storedUser);
        }
    }

    public List<Users> findConnectedUsers() {
        return repository.findAllByStatus(Status.ONLINE);
    }


}
