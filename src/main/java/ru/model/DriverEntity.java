package ru.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "driver", schema = "transportionofgood")
public class DriverEntity {
    private String drivername;
    private String surname;
    private int idDriver;
    private Integer countofhoursatmonth;
    private String driverStatus;
    private String city;
    private Collection<ListofdriversEntity> listofdriversByIdDriver;

    @Basic
    @Column(name = "drivername", nullable = true, length = 200)
    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    @Basic
    @Column(name = "surname", nullable = true, length = 200)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Id
    @Column(name = "id_driver", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    @Basic
    @Column(name = "countofhoursatmonth", nullable = true)
    public Integer getCountofhoursatmonth() {
        return countofhoursatmonth;
    }

    public void setCountofhoursatmonth(Integer countofhoursatmonth) {
        this.countofhoursatmonth = countofhoursatmonth;
    }

    @Basic
    @Column(name = "driver_status", nullable = true, length = 200)
    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 200)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverEntity that = (DriverEntity) o;

        if (idDriver != that.idDriver) return false;
        if (drivername != null ? !drivername.equals(that.drivername) : that.drivername != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (countofhoursatmonth != null ? !countofhoursatmonth.equals(that.countofhoursatmonth) : that.countofhoursatmonth != null)
            return false;
        if (driverStatus != null ? !driverStatus.equals(that.driverStatus) : that.driverStatus != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = drivername != null ? drivername.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + idDriver;
        result = 31 * result + (countofhoursatmonth != null ? countofhoursatmonth.hashCode() : 0);
        result = 31 * result + (driverStatus != null ? driverStatus.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "driverByIdDriver")
    public Collection<ListofdriversEntity> getListofdriversByIdDriver() {
        return listofdriversByIdDriver;
    }

    public void setListofdriversByIdDriver(Collection<ListofdriversEntity> listofdriversByIdDriver) {
        this.listofdriversByIdDriver = listofdriversByIdDriver;
    }
}
