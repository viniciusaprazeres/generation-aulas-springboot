package org.generation.lojadegames.repository;

import org.generation.lojadegames.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

    public List<Genero> findAllByGeneroContainingIgnoreCase(@Param("genero") String genero);

}
