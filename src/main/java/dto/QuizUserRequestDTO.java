package dto;

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
public class QuizUserRequestDTO {

    private String username;

    private String password;

}