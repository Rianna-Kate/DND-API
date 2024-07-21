package com.example.spellTest.spell;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellRepository
    extends JpaRepository<Spell, Long> {

    @Query("SELECT s FROM Spell s WHERE s.name = ?1")
    Optional<Spell> findSpellbyName(String name);

    @Query("SELECT s FROM Spell s WHERE s.level = ?1")
    Optional<Spell> findSpellbyLevel(String level);

    @Query("SELECT s FROM Spell s WHERE s.classname = ?1")
    Optional<Spell> findSpellbyClassName(String classname);

}
