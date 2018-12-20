package ru.mail.danilov.desktop.dao;

import org.hibernate.Session;
import ru.mail.danilov.desktop.dao.models.Indications;

import java.util.List;

public interface IndicationsDao {

    List<Indications> getAll();

    Session getCurrentSession();
}
