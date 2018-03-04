package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dao.*;
import ru.model.*;

import java.util.List;

@Service
public class DriverServiceImp implements DriverService {
    @Autowired
    private DriverDao driverDao;

    @Override
    @Transactional
    public List<DriverEntity> driverList() {
        return this.driverDao.listDrivers();
    }

    @Override
    @Transactional
    public void addDriver(DriverEntity driver) {
        this.driverDao.addDriver(driver);
    }

    @Override
    @Transactional
    public void removeDriver(Integer id) {
        this.driverDao.removeDriver(id);
    }

    @Override
    @Transactional
    public DriverEntity getDriverById(Integer id) {
        return this.driverDao.getDriverById(id);
    }

    @Override
    @Transactional
    public void updateDriver(DriverEntity driver) {
        this.driverDao.updateDriver(driver);
    }
    @Transactional
    public void setDriverDao(DriverDao driverDao) {
        this.driverDao = driverDao;
    }
}
