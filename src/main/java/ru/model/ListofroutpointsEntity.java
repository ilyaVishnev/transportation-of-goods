package ru.model;

import javax.persistence.*;

@Entity
@Table(name = "listofroutpoints", schema = "transportionofgood")
public class ListofroutpointsEntity {
    private int idListofroutpoints;
    private Integer idOrder;
    private String city;
    private Integer idGood;
    private Byte statusofgood;
    private OrdersEntity ordersByIdOrder;
    private GoodsEntity goodsByIdGood;

    @Id
    @Column(name = "id_listofroutpoints", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdListofroutpoints() {
        return idListofroutpoints;
    }

    public void setIdListofroutpoints(int idListofroutpoints) {
        this.idListofroutpoints = idListofroutpoints;
    }

    @Basic
    @Column(name = "id_order", nullable = false)
    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
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
    @Column(name = "id_good", nullable = true)
    public Integer getIdGood() {
        return idGood;
    }

    public void setIdGood(Integer idGood) {
        this.idGood = idGood;
    }

    @Basic
    @Column(name = "statusofgood", nullable = true)
    public Byte getStatusofgood() {
        return statusofgood;
    }

    public void setStatusofgood(Byte statusofgood) {
        this.statusofgood = statusofgood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListofroutpointsEntity that = (ListofroutpointsEntity) o;

        if (idListofroutpoints != that.idListofroutpoints) return false;
        if (idOrder != null ? !idOrder.equals(that.idOrder) : that.idOrder != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (idGood != null ? !idGood.equals(that.idGood) : that.idGood != null) return false;
        if (statusofgood != null ? !statusofgood.equals(that.statusofgood) : that.statusofgood != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idListofroutpoints;
        result = 31 * result + (idOrder != null ? idOrder.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (idGood != null ? idGood.hashCode() : 0);
        result = 31 * result + (statusofgood != null ? statusofgood.hashCode() : 0);
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
    @JoinColumn(name = "id_good", referencedColumnName = "id_good", insertable = false, updatable = false)
    public GoodsEntity getGoodsByIdGood() {
        return goodsByIdGood;
    }

    public void setGoodsByIdGood(GoodsEntity goodsByIdGood) {
        this.goodsByIdGood = goodsByIdGood;
    }
}
