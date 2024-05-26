package ma.enset.hopitale.repository;

import ma.enset.hopitale.entities.Patient;import ma.enset.hopitale.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}
