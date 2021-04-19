package ru.bellintegrator.educational_project.dictionary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.bellintegrator.educational_project.dictionary.model.Country;

import java.util.List;

public interface CountryDao extends JpaRepository<Country, Integer> {

    @Query("SELECT c.name, c.code FROM Country c")
    List<String[]> findCustom();

    Country findByCode(String code);

    boolean existsByCode(String code);
}
