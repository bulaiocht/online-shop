package security;

import lombok.*;

import java.security.Principal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class QuizUserPrincipal implements Principal {

    private String name;

    private String role;
}
