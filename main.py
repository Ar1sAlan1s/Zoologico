
import sys

class Visitantes:
    def __init__(self, nombre, apellidos, fechaNacimiento, curp, fechaRegistro):
        self.nombre = nombre
        self.apellidos = apellidos
        self.fechaNacimiento = fechaNacimiento
        self.curp = curp
        self.fechaRegistro = fechaRegistro
        self.visitantes = []

    def añadirVisitante(self, visitante):
        self.visitantes.append(visitante)

    def mostrarVisitantes(self):
        for visitante in self.visitantes:
            print(f"Nombre: {visitante.nombre}")
            print(f"Apellidos: {visitante.apellidos}")
            print(f"Fecha de Nacimiento: {visitante.fechaNacimiento}")
            print(f"CURP: {visitante.curp}")
            print(f"Fecha de Registro: {visitante.fechaRegistro}")
            print()

    def eliminarVisitante(self):
        nombre = input("Ingrese el nombre del visitante a eliminar: ")
        for i, visitante in enumerate(self.visitantes):
            if visitante.nombre == nombre:
                del self.visitantes[i]
                print(f"Visitante {nombre} eliminado.")
                return
        print(f"No se encontró un visitante con el nombre {nombre}.")

    def getDatosVisitante(self):
        nombre = input("Ingrese el nombre del visitante: ")
        for visitante in self.visitantes:
            if visitante.nombre == nombre:
                print(f"Nombre: {visitante.nombre}")
                print(f"Apellidos: {visitante.apellidos}")
                print(f"Fecha de Nacimiento: {visitante.fechaNacimiento}")
                print(f"CURP: {visitante.curp}")
                print(f"Fecha de Registro: {visitante.fechaRegistro}")
                return
        print(f"No se encontró un visitante con el nombre {nombre}.")

class Animales:
    def __init__(self):
        self.animales = []

    def RegistrarAnimal(self):
        nombre = input("Ingrese el nombre del animal: ")
        especie = input("Ingrese la especie del animal: ")
        edad = int(input("Ingrese la edad del animal: "))
        id = input("Ingrese el ID del animal: ")
        animal = {"nombre": nombre, "especie": especie, "edad": edad, "id": id}
        self.animales.append(animal)
        print("Animal registrado exitosamente.")

    def MostrarAnimales(self):
        if not self.animales:
            print("No hay animales registrados.")
        else:
            for animal in self.animales:
                print(f"Nombre: {animal['nombre']}")
                print(f"Especie: {animal['especie']}")
                print(f"Edad: {animal['edad']}")
                print(f"ID: {animal['id']}")
                print()

    def EliminarAnimal(self):
        id = input("Ingrese el ID del animal a eliminar: ")
        for i, animal in enumerate(self.animales):
            if animal["id"] == id:
                del self.animales[i]
                print(f"Animal con ID {id} eliminado.")
                return
        print(f"No se encontró un animal con el ID {id}.")

    def BuscarAnimalPorID(self):
        id = input("Ingrese el ID del animal a buscar: ")
        for animal in self.animales:
            if animal["id"] == id:
                print(f"Nombre: {animal['nombre']}")
                print(f"Especie: {animal['especie']}")
                print(f"Edad: {animal['edad']}")
                print(f"ID: {animal['id']}")
                return
        print(f"No se encontró un animal con el ID {id}.")

class control:
    def __init__(self):
        self.visitas = []
        self.mantenimientos = []

    def RegistarVisitas(self):
        nombre = input("Ingrese el nombre del visitante: ")
        fecha = input("Ingrese la fecha de la visita (DD/MM/AAAA): ")
        hora = input("Ingrese la hora de la visita (HH:MM): ")
        visita = {"nombre": nombre, "fecha": fecha, "hora": hora}
        self.visitas.append(visita)
        print("Visita registrada exitosamente.")

    def mostrarTodasLasVisitas(self):
        if not self.visitas:
            print("No hay visitas registradas.")
        else:
            for visita in self.visitas:
                print(f"Nombre: {visita['nombre']}")
                print(f"Fecha: {visita['fecha']}")
                print(f"Hora: {visita['hora']}")
                print()

    def imprimirInformacionVisita(self, fecha):
        for visita in self.visitas:
            if visita["fecha"] == fecha:
                print(f"Nombre: {visita['nombre']}")
                print(f"Fecha: {visita['fecha']}")
                print(f"Hora: {visita['hora']}")
                return
        print(f"No se encontró una visita con la fecha {fecha}.")

    def registrarMantenimiento(self):
        fecha = input("Ingrese la fecha del mantenimiento (DD/MM/AAAA): ")
        descripcion = input("Ingrese la descripción del mantenimiento: ")
        mantenimiento = {"fecha": fecha, "descripcion": descripcion}
        self.mantenimientos.append(mantenimiento)
        print("Mantenimiento registrado exitosamente.")

    def imprimirMantenimientos(self):
        if not self.mantenimientos:
            print("No hay mantenimientos registrados.")
        else:
            for mantenimiento in self.mantenimientos:
                print(f"Fecha: {mantenimiento['fecha']}")
                print(f"Descripción: {mantenimiento['descripcion']}")
                print()

    def consultarMantenimientoPorFecha(self, fecha):
        for mantenimiento in self.mantenimientos:
            if mantenimiento["fecha"] == fecha:
                print(f"Fecha: {mantenimiento['fecha']}")
                print(f"Descripción: {mantenimiento['descripcion']}")
                return
        print(f"No se encontró un mantenimiento con la fecha {fecha}.")

class Personal:
    def __init__(self):
        self.empleados = []

    def RegistrarEmpleado(self):
        nombre = input("Ingrese el nombre del empleado: ")
        apellidos = input("Ingrese los apellidos del empleado: ")
        puesto = input("Ingrese el puesto del empleado: ")
        empleado = {"nombre": nombre, "apellidos": apellidos, "puesto": puesto}
        self.empleados.append(empleado)
        print("Empleado registrado exitosamente.")

    def MostrarEmpleados(self):
        if not self.empleados:
            print("No hay empleados registrados.")
        else:
            for empleado in self.empleados:
                print(f"Nombre: {empleado['nombre']}")
                print(f"Apellidos: {empleado['apellidos']}")
                print(f"Puesto: {empleado['puesto']}")
                print()

    def QuitarEmpleados(self):
        nombre = input("Ingrese el nombre del empleado a eliminar: ")
        for i, empleado in enumerate(self.empleados):
            if empleado["nombre"] == nombre:
                del self.empleados[i]
                print(f"Empleado {nombre} eliminado.")
                return
        print(f"No se encontró un empleado con el nombre {nombre}.")

def main():
    Password = "Hola"
    pass_input = input("Ingrese la contraseña: ")
    while pass_input != Password:
        print("Intente de nuevo")
        pass_input = input("Ingrese la contraseña: ")

    control_obj = control()
    personal_obj = Personal()
    animales_obj = Animales()
    visitantes_obj = Visitantes("", "", 0, "", "")

    while True:
        print("Opciones:")
        print("1. Registrar Empleados")
        print("2. Mostrar Empleados")
        print("3. Quitar Empleados")
        print("4. Registar Visitantes")
        print("5. Mostrar lista de Visitantes")
        print("6. Eliminar Visitante")
        print("7. Mostrar Visitante en especifico")
        print("8. Registrar Visita")
        print("9. Mostrar todas las visitas")
        print("10. Mostrar la informacion detallada de una visita en especifico")
        print("11. Registrar Mantenimiento")
        print("12. Mostrar Mantenimientos")
        print("13. Mostrar Informacion de un Mantenimieno en especifico")
        print("14. Registrar Animal")
        print("15. Mostrar Animales")
        print("16. Eliminar Animal")
        print("17. Buscar Animal por ID")
        print("18. Salir del programa")
        opcion = int(input("Ingrese su opción: "))

        if opcion == 1:
            personal_obj.RegistrarEmpleado()
        elif opcion == 2:
            personal_obj.MostrarEmpleados()
        elif opcion == 3:
            personal_obj.QuitarEmpleados()
        elif opcion == 4:
            nombre = input("Ingresar nombre del Visitante: ")
            apellidos = input("Ingresar apellidos del Visitante: ")
            fechaNacimiento = int(input("Ingresa su año de nacimiento: "))
            curp = input("Ingresa su CURP: ")
            fechaRegistro = input("Ingresar Fecha de Registro: ")
            visitante = Visitantes(nombre, apellidos, fechaNacimiento, curp, fechaRegistro)
            visitante.añadirVisitante(visitante)
        elif opcion == 5:
            visitantes_obj.mostrarVisitantes()
        elif opcion == 6:
            visitantes_obj.eliminarVisitante()
        elif opcion == 7:
            visitantes_obj.getDatosVisitante()
        elif opcion == 8:
            control_obj.RegistarVisitas()
        elif opcion == 9:
            control_obj.mostrarTodasLasVisitas()
        elif opcion == 10:
            fecha = input("Ingrese la fecha de la visita con la forma: Dia/Mes/año: ")
            control_obj.imprimirInformacionVisita(fecha)
        elif opcion == 11:
            control_obj.registrarMantenimiento()
        elif opcion == 12:
            control_obj.imprimirMantenimientos()
        elif opcion == 13:
            fecha = input("Ingrese la fecha que se realizó el mantenimiento: ")
            control_obj.consultarMantenimientoPorFecha(fecha)
        elif opcion == 14:
            animales_obj.RegistrarAnimal()
        elif opcion == 15:
            animales_obj.MostrarAnimales()
        elif opcion == 16:
            animales_obj.EliminarAnimal()
        elif opcion == 17:
            animales_obj.BuscarAnimalPorID()
        elif opcion == 18:
            print("----Saliendo del Sistema.----")
            sys.exit()
        else:
            print("Opción inválida. Intente de nuevo.")

if __name__ == "__main__":
    main()

