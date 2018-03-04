package ru.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;

@Entity
@Table(name = "trucks", schema = "transportionofgood")
public class TrucksEntity {
    private int idTruck;
    private Time shift;
    private Integer capacity;
    private Byte state;
    private String city;
    private Byte truckStatus;
    private Collection<OrdersEntity> ordersByIdTruck;

    @Id
    @Column(name = "id_truck", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdTruck() {
        return idTruck;
    }

    public void setIdTruck(int idTruck) {
        this.idTruck = idTruck;
    }

    @Basic
    @Column(name = "shift", nullable = true)
    public Time getShift() {
        return shift;
    }

    public void setShift(Time shift) {
        this.shift = shift;
    }

    @Basic
    @Column(name = "capacity", nullable = true)
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "state", nullable = true)
    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 200)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "truck_status", nullable = true)
    public Byte getTruckStatus() {
        return truckStatus;
    }

    public void setTruckStatus(Byte truckStatus) {
        this.truckStatus = truckStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrucksEntity that = (TrucksEntity) o;

        if (idTruck != that.idTruck) return false;
        if (shift != null ? !shift.equals(that.shift) : that.shift != null) return false;
        if (capacity != null ? !capacity.equals(that.capacity) : that.capacity != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (truckStatus != null ? !truckStatus.equals(that.truckStatus) : that.truckStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTruck;
        result = 31 * result + (shift != null ? shift.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (truckStatus != null ? truckStatus.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "trucksByIdTruck")
    public Collection<OrdersEntity> getOrdersByIdTruck() {
        return ordersByIdTruck;
    }

    public void setOrdersByIdTruck(Collection<OrdersEntity> ordersByIdTruck) {
        this.ordersByIdTruck = ordersByIdTruck;
    }
}
