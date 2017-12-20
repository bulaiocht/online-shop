package domain;

import lombok.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class QuizUser implements Serializable {
    private int id;
    private String username;
    private Role role;
    private String hashPassword;
    private String salt;
}