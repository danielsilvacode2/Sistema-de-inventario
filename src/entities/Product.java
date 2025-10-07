package entities;

import java.util.Objects;

public class Product {

    private String name;
    private Integer id_product;
    private Double price;


    public Product(){
    }

    public Product(String name, Integer id_product, Double price) {
        this.name = name;
        this.id_product = id_product;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id_product, product.id_product);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_product);
    }

    @Override
   public String toString(){
            return " id: (" + id_product + ") name: (" + name.toUpperCase() + "), price: (R$" + String.format("%.2f",price) +") ";
   }

}
