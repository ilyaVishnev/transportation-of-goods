package ru.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "orders", schema = "transportionofgood")
public class OrdersEntity {
    private int idOrder;
    private Byte implementation;
    private Integer idTruck;
    private Collection<ListofdriversEntity> listofdriversByIdOrder;
    private Collection<ListofroutpointsEntity> listofroutpointsByIdOrder;
    private TrucksEntity trucksByIdTruck;

    @Id
    @Column(name = "id_order", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "implementation", nullable = true)
    public Byte getImplementation() {
        return implementation;
    }

    public void setImplementation(Byte implementation) {
        this.implementation = implementation;
    }

    @Basic
    @Column(name = "id_truck", nullable = true)
    public Integer getIdTruck() {
        return idTruck;
    }

    public void setIdTruck(Integer idTruck) {
        this.idTruck = idTruck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (idOrder != that.idOrder) return false;
        if (implementation != null ? !implementation.equals(that.implementation) : that.implementation != null)
            return false;
        if (idTruck != null ? !idTruck.equals(that.idTruck) : that.idTruck != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrder;
        result = 31 * result + (implementation != null ? implementation.hashCode() : 0);
        result = 31 * result + (idTruck != null ? idTruck.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ordersByIdOrder")
    public Collection<ListofdriversEntity> getListofdriversByIdOrder() {
        return listofdriversByIdOrder;
    }

    public void setListofdriversByIdOrder(Collection<ListofdriversEntity> listofdriversByIdOrder) {
        this.listofdriversByIdOrder = listofdriversByIdOrder;
    }

    @OneToMany(mappedBy = "ordersByIdOrder")
    public Collection<ListofroutpointsEntity> getListofroutpointsByIdOrder() {
        return listofroutpointsByIdOrder;
    }

    public void setListofroutpointsByIdOrder(Collection<ListofroutpointsEntity> listofroutpointsByIdOrder) {
        this.listofroutpointsByIdOrder = listofroutpointsByIdOrder;
    }

    @ManyToOne
    @JoinColumn(name = "id_truck", referencedColumnName = "id_truck", insertable = false, updatable = false)
    public TrucksEntity getTrucksByIdTruck() {
        return trucksByIdTruck;
    }

    public void setTrucksByIdTruck(TrucksEntity trucksByIdTruck) {
        this.trucksByIdTruck = trucksByIdTruck;
    }
}
