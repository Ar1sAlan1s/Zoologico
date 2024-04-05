import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Animales {
    Scanner leer = new Scanner(System.in);
    Random ran = new Random();
    ArrayList<Animales> listaAnimales = new ArrayList<>();
    private String tipoDeAnimal;
    private String fechaDeNacimiento;
    private String fechaLlegada;
    private float peso;
    private String frecuenciaDeAlimentacion;
    private String tiposDeAlimentacion;
    private ArrayList<String> enfermedades;
    private int id;
    private boolean vacunas;

    public Animales(String tipoDeAnimal, int id, String fechaDeNacimiento, String fechaLlegada, float peso, String frecuenciaDeAlimentacion, String tiposDeAlimentacion, boolean vacunas) {
        this.tipoDeAnimal = tipoDeAnimal;
        this.id = id;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaLlegada = fechaLlegada;
        this.peso = peso;
        this.frecuenciaDeAlimentacion = frecuenciaDeAlimentacion;
        this.tiposDeAlimentacion = tiposDeAlimentacion;
        this.vacunas = vacunas;
        this.enfermedades = new ArrayList<>();
    }
    public Animales() {
        //Este lo use para poder crear el objeto en main sin tener que mandar ningun atributo
    }
    public String getTipoDeAnimal() {
        return tipoDeAnimal;
    }

    public int getId() {
        return id;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public float getPeso() {
        return peso;
    }

    public String getFrecuenciaDeAlimentacion() {
        return frecuenciaDeAlimentacion;
    }

    public String getTiposDeAlimentacion() {
        return tiposDeAlimentacion;
    }

    public boolean getVacunas() {
        return vacunas;
    }

    public ArrayList<String> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(ArrayList<String> enfermedades) {
        this.enfermedades = enfermedades;
    }


    public void RegistrarAnimal() {
        System.out.print("Ingrese tipo de Animal:");
        String tipoDeAnimal = leer.nextLine();
        int id = ran.nextInt(200) + 1;
        ValidarId(id);
        System.out.print("\nIngrese fecha de nacimiento con el formato Dia/Mes/Año:");
        String fechaDeNacimiento = leer.nextLine();
        System.out.print("\nIngrese Fecha de llegada con el formato Dia/Mes/Año:");
        String fechaLlegada = leer.nextLine();
        System.out.print("\nIngrese peso:");
        float peso = leer.nextFloat();
        leer.nextLine();
        System.out.print("\nIngrese Frecuencia de alimentacion:");
        String frecuenciaDeAlimentacion = leer.nextLine();
        System.out.print("\nIngrese tipos de alimentacion:");
        String tiposDeAlimentacion = leer.nextLine();
        System.out.print("\nTiene vacunas 'Si' No tiene vacunas 'No':");
        String vac = leer.nextLine();
        boolean vacunas = false;
        if(vac.equals("Si")){
            vacunas = true;
        }
        ArrayList<String> enfermedades = new ArrayList<>();
        System.out.print("\nIngrese enfermedades, cuando acabe ingrese Fin:");
        String enfermedad = leer.nextLine();
        while (!enfermedad.equals("Fin")) {
            enfermedades.add(enfermedad);
            System.out.print("Ingrese enfermedad:");
            enfermedad = leer.nextLine();
        }

        Animales animal = new Animales(tipoDeAnimal, id, fechaDeNacimiento, fechaLlegada, peso, frecuenciaDeAlimentacion, tiposDeAlimentacion, vacunas);
        animal.setEnfermedades(enfermedades);
        listaAnimales.add(animal);
    }

    public void MostrarAnimales() {
        for (int i = 0; i < listaAnimales.size(); i++) {
            Animales animal = listaAnimales.get(i);
            System.out.printf("Tipo de animal:%s\nSu id:%d\nFecha de nacimiento:%s\nFecha de llegada:%s\nPeso:%.2fKg\nFrecuencia de alimentacion:%s\nTipos de alimentacion:%s\nVacunas:%b\n", animal.getTipoDeAnimal(), animal.getId(), animal.getFechaDeNacimiento(), animal.getFechaLlegada(), animal.getPeso(), animal.getFrecuenciaDeAlimentacion(), animal.getTiposDeAlimentacion(), animal.getVacunas());

            ArrayList<String> enfermedades = animal.getEnfermedades();
            for (int j = 0; j < enfermedades.size(); j++) {
                System.out.printf("Enfermedad %d: %s\n", j + 1, enfermedades.get(j));

            }
        }
    }

    public void ValidarId(int id) {
        for (int i = 0; i < listaAnimales.size(); i++) {
            if (listaAnimales.get(i).getId() == id) {
                id = ran.nextInt(200) + 1;
                i = 0;
            }
        }
    }
    public void EliminarAnimal() {
        for (int i = 0; i < listaAnimales.size(); i++) {
            System.out.printf("\n%d Animal:%s\n ", i+1,listaAnimales.get(i).getTipoDeAnimal());
        }
        System.out.println("Ingrese el numero del animal a eliminar:");
        int opcion = leer.nextInt();
        listaAnimales.remove(opcion-1);
    }


    public void BuscarAnimalPorID(){
        System.out.print("Ingrese el id del animal:");
        int ID = leer.nextInt();
        System.out.println();
        for (int i = 0; i < listaAnimales.size(); i++) {
            if(ID==listaAnimales.get(i).getId()){

                System.out.printf("Tipo de animal:%s\nSu id:%d\nFecha de nacimiento:%s\nFecha de llegada:%s\nPeso:%.2fKg\nFrecuencia de alimentacion:%s\nTipos de alimentacion:%s\nVacunas:%b\n",  listaAnimales.get(i).getTipoDeAnimal(),  listaAnimales.get(i).getId(),  listaAnimales.get(i).getFechaDeNacimiento(),  listaAnimales.get(i).getFechaLlegada(), listaAnimales.get(i).getPeso(),  listaAnimales.get(i).getFrecuenciaDeAlimentacion(), listaAnimales.get(i).getTiposDeAlimentacion(), listaAnimales.get(i).getVacunas());
                Animales animal = listaAnimales.get(i);
                ArrayList<String> enfermedades = animal.getEnfermedades();
                for (int j = 0; j < enfermedades.size(); j++) {
                    System.out.printf("Enfermedad %d: %s\n", j + 1,enfermedades.get(j));

                }

                }
        }
    }


}

