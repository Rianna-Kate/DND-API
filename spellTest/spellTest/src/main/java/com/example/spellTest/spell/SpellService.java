package com.example.spellTest.spell;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpellService {
    private final SpellRepository spellRepository;

    @Autowired
    public SpellService(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }

    public List<Spell> getSpells() {
        return spellRepository.findAll();
    }

    public List<Spell> getSpellsByName(String searchText) {
        return spellRepository.findAll().stream()
                .filter(student -> student.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Spell> getSpellsByLevel(String searchText) {
        return spellRepository.findAll().stream()
                .filter(student -> student.getLevel() == Integer.valueOf(searchText))
                .collect(Collectors.toList());
    }

    public List<Spell> getSpellsByClass(String searchText) {
        return spellRepository.findAll().stream()
        .filter(student -> student.getclassname().toLowerCase().contains(searchText.toLowerCase()))
        .collect(Collectors.toList());
    }

    public void addNewSpell(Spell spell) {
        Optional<Spell> spellOptional = spellRepository
            .findSpellbyName(spell.getName());
        if (spellOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        spellRepository.save(spell);
    }

    public void deleteSpell(Long spellId) {
        boolean exists = spellRepository.existsById(spellId);
        if (!exists) {
            throw new IllegalStateException(
                "spell w/ id" + spellId + " does not exist"
            );
        }
        spellRepository.deleteById(spellId);
    }
}
