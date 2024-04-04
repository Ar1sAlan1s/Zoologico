import java.util.ArrayList;
import java.util.Scanner;
public class Personal {

    ArrayList<Personal> Personal =new ArrayList<>();
    Scanner leer=new Scanner(System.in);
    private String name;
    private String apellido;
    private  String FechaDeNacimiento;
    private  String RFC;
    private  double Salario;
    private  String rol;
    private String FechaDeIngreso;
    private String CURP;
    private String horario;
    public Personal(){

    }
    public Personal(String name,String apellido,String FechaDeNacimiento,String RFC,double Salario,String rol,String FechaDeIngreso,String CURP,String horario){
        this.name=name;
        this.apellido=apellido;
        this.FechaDeNacimiento=FechaDeNacimiento;
        this.RFC=RFC;
        this.Salario=Salario;
        this.rol=rol;
        this.FechaDeIngreso=FechaDeIngreso;
        this.CURP=CURP;
        this.horario=horario;


    }


    public String getName() {
        return name;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public String getRFC() {
        return RFC;
    }

    public double getSalario() {
        return Salario;
    }

    public String getRol() {
        return rol;
    }

    public String getFechaDeIngreso() {
        return FechaDeIngreso;
    }

    public String getCURP() {
        return CURP;
    }

    public String getHorario() {
        return horario;
    }

    public void RegistrarEmpleado(){
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
        boolean band=false;
        while (!band){
            System.out.print("\nIngrese rol:");
            String rol=leer.nextLine().toUpperCase();
            if (rol.equals("VETERINARIO") || rol.equals("GUIA") || rol.equals("MANTENIMIENTO") || rol.equals("ADMINISTRACION")) {
                System.out.print("\nIngrese Fecha de ingreso con el formato Dia/Mes/Año:");
                String FechaDeIngreso = leer.nextLine();
                System.out.print("\nIngrese CURP:");
                String CURP = leer.nextLine().toUpperCase();
                System.out.print("\nIngrese Horario:");
                String horario = leer.nextLine();
                Personal empleado = new Personal(name, apellido, FechaDeNacimiento, RFC, salario, rol, FechaDeIngreso, CURP, horario);
                Personal.add(empleado);
                band=true;
            } else {
                System.out.println("ingrese un rol valido");
            }
        }

    }

    public void MostrarEmpleados(){
        for (int i = 0; i < Personal.size(); i++){
            System.out.printf("Su nombre;%s\nSu Apellido:%s\nSu Fecha de Nacimiento;%s\nSu RFC:%s\nSu salario:%.2f\nSu rol:%s\nSu Fecha de ingreso;%s\nSu CURP:%s\nSu Horario;%s\n############################\n",Personal.get(i).getName(),Personal.get(i).getApellido(),Personal.get(i).getFechaDeNacimiento(),Personal.get(i).getRFC(),Personal.get(i).getSalario(),Personal.get(i).getRol(),Personal.get(i).getFechaDeIngreso(),Personal.get(i).getCURP(),Personal.get(i).getHorario());
        }
    }
    public void QuitarEmpleados(){
        System.out.println("La lista de empleados es la siguiente");
        for (int i = 0;i < Personal.size();i++){
            System.out.printf("%d Su nombre:%s\n   Su Apellido:%s\n",i, Personal.get(i).getName(),Personal.get(i).getApellido());
        }
        System.out.println("Ingrese elindice del empleado a eliminar:");
        int op=leer.nextInt();
        Personal.remove(op);
        System.out.println("\nSe elimino exitosamente el trabajador");
    }
    public ArrayList<Personal> getPersonal() {
        return Personal;
    }
}
