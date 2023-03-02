package ch.noseryoung.realestate.core.audit;

import org.hibernate.annotations.Comment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class SecurityAuditorAware implements AuditorAware<String> {

    private static final String SYSTEM = "System";

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(SYSTEM);
    }
}