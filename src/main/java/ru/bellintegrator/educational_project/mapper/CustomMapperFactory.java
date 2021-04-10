package ru.bellintegrator.educational_project.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;
import ru.bellintegrator.educational_project.user.dto.UserDtoForSaveResponse;
import ru.bellintegrator.educational_project.user.dto.UserDtoForUpdate;
import ru.bellintegrator.educational_project.user.model.User;

@Service
public class CustomMapperFactory implements FactoryBean<MapperFactory> {

@Override
public MapperFactory getObject() {
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false)
            .constructorResolverStrategy(null)
            .build();
    mapperFactory.classMap(User.class, UserDtoForSaveResponse.class)
            .field("userDoc.doc.name","docName")
            .field("userDoc.docNumber","docNumber")
            .field("userDoc.docDate","docDate")
            .field("country.name","citizenshipName")
            .field("country.code","citizenshipCode")
            .byDefault().register();
    mapperFactory.classMap(UserDtoForUpdate.class, User.class)
            .field("docName", "userDoc.doc.name")
            .field("docNumber", "userDoc.docNumber")
            .field("docDate", "userDoc.docDate")
            .field("citizenshipCode", "country.code")
            .byDefault().register();
    return mapperFactory;
}

    @Override
    public Class<?> getObjectType() {
        return MapperFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
