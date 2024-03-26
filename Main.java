import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int opcion;Personal Empleado;Personal Empleado2=new Personal();

        for (boolean band=false;band==false;){

            System.out.println("Ingrese su opcion");
            opcion=leer.nextInt();
            switch (opcion){
                case 1:
                    leer.nextLine();
                    System.out.print("Ingrese nombre:");
                    String name=leer.nextLine();
                    System.out.print("\nIngrese apellido:");
                    String apellido=leer.nextLine();
                    System.out.print("\nIngrese Fecha de nacimiento con el formato Dia/Mes/Año:");
                    String FechaDeNacimiento=leer.nextLine();
                    System.out.print("\nIngrese RFC:");
                    String RFC=leer.nextLine();
                    System.out.print("\nIngrese salario:");
                    double salario=leer.nextDouble();
                    leer.nextLine();
                    System.out.print("\nIngrese rol:");
                    String rol=leer.nextLine();
                    System.out.print("\nIngrese Fecha de ingreso con el formato Dia/Mes/Año:");
                    String FechaDeIngreso=leer.nextLine();
                    System.out.print("\nIngrese CURP:");
                    String CURP=leer.nextLine();
                    System.out.print("\nIngrese Horario:");
                    String horario=leer.nextLine();
                    Empleado=new Personal(name,apellido,FechaDeNacimiento,RFC,salario,rol,FechaDeIngreso,CURP,horario);
                    Empleado2.RegistrarEmpleado(Empleado);
                    break;
                case 2:
                    Empleado2.MostrarEmpleados();
                    break;
            }


        }

    }
}
