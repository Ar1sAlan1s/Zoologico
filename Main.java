import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String Password = "Hola";
        int opcion;
        Personal Empleado;
        Personal Empleado2 = new Personal();
        System.out.print("Ingrese la contraseña:");
        String pass = leer.nextLine();
        while (!Password.equals(pass)) {
            System.out.println("Intente de nuevo");
            pass = leer.nextLine();
        }
        for (boolean band = false; band == false; ) {

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
            }
        }
    }
}
