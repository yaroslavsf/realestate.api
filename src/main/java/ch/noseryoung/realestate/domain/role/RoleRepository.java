package ch.noseryoung.realestate.domain.role;

import ch.noseryoung.realestate.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RoleRepository  extends JpaRepository<Role, UUID> {
}