
package models;


import java.lang.reflect.GenericArrayType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admins")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    @Id
    @GeneratedValue(strategy = GenericArrayType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String role;
}
