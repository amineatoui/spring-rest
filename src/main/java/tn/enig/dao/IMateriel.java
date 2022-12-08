package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.enig.model.Materiel;

@Repository
public interface IMateriel extends JpaRepository<Materiel, Integer> {
	
           @Query("select m from Materiel m where m.dep.id=:id")
           List<Materiel> getAllMatByDepId(@Param("id") int id);

}
