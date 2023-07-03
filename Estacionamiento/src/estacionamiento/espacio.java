package estacionamiento;

import java.sql.*;

public class espacio {

    private int id_espacio;
    private String zona;
    accesobd bd;

    public espacio() throws Exception {
        bd = new accesobd("localhost", "root", "2001", "estacionamiento");
        bd.conectaBD();
    }

    public int getId_espacio() {
        return id_espacio;
    }

    public void setId_espacio(int id_espacio) {
        this.id_espacio = id_espacio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int incrementoEspacio() throws SQLException {
        int inc = 0;
        ResultSet rs;
        rs = bd.consultaBD("SELECT MAX(id_espacio) AS num FROM espacio;");
        if (rs.next()) {
            inc = rs.getInt("num") + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void insertaEspacio() throws SQLException {
        String cadena = "INSERT INTO espacio VALUES ('" + incrementoEspacio() + "', '" + getZona() + "')";
        bd.actualizaBD(cadena);
    }

    public ResultSet consultaTabla(String sql) throws SQLException {

        return bd.consultaBD(sql);

    }

     public ResultSet consultarid_espacio() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("SELECT * FROM espacio WHERE Id_espacio = '" + getId_espacio()+ "'");
        return rs;
    }

    
    public void consultavehiculo() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("SELECT usuario.nombre, vehiculo.placa FROM usuario, vehiculo");
        while (rs.next()) {
            System.out.print(rs.getString("nombre") + " ");
            System.out.print(rs.getString("placa") + " ");
            System.out.println();
        }
    }
}
