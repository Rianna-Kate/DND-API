package com.example.spellTest.spell;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/spell")
public class SpellController {

	private final SpellService spellService;

	@Autowired
	public SpellController(SpellService spellService) {
		this.spellService = spellService;
	}

    @GetMapping
	    public List<Spell> getSpells(
			@RequestParam(required = false) String name,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String classname) {
        if (name != null) {
            return spellService.getSpellsByName(name);
        }
		else if (level != null) {
			return spellService.getSpellsByLevel(level);
		}
		else if (classname != null) {
			return spellService.getSpellsByClass(classname);
		}
        else {
            return spellService.getSpells();
        }
	}
		
		@PostMapping
		public void registerNewSpell(@RequestBody Spell spell) {
			spellService.addNewSpell(spell);
		}

		@DeleteMapping(path = {"spellId"})
			public void deleteSpell(@PathVariable("spellId") Long spellId) {
				spellService.deleteSpell(spellId);
			}
		
}
