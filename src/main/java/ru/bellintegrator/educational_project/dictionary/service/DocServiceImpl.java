package ru.bellintegrator.educational_project.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.educational_project.dictionary.dao.DocDao;
import ru.bellintegrator.educational_project.dictionary.dto.DocDtoForListResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocServiceImpl implements DocService {

    private final DocDao docDao;

    @Autowired
    public DocServiceImpl(DocDao docDao) {
        this.docDao = docDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocDtoForListResponse> getDocs() {
        List<String[]> listStrings = docDao.findCustom();
        List<DocDtoForListResponse> listDto = new ArrayList<>();
        listStrings.forEach(l -> listDto.add(new DocDtoForListResponse(l[0], l[1])));
        return listDto;
    }
}
