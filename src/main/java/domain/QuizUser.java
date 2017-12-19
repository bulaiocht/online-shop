package domain;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuizUser implements Serializable {
    private int id;
    private String username;
    private Role role;
}