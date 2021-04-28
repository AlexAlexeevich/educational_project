package ru.bellintegrator.educational_project.dictionary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.bellintegrator.educational_project.dictionary.model.Country;

import java.util.List;

/**
 * DAO для работы с Country
 */
public interface CountryDao extends JpaRepository<Country, Integer> {

    /**
     * Получить список массивов названий и кодов всех объектов Country
     * @return возвращает список массивов названий и кодов всех объектов Country
     */
    @Query("SELECT c.name, c.code FROM Country c")
    List<String[]> findCustom();

    /**
     * Получить объект Country по коду
     * @param code - код страны
     * @return возвращает объект Country
     */
    Country findByCode(String code);

    /**
     * Проверить существует ли объект Country с переданным кодом
     * @param code - код страны
     */
    boolean existsByCode(String code);
}
