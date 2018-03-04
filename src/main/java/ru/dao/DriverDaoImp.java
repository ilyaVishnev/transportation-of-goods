package ru.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import ru.model.*;

@Repository
public class DriverDaoImp implements DriverDao {
    private static final Logger logger = LoggerFactory.getLogger(DriverDaoImp.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DriverEntity> listDrivers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<DriverEntity> list = session.createQuery("from DriverEntity").list();
        for (DriverEntity driver : list) {
            logger.info("Drivers: " + driver);
        }
        return list;
    }

    @Override
    public void addDriver(DriverEntity driver) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(driver);
        logger.info("Driver successfuly saved, Driver details: " + driver);
    }

    @Override
    public void removeDriver(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        DriverEntity driverEntity = (DriverEntity) session.load(DriverEntity.class, new Integer(id));
        if (driverEntity != null) {
            session.delete(driverEntity);
        }
        logger.info("Driver successfuly removed, Driver details: " + driverEntity);
    }

    @Override
    public DriverEntity getDriverById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        DriverEntity driverEntity = (DriverEntity) session.load(DriverEntity.class, new Integer(id));
        logger.info("Driver successfuly loaded, Driver details: " + driverEntity);
        return driverEntity;
    }

    @Override
    public void updateDriver(DriverEntity driver) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(driver);
        logger.info("Driver successfuly updated, Driver details: " + driver);
    }
}
