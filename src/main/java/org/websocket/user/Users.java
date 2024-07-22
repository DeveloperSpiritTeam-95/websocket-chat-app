package org.websocket.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author prabhakar, @Date 19-07-2024
 */

@Getter
@Setter
@Document
public class Users {
    @Id
    private String nickName;
    private String fullName;
    private Status status;

}