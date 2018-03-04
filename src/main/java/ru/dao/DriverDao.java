package ru.dao;

import java.util.List;
import ru.model.*;

public interface DriverDao {
    public List<DriverEntity> listDrivers();

    public void addDriver(DriverEntity driver);

    public void removeDriver(Integer id);

    public DriverEntity getDriverById(Integer id);

    public void updateDriver(DriverEntity driver);
}
