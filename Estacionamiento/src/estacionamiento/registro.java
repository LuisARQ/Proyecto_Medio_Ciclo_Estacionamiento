package estacionamiento;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;

public class registro extends JFrameRegistro {

    private int id_registro;
    private int id_vehiculo; 
    private int id_espacio;
    private LocalDateTime fecha_hora_entrada;
    private LocalDateTime fecha_hora_salida;
    accesobd bd;

    public registro() throws Exception {

       bd=new accesobd("localhost", "root", "2001", "estacionamiento");
        bd.conectaBD();
        //panel JFramer
        setDefaultCloseOperation(EXIT_ON_CLOSE);//SERRAR LA VENTANA
        setTitle("registro");//titulo de la ventana
        setLocationRelativeTo(null);// la pantalla en el centro
        //setBounds(100, 200, 500, 500);//tamoaño de la ventana y posisicon inicial de ventana
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getId_espacio() {
        return id_espacio;
    }

    public void setId_espacio(int id_espacio) {
        this.id_espacio = id_espacio;
    }

    public LocalDateTime getFecha_hora_entrada() {
        return fecha_hora_entrada;
    }

    public void setFecha_hora_entrada(LocalDateTime fecha_hora_entrada) {
        this.fecha_hora_entrada = fecha_hora_entrada;
    }

    public LocalDateTime getFecha_hora_salida() {
        return fecha_hora_salida;
    }

    public void setFecha_hora_salida(LocalDateTime fecha_hora_salida) {
        this.fecha_hora_salida = fecha_hora_salida;
    }


       public ResultSet consultaTabla(String sql) throws SQLException {

        return bd.consultaBD(sql);

    }

    public int incremento_Registro() throws SQLException {
        int inc = 1;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(id_registro) as num FROM registro;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void insertar_Registro() throws SQLException {
        String cadena = "Insert into registro (id_registro, id_vehiculo, id_espacio ,fecha_hora_entrada, fecha_hora_salida)values('" + incremento_Registro() + "','"+ getId_vehiculo() + "','" + getId_espacio()+ "','" + getFecha_hora_entrada() + "','" + getFecha_hora_salida() + "')";
        bd.actualizaBD(cadena);
    }  

    public void Consultar_Registro ()throws SQLException{
        ResultSet rs;        
        rs=bd.consultaBD("select * from registro");
        while (rs.next()){
            System.out.print(rs.getInt(1)+" ");
            System.out.print(rs.getString(2)+" ");
            System.out.print(rs.getString(3)+" ");
            System.out.print(rs.getString(4)+" ");
            System.out.print(rs.getString(5)+" ");
            System.out.println("");
        }
    }

}
