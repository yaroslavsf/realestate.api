package ch.noseryoung.realestate.domain.role;

import ch.noseryoung.realestate.core.generic.Auditable;
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
public class Role extends Auditable {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "role_id", nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String name;

}
