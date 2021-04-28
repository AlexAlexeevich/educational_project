package ru.bellintegrator.educational_project.dictionary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.educational_project.dictionary.model.Doc;

import java.util.List;

/**
 * DAO для работы с Doc
 */
@Repository
public interface DocDao extends JpaRepository<Doc, Integer> {

    /**
     * Получить список массивов названий и кодов всех объектов Doc
     * @return возвращает список массивов названий и кодов всех объектов Doc
     */
    @Query("SELECT d.name, d.code FROM Doc d")
    List<String[]> findCustom();

    /**
     * Получить объект Doc по коду
     * @param code - код документа
     * @return возвращает объект Doc
     */
    Doc findByCode(String code);

    /**
     * Получить объект Doc по названию
     * @param name - название документа
     * @return возвращает объект Doc
     */
    Doc findByName(String name);

    /**
     * Проверить существует ли объект Doc с переданным названием
     * @param name - название документа
     */
    boolean existsByName(String name);

    /**
     * Проверить существует ли объект Doc с переданным кодом
     * @param code - название документа
     */
    boolean existsByCode(String code);
}
