package org.generation.lojadegames.repository;

import org.generation.lojadegames.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    public List<Game> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
