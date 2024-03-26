import java.util.ArrayList;
public class Personal {
    ArrayList<Personal> Personal=new ArrayList<>();
    private String name;
    private String apellido;
    private  String FechaDeNacimiento;
    private  String RFC;
    private  double Salario;
    private  String rol;
    private String FechaDeIngreso;
    private String CURP;
    private String horario;
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
    public void RegistrarEmpleado(Personal Empleado){
        this.Personal.add(Empleado);
    }
    public void MostrarEmpleados(){
        for (int i=0;i < Personal.size();i++){
            System.out.printf("Su nombre;%s\nSu Apellido:%s",Personal.get(i).name,Personal.get(i).apellido);
        }
    }





}
