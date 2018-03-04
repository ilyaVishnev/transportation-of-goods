package ru.service;

import ru.model.DriverEntity;

import java.util.List;

public interface DriverService {
    public List<DriverEntity> driverList();

    public void addDriver(DriverEntity driver);

    public void removeDriver(Integer id);

    public DriverEntity getDriverById(Integer id);

    public void updateDriver(DriverEntity driver);
}
