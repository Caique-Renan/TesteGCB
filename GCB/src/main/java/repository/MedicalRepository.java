package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.MedicalEntity;

@Repository
public interface MedicalRepository extends JpaRepository<MedicalEntity, Long> {

}
