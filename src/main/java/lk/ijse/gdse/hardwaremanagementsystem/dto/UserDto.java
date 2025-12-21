package lk.ijse.gdse.hardwaremanagementsystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private String user_Id;
    private String username;
    private String email;
    private String password;

}
