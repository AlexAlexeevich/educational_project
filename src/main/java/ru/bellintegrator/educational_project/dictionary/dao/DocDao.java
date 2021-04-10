package ru.bellintegrator.educational_project.dictionary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.educational_project.dictionary.model.Doc;

import java.util.List;

@Repository
public interface DocDao extends JpaRepository<Doc, Integer> {

    @Query("SELECT d.name, d.code FROM Doc d")
    List<String[]> findCustom();

    Doc findByCode(String code);

    Doc findByName(String name);
}
