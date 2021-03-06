package com.bjpowernode.domain;

import java.io.Serializable;
import java.util.List;

public class Type implements Serializable {
    private String id;
    private String name;

    private List<Product> products;

    @Override
    public String toString() {
        return "Type{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
