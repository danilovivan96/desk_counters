package ru.mail.danilov.desktop.service.converter;

import javafx.scene.chart.XYChart;
import ru.mail.danilov.desktop.dao.models.Indications;

import java.util.List;

public class GraphsDtoConverter implements ConverterDto<Indications, XYChart.Series> {
    @Override
    public XYChart.Series toDto(Indications indications) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public List<XYChart.Series> toDtoList(List<Indications> list) {
        return null;
    }
}
