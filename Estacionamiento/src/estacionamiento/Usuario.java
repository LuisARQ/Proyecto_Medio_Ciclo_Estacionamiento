
package estacionamiento;

import java.sql.*;

public class Usuario {

    private int id_usuario;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    accesobd bd;

    public Usuario() throws Exception {
        bd = new accesobd("localhost", "root", "123ch123r", "estacionamiento");
        bd.conectaBD();
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public int incrementoUsuario() throws SQLException {
        int inc = 0;
        ResultSet rs;
        rs = bd.consultaBD("SELECT MAX(id_usuario) AS num FROM usuario;");
        if (rs.next()) {
            inc = rs.getInt("num") + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void insertarCliente() throws SQLException {
        String cadena = "INSERT INTO usuario VALUES ('" + incrementoUsuario() + "', '" + getCedula() + "', '" + getNombre() + "', '" + getApellido() + "', '" + getCorreo() + "', '" + getTelefono() + "')";
        bd.actualizaBD(cadena);
    }

    public void actualizarCliente() throws SQLException {
        String cadena = "UPDATE usuario SET nombre = '" + nombre + "', apellido = '" + apellido + "', correo = '" + correo + "', telefono = '" + telefono + "' WHERE id_usuario = " + id_usuario;
        bd.actualizaBD(cadena);
    }

    public ResultSet consultarIDCliente() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("SELECT * FROM usuario WHERE ID_USUARIO = '" + getId_usuario() + "'");
        return rs;
    }

    public void eliminarCliente() throws SQLException {
        String cadena = "DELETE FROM usuario WHERE id_usuario = " + id_usuario;
        bd.actualizaBD(cadena);
    }

    public ResultSet consultarClienteslogger() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("SELECT * FROM usuario WHERE nombre = '" + getNombre() + "' AND cedula = '" + getCedula() + "'");
        return rs;
    }

    public ResultSet consultaTabla(String sql) throws SQLException {

        return bd.consultaBD(sql);

    }

    public void consultarUsuario() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("SELECT * FROM usuario");
        while (rs.next()) {
            System.out.print(rs.getInt("id_usuario") + " ");
            System.out.print(rs.getString("cedula") + " ");
            System.out.print(rs.getString("nombre") + " ");
            System.out.print(rs.getString("apellido") + " ");
            System.out.print(rs.getString("correo") + " ");
            System.out.print(rs.getString("telefono") + " ");
            System.out.println();
        }
    }
}
