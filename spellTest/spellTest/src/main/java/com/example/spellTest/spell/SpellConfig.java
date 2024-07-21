package com.example.spellTest.spell;

import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpellConfig {

        private final SpellRepository spellRepository;

        public SpellConfig(SpellRepository spellRepository) {
            this.spellRepository = spellRepository;
        }

        // Method to retrieve all spells from the database
        public List<Spell> getAllSpells() {
            spellRepository.saveAll(spellRepository.findAll());
            return spellRepository.findAll();
        }

}
