package ch.noseryoung.realestate.domain.role;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="role")
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "role_id", nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String name;

}
