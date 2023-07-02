/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamiento;

/**
 *
 * @author anthony
 */
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JFrame;

public class Estacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

            /*JFrameVehiculo jf = new JFrameVehiculo();
        jf.setVisible(true);*/

 /*registro v1 = new registro();

        v1.setVisible(true);// hacemos visible la ventana*/
        JFrame frame = new JFrame("Estacionamiento");
        //NewUsuario newUsuario = new NewUsuario();
        //frame.add(newUsuario);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        /*accesobd ba = new accesobd("localhost", "root", "2001", "estacionamiento");
        ba.conectaBD();
        Scanner sc = new Scanner(System.in);
        int _id;
        String _cedula, _nombres, _apellidos, _correo, _telefono;
        Usuario cli = new Usuario();
        System.out.println("ingrese la cedula");
        _cedula = sc.next();
        cli.setCedula(_cedula);
        System.out.println("ingrese los nombres");
        _nombres = sc.next();
        cli.setNombre(_nombres);
        System.out.println("ingrese los apellidos");
        _apellidos = sc.next();
        cli.setApellido(_apellidos);
        System.out.println("ingrese los correo");
        _correo = sc.next();
        cli.setCorreo(_correo);
        System.out.println("ingrese los telefono");
        _telefono = sc.next();
        cli.setTelefono(_telefono);
        
        espacio es = new espacio();
        
        es.mostrarEspaciosDisponibles(_cedula);
        
        cli.eliminarCliente();

        cli.insertarCliente();*/
    }
}
