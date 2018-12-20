package ru.mail.danilov.desktop.service.converter;

import java.util.Collections;
import java.util.List;

public interface ConverterDto<T, V> {
    V toDto(T t);

    default List<V> toDtoList(List<T> list) {
        return Collections.emptyList();
    }

}
