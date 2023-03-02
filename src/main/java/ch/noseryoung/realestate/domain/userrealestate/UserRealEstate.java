package ch.noseryoung.realestate.domain.userrealestate;

import ch.noseryoung.realestate.core.audit.Auditable;
import ch.noseryoung.realestate.domain.enums.RealEstateStatus;
import ch.noseryoung.realestate.domain.realestate.RealEstate;
import ch.noseryoung.realestate.domain.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import java.util.UUID;

@Entity
@Table(name="userrealestate")
@Getter
@Setter
@NoArgsConstructor
@Audited
@AuditOverride(forClass = Auditable.class)
public class UserRealEstate extends Auditable {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "userrealestate_id", nullable = false)
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RealEstateStatus status = RealEstateStatus.PENDING;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="realestate_id")
    private RealEstate realEstate;
}
