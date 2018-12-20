package ru.mail.danilov.controllers.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.mail.danilov.desktop.service.IndicationsService;
import ru.mail.danilov.desktop.service.dto.IndicationsDto;
import ru.mail.danilov.desktop.service.impl.IndicationsServiceImpl;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class IndicationsTableController {
    private IndicationsService indicationsService = new IndicationsServiceImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<IndicationsDto> indicationsTable;

    @FXML
    private TableColumn<IndicationsDto, Integer> gasColumn;

    @FXML
    private TableColumn<IndicationsDto, Integer> lightColumn;

    @FXML
    private TableColumn<IndicationsDto, Integer> waterColumn;

    @FXML
    private TableColumn<IndicationsDto, LocalDate> dateColumn;

    @FXML
    void initialize() {
        gasColumn.setCellValueFactory(new PropertyValueFactory<>("gas"));
        waterColumn.setCellValueFactory(new PropertyValueFactory<>("water"));
        lightColumn.setCellValueFactory(new PropertyValueFactory<>("light"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        indicationsTable.setItems(FXCollections.observableArrayList(indicationsService.getAll()));
    }
}
