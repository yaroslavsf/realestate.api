package ch.noseryoung.realestate.domain.role;

import ch.noseryoung.realestate.core.audit.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import java.util.UUID;

@Entity
@Table(name="role")
@Getter
@Setter
@NoArgsConstructor
@Audited
@AuditOverride(forClass = Auditable.class)
public class Role extends Auditable {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "role_id", nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String name;

}
