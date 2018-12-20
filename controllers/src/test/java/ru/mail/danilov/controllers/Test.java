package ru.mail.danilov.controllers;

import ru.mail.danilov.desktop.service.IndicationsService;
import ru.mail.danilov.desktop.service.impl.IndicationsServiceImpl;

public class Test {
    public static void main(String[] args) {
        IndicationsService indicationsService = new IndicationsServiceImpl();
        indicationsService.getGraphs();
    }
}
