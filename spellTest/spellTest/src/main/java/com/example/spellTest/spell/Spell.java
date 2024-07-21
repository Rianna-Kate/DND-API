package com.example.spellTest.spell;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Spell {
    @Id
    @SequenceGenerator(
        name = "spell_sequence",
        sequenceName =  "spell_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "spell_sequence"
    )
    private Long id;
    private String classname;
    private int level;
    private String name;
    private String school;
    private String casttime;
    private String range;
    private String duration;
    private String components;
    private String description;

    public Spell() {
    }

    public Spell(Long id,
    String classname,
    int level,
    String name,
    String school,
    String casttime,
    String range,
    String duration,
    String components,
    String description) {
        this.id = id;
        this.classname = classname;
        this.level = level;
        this.name = name;
        this.school = school;
        this.casttime = casttime;
        this.range = range;
        this.duration = duration;
        this.components = components;
        this.description = description;
    }

    public Spell(String classname, int level, String name, String school, String casttime, String range, String duration, String components, String description) {
        this.classname = classname;
        this.level = level;
        this.name = name;
        this.school = school;
        this.casttime = casttime;
        this.range = range;
        this.duration = duration;
        this.components = components;
        this.description = description;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getclassname() {
        return classname;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public String getcasttime() {
        return casttime;
    }

    public String getRange() {
        return range;
    }

    public String getComponents() {
        return components;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }


    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setclassname(String classname) {
        this.classname = classname;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setcasttime(String casttime) {
        this.casttime = casttime;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Spell {" +
        "id=" + id +
        ", classname=" + classname +
        ", level" + level +
        ", name=" + name + '\'' +
        ", school=" + school + '\'' +
        ", casttime" + casttime +
        ", duration" + duration +
        ", range" + range +
        ", components" + components +
        ", description" + description;
    }
}
