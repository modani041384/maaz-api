package com.maaz.api.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.lang.reflect.Type;

/**
 * @author modani
 * @param <T>
 * @param <U>
 */
public abstract class AbstractMapper<T, U> {

    private final ModelMapper mapper;
    private Class<?> tClazz;
    private Class<?> uClazz;

    /**
     * Constructor AbstractMapper
     */
    public AbstractMapper() {
        mapper = new ModelMapper();
        //mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
    }

    /**
     * Constructor AbstractMapper
     * @param tClazz
     * @param uClazz
     */
    public AbstractMapper(Class<?> tClazz, Class<?> uClazz) {
        mapper = new ModelMapper();
        //mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        this.tClazz = tClazz;
        this.uClazz = uClazz;
    }

    /**
     * Convert DTO to entity
     * @param u
     * @return
     */
    public T convertDTOToEntity(U u) {
        return convertDTOToEntity(u, tClazz);
    }

    /**
     * Convert DTO to entity
     * @param u
     * @param tClazz
     * @return
     */
    private T convertDTOToEntity(U u, Class<?> tClazz) {
        if (null == u) return null;
        return mapper.map(u, (Type) tClazz);
    };

    /**
     * Convert entity to DTO
     * @param t
     * @return
     */
    public U convertEntityToDTO(T t) {
        return convertEntityToDTO(t, uClazz);
    }

    /**
     * Convert entity to DTO
     * @param t
     * @param uClazz
     * @return
     */
    private U convertEntityToDTO(T t, Class<?> uClazz) {
        if (null == t) return null;
        return mapper.map(t, (Type) uClazz);
    }

    //end
}