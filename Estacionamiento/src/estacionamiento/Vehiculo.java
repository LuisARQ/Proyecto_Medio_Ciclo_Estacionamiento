/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamiento;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Vehiculo {

    private int id_vehiculo;
    private int id_usuario;
    private String marca;
    private String modelo;
    private String placa;
    private accesobd bd;

    public Vehiculo() throws Exception {
        bd = new accesobd("localhost", "root", "123ch123r", "estacionamiento");
        bd.conectaBD();
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setBd(accesobd bd) {
        this.bd = bd;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public accesobd getBd() {
        return bd;
    }

    public int incrementovehiculo() throws SQLException {
        int inc = 0;
        ResultSet rs;
        rs = bd.consultaBD("SELECT MAX(id_vehiculo) AS num FROM vehiculo;");
        if (rs.next()) {
            inc = rs.getInt("num") + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void insertarVehiculo(Vehiculo vehiculo) throws SQLException {
        int id = vehiculo.incrementovehiculo();
        String cadena = "INSERT INTO vehiculo (id_vehiculo, id_usuario, marca, modelo, placa) VALUES (" + id + ", " + vehiculo.getId_usuario() + ", '" + vehiculo.getMarca() + "', '" + vehiculo.getModelo() + "', '" + vehiculo.getPlaca() + "')";
        bd.actualizaBD(cadena);
    }

    public void actualizarvehiculo(Vehiculo vehiculo) throws SQLException {
        String cadena = "UPDATE vehiculo SET marca = '" + vehiculo.getMarca() + "', modelo = '" + vehiculo.getModelo() + "', placa = '" + vehiculo.getPlaca() + "' WHERE id_vehiculo = " + vehiculo.getId_vehiculo();
        bd.actualizaBD(cadena);
    }

    public void eliminarvehiculo(int id_Vehiculo) throws SQLException {
        String cadena = "DELETE FROM vehiculo WHERE id_vehiculo = " + id_Vehiculo;
        bd.actualizaBD(cadena);
    }

    public ResultSet consultaTabla(String sql) throws SQLException {

        return bd.consultaBD(sql);

    }

    public ResultSet consultarid_vehiculo() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("SELECT * FROM vehiculo WHERE Id_vehiculo = '" + getId_vehiculo() + "'");
        return rs;
    }

    public void consultavehiculo() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("SELECT * FROM vehiculo");
        while (rs.next()) {
            System.out.print(rs.getInt("id_vehiculo") + " ");
            System.out.print(rs.getInt("id_usuario") + " ");
            System.out.print(rs.getString("marca") + " ");
            System.out.print(rs.getString("modelo") + " ");
            System.out.print(rs.getString("placa") + " ");
            System.out.println();
        }
    }
}
