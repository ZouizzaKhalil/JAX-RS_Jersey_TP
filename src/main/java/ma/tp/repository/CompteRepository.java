package ma.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.tp.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

}
