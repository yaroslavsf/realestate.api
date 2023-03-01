package ch.noseryoung.realestate.domain.users;

import ch.noseryoung.realestate.domain.realestate.RealEstate;
import ch.noseryoung.realestate.domain.role.Role;
import ch.noseryoung.realestate.domain.userrealestate.UserRealEstate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "user_id", nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id",  nullable=false)
    private Role role;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<RealEstate> realEstates;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<UserRealEstate> userRealEstates;
}
