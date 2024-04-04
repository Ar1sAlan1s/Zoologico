import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        control control=new control();
        String Password = "Hola";
        int opcion;
        Personal Empleado2 = new Personal();
        Visitantes visitantes=new Visitantes(" ", "" , 0, "","");
        System.out.print("Ingrese la contraseña:");
        String pass = leer.nextLine();
        while (!Password.equals(pass)) {
            System.out.println("Intente de nuevo");
            pass = leer.nextLine();
        }
        for (boolean band = false; band == false; ) {
            System.out.println("opciones");
            System.out.println("1. Registrar Empleados");
            System.out.println("2. Mostrar Empleados");
            System.out.println("3. Quitar Empleados");
            System.out.println("4. Registar Visitantes");
            System.out.println("5. Mostrar lista de Visitantes");
            System.out.println("6. Eliminar Visitante");
            System.out.println("7. Mostrar Visitante en especifico");
            System.out.println("8. Registrar Visita");
            System.out.println("9. Mostrar todas las visitas");
            System.out.println("10. Mostrar la informacion detallada de una visita en especifico");
            System.out.println("11. Registrar Mantenimiento");
            System.out.println("12. Mostrar Mantenimientos");
            System.out.println("13. Mostrar Informacion de un Mantenimieno en especifico");
            System.out.println("14. salir del programa");
            System.out.println("Ingrese su opcion");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    Empleado2.RegistrarEmpleado();
                    break;
                case 2:
                    Empleado2.MostrarEmpleados();
                    break;
                case 3:
                    Empleado2.QuitarEmpleados();
                    break;
                case 4:
                    leer.nextLine();
                    System.out.println("Ingresar nombre del Visitante: ");
                    String nombre = leer.nextLine();
                    System.out.println("Ingresar apellidos del Visitante:  ");
                    String apellidos = leer.nextLine();
                    System.out.println("Ingresa su año de nacimienro: ");
                    int fechaNacimiento = leer.nextInt();
                    leer.nextLine();
                    System.out.println("Ingresa su CURP: ");
                    String curp = leer.nextLine();
                    System.out.println("Ingresar Fecha de Registro: ");
                    String fechaRegistro = leer.nextLine();
                    visitantes = new Visitantes(nombre, apellidos, fechaNacimiento, curp, fechaRegistro);
                    visitantes.añadirVisitante(visitantes);
                    break;
                case 5:
                    visitantes.mostrarVisitantes();
                    break;
                case 6:
                    visitantes.eliminarVisitante()
                    break;
                case 7: 
                    visitantes.getDatosVisitante();
                    break;
                case 8: 
                    control.RegistarVisitas();
                    break;
                case 9: 
                    control.mostrarTodasLasVisitas();
                    break;
                case 10:
                    leer.nextLine();
                    System.out.println("ingrese la fecha de la visita con la forma: Dia/Mes/año");
                    fechaRegistro= leer.nextLine();
                    control.imprimirInformacionVisita(fechaRegistro);
                    break;
                case 11:
                    control.registrarMantenimiento();
                    break;
                case 12: control.imprimirMantenimientos();
                    break;
                case 13:
                    leer.nextLine();
                    System.out.println("ingrese la fecha que se realizo el mantenimiento");
                    String fecha=leer.nextLine();
                    control.consultarMantenimientoPorFecha(fecha);
                    break;
                case 14: 
                    System.out.println("----Saliendo del Sistema.----");
                    band=true;
                    break;
            }
        }
    }
}
