package ru.bellintegrator.educational_project.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.educational_project.dictionary.dao.CountryDao;
import ru.bellintegrator.educational_project.dictionary.dto.CountryDtoForListResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class CountryServiceImpl implements CountryService{

    /**
     * Поле countryDao
     */
    private final CountryDao countryDao;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param countryDao - объект countryDao
     */
    @Autowired
    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<CountryDtoForListResponse> getCountries() {
        List<String[]> listStrings = countryDao.findCustom();
        List<CountryDtoForListResponse> listDto = new ArrayList<>();
        listStrings.forEach(l -> listDto.add(new CountryDtoForListResponse(l[0], l[1])));
        return listDto;
    }
}
