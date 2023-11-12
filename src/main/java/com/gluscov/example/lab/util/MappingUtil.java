package com.gluscov.example.lab.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;

@Component
@NoArgsConstructor(access = AccessLevel.NONE)
public class MappingUtil {

    protected static final ModelMapper modelMapper = new ModelMapper();

    public static <T, D> D map(T object, Class<D> targetClass) {
        return modelMapper.map(object, targetClass);
    }

    public static <T, D> List<D> map(Collection<T> objects, Class<D> targetClass) {
        return objects.stream().map(o -> map(o, targetClass)).toList();
    }

    public static <T, D> void map(T source, D destination) {
        modelMapper.map(source, destination);
    }

    @PostConstruct
    public void init() {
        modelMapper.getConfiguration().setCollectionsMergeEnabled(false);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setFieldMatchingEnabled(true);
    }
}
