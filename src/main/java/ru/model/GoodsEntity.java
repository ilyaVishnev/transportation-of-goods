package ru.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "goods", schema = "transportionofgood")
public class GoodsEntity {
    private int idGood;
    private String nameofgood;
    private Integer weight;
    private String statusOfGood;
    private Collection<ListofroutpointsEntity> listofroutpointsByIdGood;

    @Id
    @Column(name = "id_good", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdGood() {
        return idGood;
    }

    public void setIdGood(int idGood) {
        this.idGood = idGood;
    }

    @Basic
    @Column(name = "nameofgood", nullable = true, length = 200)
    public String getNameofgood() {
        return nameofgood;
    }

    public void setNameofgood(String nameofgood) {
        this.nameofgood = nameofgood;
    }

    @Basic
    @Column(name = "weight", nullable = true)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "status_of_good", nullable = true, length = 200)
    public String getStatusOfGood() {
        return statusOfGood;
    }

    public void setStatusOfGood(String statusOfGood) {
        this.statusOfGood = statusOfGood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsEntity that = (GoodsEntity) o;

        if (idGood != that.idGood) return false;
        if (nameofgood != null ? !nameofgood.equals(that.nameofgood) : that.nameofgood != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (statusOfGood != null ? !statusOfGood.equals(that.statusOfGood) : that.statusOfGood != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idGood;
        result = 31 * result + (nameofgood != null ? nameofgood.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (statusOfGood != null ? statusOfGood.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "goodsByIdGood")
    public Collection<ListofroutpointsEntity> getListofroutpointsByIdGood() {
        return listofroutpointsByIdGood;
    }

    public void setListofroutpointsByIdGood(Collection<ListofroutpointsEntity> listofroutpointsByIdGood) {
        this.listofroutpointsByIdGood = listofroutpointsByIdGood;
    }
}
