package ru.model;

import javax.persistence.*;

@Entity
@Table(name = "listofdrivers", schema = "transportionofgood")
public class ListofdriversEntity {
    private int idListofdrivers;
    private Integer idOrder;
    private Integer idDriver;
    private OrdersEntity ordersByIdOrder;
    private DriverEntity driverByIdDriver;

    @Id
    @Column(name = "id_listofdrivers", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdListofdrivers() {
        return idListofdrivers;
    }

    public void setIdListofdrivers(int idListofdrivers) {
        this.idListofdrivers = idListofdrivers;
    }

    @Basic
    @Column(name = "id_order", nullable = true)
    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "id_driver", nullable = true)
    public Integer getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListofdriversEntity that = (ListofdriversEntity) o;

        if (idListofdrivers != that.idListofdrivers) return false;
        if (idOrder != null ? !idOrder.equals(that.idOrder) : that.idOrder != null) return false;
        if (idDriver != null ? !idDriver.equals(that.idDriver) : that.idDriver != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idListofdrivers;
        result = 31 * result + (idOrder != null ? idOrder.hashCode() : 0);
        result = 31 * result + (idDriver != null ? idDriver.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
    public OrdersEntity getOrdersByIdOrder() {
        return ordersByIdOrder;
    }

    public void setOrdersByIdOrder(OrdersEntity ordersByIdOrder) {
        this.ordersByIdOrder = ordersByIdOrder;
    }

    @ManyToOne
    @JoinColumn(name = "id_driver", referencedColumnName = "id_driver", insertable = false, updatable = false)
    public DriverEntity getDriverByIdDriver() {
        return driverByIdDriver;
    }

    public void setDriverByIdDriver(DriverEntity driverByIdDriver) {
        this.driverByIdDriver = driverByIdDriver;
    }
}
