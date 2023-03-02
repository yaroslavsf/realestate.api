package ch.noseryoung.realestate.domain.realestate;

import ch.noseryoung.realestate.core.audit.Auditable;
import ch.noseryoung.realestate.domain.userrealestate.UserRealEstate;
import ch.noseryoung.realestate.domain.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="realestate")
@Getter
@Setter
@NoArgsConstructor
public class RealEstate extends Auditable {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "realestate_id", nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String square;
    @Column(nullable = false)
    private String canton;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(
            mappedBy = "realEstate",
            cascade = CascadeType.ALL
    )
    private List<UserRealEstate> userRealEstates;




}
