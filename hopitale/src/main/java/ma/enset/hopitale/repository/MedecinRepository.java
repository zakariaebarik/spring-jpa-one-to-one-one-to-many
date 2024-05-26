package ma.enset.hopitale.repository;

import ma.enset.hopitale.entities.Medecin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}
