package lk.ijse.gdse.hardwaremanagementsystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private String userId;
    private String username;
    private String email;
    private String password;

}
