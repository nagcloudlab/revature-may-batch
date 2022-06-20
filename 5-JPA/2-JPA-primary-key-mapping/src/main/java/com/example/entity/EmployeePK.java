package com.example.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeePK implements Serializable {

    private int e_id;
    private int d_id;

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePK that = (EmployeePK) o;
        return e_id == that.e_id && d_id == that.d_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(e_id, d_id);
    }
}
