
package estacionamiento;

import java.sql.*;

public class accesobd {

    public final String host;
    private final String user;
    private final String passwd;
    private final String bd;
    //******par barir o cerrar la conexio

    private Connection conexion;

    public accesobd(String host, String user, String passwd, String bd) {
        this.host = host;
        this.user = user;
        this.passwd = passwd;
        this.bd = bd;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getBd() {
        return bd;
    }

    public void conectaBD() throws Exception {
        try {
            Driver driver = (Driver)//definir driver
                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();//Instancia
            String cadena = "jdbc:mysql://" + getHost() + "/" + getBd();
            conexion = DriverManager.getConnection(cadena, getUser(), getPasswd());
            System.out.print("Se ha realizado la conexion con la BD....COMMIT");
            System.out.println(" ");

        } catch (SQLException e) {
            System.out.println("Error de Conexion BD....RollBack" + e.toString());

        }
    }

    public void actualizaBD(String sql) throws SQLException {
        try {
            Statement stm = conexion.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Transaccion exitosa....COMMIT");
        } catch (SQLException e) {
            System.out.println("Error en la transaccion....Rollbalck" + e.toString());
        }
    }

    public ResultSet consultaBD(String sql) throws SQLException {
        ResultSet cursor;
        Statement stm = conexion.createStatement();
        cursor = stm.executeQuery(sql);
        return cursor;
    }

    public void cerrarBD() throws SQLException {
        conexion.close();
    }

}

