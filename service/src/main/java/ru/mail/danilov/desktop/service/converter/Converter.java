package ru.mail.danilov.desktop.service.converter;

import java.util.Collections;
import java.util.List;

public interface Converter<T, V> {

    T toEntity(V v);

    default List<T> toEntityList(List<V> list) {
        return Collections.emptyList();
    }
}
