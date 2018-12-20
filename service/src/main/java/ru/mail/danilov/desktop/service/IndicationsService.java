package ru.mail.danilov.desktop.service;

import javafx.scene.chart.XYChart;
import ru.mail.danilov.desktop.service.dto.IndicationsDto;

import java.util.List;

public interface IndicationsService {
    List<IndicationsDto> getAll();

    List<XYChart.Series> getGraphs();
}
