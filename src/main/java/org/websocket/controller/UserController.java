package org.websocket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.websocket.user.UserService;
import org.websocket.user.Users;

import java.util.List;

/**
 * @author prabhakar, @Date 19-07-2024
 */
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public Users addUser(
            @Payload Users user
    ) {
        userService.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public Users disconnectUser(
            @Payload Users user
    ) {
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}
