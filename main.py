import sys
from Visitantes import Visitantes
from Control import Control
from Animales import AnimalManager
from Personal import Personal
def main():
    Password = "Hola"
    pass_input = input("Ingrese la contraseña: ")
    while pass_input != Password:
        print("Intente de nuevo")
        pass_input = input("Ingrese la contraseña: ")

    control_obj = Control()
    personal_obj = Personal()
    animales_obj = AnimalManager()
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
            personal_obj.registrar_empleado()
        elif opcion == 2:
            personal_obj.mostrar_empleados()
        elif opcion == 3:
            personal_obj.quitar_empleados()
        elif opcion == 4:
            nombre = input("Ingresar nombre del Visitante: ")
            apellidos = input("Ingresar apellidos del Visitante: ")
            fechaNacimiento = int(input("Ingresa su año de nacimiento: "))
            curp = input("Ingresa su CURP: ")
            fechaRegistro = input("Ingresar Fecha de Registro: ")
            visitantes = Visitantes(nombre, apellidos, fechaNacimiento, curp, fechaRegistro)
            visitantes_obj.addVisitante(visitantes)
        elif opcion == 5:
            visitantes_obj.mostrarVisitantes()
        elif opcion == 6:
            visitantes_obj.eliminarVisitante()
        elif opcion == 7:
            visitantes_obj.getDatosVisitante()
        elif opcion == 8:
            control_obj.registrar_visitas()
        elif opcion == 9:
            control_obj.mostrar_todas_las_visitas()
        elif opcion == 10:
            fecha = input("Ingrese la fecha de la visita con la forma: Dia/Mes/año: ")
            control_obj.imprimir_informacion_visita(fecha)
        elif opcion == 11:
            control_obj.registrar_mantenimiento()
        elif opcion == 12:
            control_obj.imprimirMantenimientos()
        elif opcion == 13:
            fecha = input("Ingrese la fecha que se realizó el mantenimiento: ")
            control_obj.consultarMantenimientoPorFecha(fecha)
        elif opcion == 14:
            animales_obj.register_animal()
        elif opcion == 15:
            animales_obj.display_animals()
        elif opcion == 16:
            animales_obj.delete_animal()
        elif opcion == 17:
            animales_obj.search_animal_by_id()
        elif opcion == 18:
            print("----Saliendo del Sistema.----")
            sys.exit()
        else:
            print("Opción inválida. Intente de nuevo.")
