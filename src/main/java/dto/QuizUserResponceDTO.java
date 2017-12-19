package dto;

import domain.Role;
import lombok.*;

/**
 * Created by Kocherha Vitalii on 19.12.2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class QuizUserResponceDTO {

    private int id;

    private String username;

    private Role role;

}
