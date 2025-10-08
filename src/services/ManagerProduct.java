package services;

import connection.DataBaseConnection;
import entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ManagerProduct {


    public static List<Product> listProduct() {

        String sql = "SELECT * FROM product.tableproduct";
        List<Product> list = new ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection()) {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id_product = rs.getInt("Id_product");
                String name = rs.getString("Name");
                Double price = rs.getDouble("Price");

                list.add(new Product(name, id_product, price));

            }

        } catch (SQLException e) {
            System.out.println("error -> " + e.getMessage());
        }

        return list;

    }

    public static List<Product> updateProduct(List<Product> list) {

        String sql = "update tableproduct set name = ? , price = ? where id_product = ?";

        try (Connection conn = DataBaseConnection.getConnection()) {

            PreparedStatement st = conn.prepareStatement(sql);

            for (Product p : list) {

                st.setString(1, p.getName());
                st.setDouble(2, p.getPrice());
                st.setInt(3, p.getId_product());

                st.executeUpdate();

            }

            System.out.println("(updated database)");

        } catch (SQLException e) {
            System.out.println("error -> " + e.getMessage());
        }

        return list;

    }

    public static void addPorduct(String name, Double price) {

        String sql = "insert into tableproduct (name,price) values (?,?)";

        try (Connection conn = DataBaseConnection.getConnection()) {

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, name);
            st.setDouble(2, price);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("error :" + e.getMessage());
        }

    }

    public static void removeProduto(int id) {

        String sql = "delete from tableproduct where id_product = ?";

        try (Connection conn = DataBaseConnection.getConnection()) {

            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("error :" + e.getMessage());
        }

    }

}
