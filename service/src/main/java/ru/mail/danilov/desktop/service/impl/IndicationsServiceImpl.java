package ru.mail.danilov.desktop.service.impl;

import javafx.scene.chart.XYChart;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.mail.danilov.desktop.dao.IndicationsDao;
import ru.mail.danilov.desktop.dao.impl.IndicationsDaoImpl;
import ru.mail.danilov.desktop.dao.models.Indications;
import ru.mail.danilov.desktop.service.IndicationsService;
import ru.mail.danilov.desktop.service.converter.ConverterDto;
import ru.mail.danilov.desktop.service.converter.impl.dto.IndicationsDtoConverter;
import ru.mail.danilov.desktop.service.dto.IndicationsDto;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IndicationsServiceImpl implements IndicationsService {

    private IndicationsDao indicationsDao = new IndicationsDaoImpl();
    private ConverterDto<Indications, IndicationsDto> indicationsDtoConverter = new IndicationsDtoConverter();

    @Override
    public List<IndicationsDto> getAll() {
        Session session = indicationsDao.getCurrentSession();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                session.beginTransaction();
            }
            List<Indications> indications = indicationsDao.getAll();
            transaction.commit();
            return indicationsDtoConverter.toDtoList(indications);
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return Collections.emptyList();
    }

    @Override
    public List<XYChart.Series> getGraphs() {
        Session session = indicationsDao.getCurrentSession();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                session.beginTransaction();
            }
            List<Indications> indications = indicationsDao.getAll();
            transaction.commit();
            return null;
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return null;
}
}
