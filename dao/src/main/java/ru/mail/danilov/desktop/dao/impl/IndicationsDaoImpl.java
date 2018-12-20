package ru.mail.danilov.desktop.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.mail.danilov.desktop.dao.IndicationsDao;
import ru.mail.danilov.desktop.dao.models.Indications;
import ru.mail.danilov.desktop.dao.utils.HibernateUtil;

import java.util.List;

public class IndicationsDaoImpl implements IndicationsDao {

    @Override
    public List<Indications> getAll() {
        String selectAll = "from Indications as i order by i.date desc";
        Query query = getCurrentSession().createQuery(selectAll);
        return query.list();
    }

    @Override
    public Session getCurrentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
