import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int opcion;Personal Empleado;Personal Empleado2=new Personal();
        Visitantes visitante;
        Visitantes visitantes = new Visitantes(" ", " ", " ", " ", " ");
        for (boolean band=false;band==false;){

            System.out.println("Ingrese su opcion");
            System.out.println("3. Añadir Visitante o aumentar sus visitas con su CURP.");
            System.out.println("4. Mostrar a todos los visitantes registrados en el sistema.");
            System.out.println("5. Mostrar a un solo visitante.");
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
                case 3: 
                leer.nextLine();
                System.out.println("¿Es su primera visita?(Si o No): ");
                String resp = leer.nextLine();
                if(resp.equalsIgnoreCase("si")){
                System.out.println("Ingresar nombre del Visitante: ");
                String nombre = leer.nextLine();
                System.out.println("Ingresar apellidos del Visitante:  ");
                String apellidos = leer.nextLine();
                System.out.println("Ingresa su fecha de nacimiento: ");      
                String fechaNacimiento = leer.nextLine();
                System.out.println("Ingresa su CURP: ");
                String curp = leer.nextLine();
                System.out.println("Ingresar Fecha de Registro: ");
                String fechaRegistro = leer.nextLine();
                visitante = new Visitantes(nombre, apellidos, fechaNacimiento, curp, fechaRegistro);
                visitantes.añadirVisitante(visitante);
                }
                else{ 
                    visitantes.aumentarVisitas();   
                }
                break;
                case 4: 
                    visitantes.mostrarVisitantes();
                    break;
                case 5: 
                    visitantes.getDatosVisitante();
                    break;
            }
        }

    }
}
