import java.util.Scanner;
import java.util.ArrayList;

public class control {
    Mantenimiento mantenimiento;
    Personal Empleado=new Personal();
    visita visita=new visita(" ",Empleado, 0, 0, 0);
    Scanner leer = new Scanner(System.in);
    Visitantes visitantes = new Visitantes(" ", " ", 0, " ", " ");
    ArrayList<visita> ListaDeVisitas=new ArrayList<>();
    ArrayList<Mantenimiento> listaDeMantenimientos=new ArrayList<>();
    private int buscarEmpleadoPorCURP(String curp) {
        for (int i = 0; i < Empleado.getPersonal().size(); i++) {
            if (curp.equals(Empleado.getPersonal().get(i).getCURP())) {
                return i;
            }
        }
        return -1;
    }
    public void RegistarVisitas() {
        System.out.println("Ingrese la fecha del recorrido con la siguiente estructura: día/mes/año");
        String fechaDeRecorrido = leer.nextLine();

        // Buscar el guía por CURP
        Personal guia = null;
        boolean guiaEncontrado = false;
        while (!guiaEncontrado) {
            System.out.println("Ingrese el CURP del guía que dará el recorrido:");
            String curpGuia = leer.nextLine().toUpperCase();
            int indiceEmpleado = buscarEmpleadoPorCURP(curpGuia);
            if (indiceEmpleado != -1) {
                String rol = Empleado.getPersonal().get(indiceEmpleado).getRol();
                if (rol.equals("GUIA")) {
                    guia = Empleado.getPersonal().get(indiceEmpleado);
                    guiaEncontrado = true;
                } else {
                    System.out.println("Este empleado no puede realizar esa acción.");
                    System.out.println("Si desea cancelar el registro, presione 1; de lo contrario, presione 2:");
                    int opcion = leer.nextInt();
                    if (opcion == 1) {
                        return;
                    }
                }
            } else {
                System.out.println("Empleado no encontrado. Asegúrese de anotar correctamente el CURP.");
                System.out.println("Si desea cancelar el registro, presione 1; de lo contrario, presione 2:");
                int opcion = leer.nextInt();
                if (opcion == 1) {
                    return;
                }
            }
        }
        ArrayList<Visitantes> visitantesEnRecorrido = new ArrayList<>();
        int totalAdultos = 0;
        int totalNiños = 0;
        boolean agregarVisitante = true;
        while (agregarVisitante) {
            System.out.println("Ingrese la CURP del visitante:");
            String curpVisitante = leer.nextLine().toUpperCase();
            int indiceVisitante = visitantes.buscarVisitantePorCURP(curpVisitante);
            if (indiceVisitante != -1) {
                Visitantes visitante = visitantes.getVisitantes().get(indiceVisitante);
                visitante.setNumVisistas(visitante.getNumVisitas() + 1); // Incrementar el número de visitas del visitante
                if (visitante.getNumVisitas() % 5 == 0) { // Verificar si se pueden aplicar descuentos
                    // Reiniciar el contador de visitas
                    visitante.setNumVisistas(0);
                    // Aplicar descuento del 20%
                    System.out.println("¡Felicidades! Se aplicó un descuento del 20% en el boleto para el visitante con CURP: " + visitante.getCURP());
                }
                visitantesEnRecorrido.add(visitante);
                if (visitante.getFechaNacimiento() >= 2012) {
                    totalAdultos++;
                } else {
                    totalNiños++;
                }
            } else {
                System.out.println("Visitante no encontrado.");
            }

            // Preguntar si desea agregar otro visitante
            System.out.println("¿Desea agregar otro visitante? (s/n)");
            String respuesta = leer.nextLine().toLowerCase();
            if (respuesta.equals("n")) {
                agregarVisitante = false;
            }
        }
        double costoTotal = (totalAdultos * 100) + (totalNiños * 50);
        // Aplicar descuento
        int totalVisitasElegiblesDescuento = 0;
        for (Visitantes visitante : visitantesEnRecorrido) {
            if (visitante.getNumVisitas() % 5 == 0) {
                totalVisitasElegiblesDescuento++;
            }
        }

        if (totalVisitasElegiblesDescuento > 0) {
            double descuento = 0.2; // Descuento del 20%
            double montoDescuento = costoTotal * descuento * (totalVisitasElegiblesDescuento / 5); // Calcular monto de descuento
            costoTotal -= montoDescuento; // Aplicar descuento al costo total
            System.out.println("Se aplicó un descuento del 20% al costo total.");
        }
        visita nuevaVisita = new visita(fechaDeRecorrido, guia, costoTotal, totalAdultos, totalNiños);
        nuevaVisita.setListaDeVisitantesEnRecorrido(visitantesEnRecorrido);
        ListaDeVisitas.add(nuevaVisita);

        // Mostrar información de la visita
        System.out.println("Visita registrada exitosamente:");
        System.out.println("Fecha del recorrido: " + nuevaVisita.fechaDeRecorrido);
        System.out.println("Guía a cargo: " + nuevaVisita.guia.getName() + " " + nuevaVisita.guia.getApellido());
        System.out.println("Número total de adultos: " + nuevaVisita.NumDeAdultos);
        System.out.println("Número total de niños: " + nuevaVisita.NumDeNiños);
        System.out.println("Costo total de la visita: $" + nuevaVisita.costoTotal);
    }
    public void mostrarTodasLasVisitas() {
        if (ListaDeVisitas.isEmpty()) {
            System.out.println("No hay visitas registradas.");
        } else {
            System.out.println("Lista de todas las visitas registradas:");
            for (visita v : ListaDeVisitas) {
                System.out.println("Fecha del recorrido: " + v.fechaDeRecorrido);
                System.out.println("Guía a cargo: " + v.guia.getName() + " " + v.guia.getApellido());
                System.out.println("Número total de adultos: " + v.NumDeAdultos);
                System.out.println("Número total de niños: " + v.NumDeNiños);
                System.out.println("Costo total de la visita: $" + v.costoTotal);
                System.out.println("---------------------------------------------");
            }
        }
    }

    public void imprimirInformacionVisita(String fechaDeRegistro) {
        for (visita v : ListaDeVisitas) {
            if (v.fechaDeRecorrido.equals(fechaDeRegistro)) {
                System.out.println("Información de la visita:");
                System.out.println("Fecha del recorrido: " + v.fechaDeRecorrido);
                System.out.println("Guía a cargo: " + v.guia.getName() + " " + v.guia.getApellido());
                System.out.println("Número total de adultos: " + v.NumDeAdultos);
                System.out.println("Número total de niños: " + v.NumDeNiños);
                System.out.println("Costo total de la visita: $" + v.costoTotal);
                System.out.println("Visitantes:");
                for (Visitantes visitante : v.getListaDeVisitantesEnRecorrido()) {
                    System.out.println("Nombre: " + visitante.getNombre());
                    System.out.println("Apellidos: " + visitante.getApellidos());
                    System.out.println("Fecha de nacimiento: " + visitante.getFechaNacimiento());
                    System.out.println("CURP: " + visitante.getCURP());
                    System.out.println("Número de visitas: " + visitante.getNumVisitas());
                    System.out.println("Fecha de registro: " + visitante.getFechaRegistro());
                }
                return;
            }
        }
        System.out.println("No se encontró ninguna visita registrada para la fecha de registro proporcionada.");
    }

    public void registrarMantenimiento() {
        System.out.println("Ingrese el CURP del empleado que realizará el mantenimiento:");
        String curpEmpleado = leer.nextLine().toUpperCase();
        int indiceEmpleado = buscarEmpleadoPorCURP(curpEmpleado);

        if (indiceEmpleado != -1) {
            Personal empleado = Empleado.getPersonal().get(indiceEmpleado);
            if (empleado.getRol().equals("MANTENIMIENTO")) {
                System.out.println("Ingrese el ID del animal:");
                int ID = leer.nextInt();
                leer.nextLine(); // Limpiar el buffer

                System.out.println("Ingrese el proceso realizado:");
                String procesoRealizado = leer.nextLine();

                System.out.println("Ingrese la fecha del proceso (formato: día/mes/año):");
                String fechaProceso = leer.nextLine();

                System.out.println("Ingrese observaciones (opcional):");
                String observaciones = leer.nextLine();

                Mantenimiento mantenimiento = new Mantenimiento(empleado, ID, procesoRealizado, fechaProceso, observaciones);
                listaDeMantenimientos.add(mantenimiento);

                System.out.println("Mantenimiento registrado exitosamente.");
            } else {
                System.out.println("El empleado no tiene permisos para realizar mantenimientos.");
            }
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }


    // Método para imprimir todos los mantenimientos realizados
    public void imprimirMantenimientos() {
        System.out.println("Lista de mantenimientos realizados:");
        for (int i = 0; i < listaDeMantenimientos.size(); i++) {
            System.out.println("Empleado encargado: " + mantenimiento.empleado.getName() + " " + mantenimiento.empleado.getApellido());
            System.out.println("ID del animal: " + mantenimiento.ID);
            System.out.println("Proceso realizado: " + mantenimiento.ProcesoQuSeRealizo);
            System.out.println("Fecha del proceso: " + mantenimiento.fechaDeMantenimento);
            System.out.println("Observaciones: " + (mantenimiento.observaciones.isEmpty() ? "Ninguna" : mantenimiento.observaciones));
            System.out.println("---------------------------------------------");
        }
    }

    // Método para consultar un mantenimiento por fecha
    public void consultarMantenimientoPorFecha(String fecha) {
        boolean encontrado = false;
        for (int i = 0; i < listaDeMantenimientos.size(); i++) {
            if (mantenimiento.fechaDeMantenimento.equals(fecha)) {
                encontrado = true;
                System.out.println("Empleado encargado: " + mantenimiento.empleado.getName() + " " + mantenimiento.empleado.getApellido());
                System.out.println("ID del animal: " + mantenimiento.ID);
                System.out.println("Proceso realizado: " + mantenimiento.ProcesoQuSeRealizo);
                System.out.println("Fecha del proceso: " + mantenimiento.fechaDeMantenimento);
                System.out.println("Observaciones: " + (mantenimiento.observaciones.isEmpty() ? "Ninguna" : mantenimiento.observaciones));
                System.out.println("---------------------------------------------");
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron mantenimientos realizados en la fecha especificada.");
        }
    }
}