class Control:
    def __init__(self):
        self.mantenimiento = None
        self.empleado = Personal()
        self.visita = Visita("", self.empleado, 0, 0, 0)
        self.leer = Scanner()
        self.visitantes = Visitantes("", "", 0, "", "")
        self.lista_de_visitas = []
        self.lista_de_mantenimientos = []

    def buscar_empleado_por_curp(self, curp):
        for i in range(len(self.empleado.personal)):
            if curp == self.empleado.personal[i].curp:
                return i
        return -1

    def registrar_visitas(self):
        print("Ingrese la fecha del recorrido con la siguiente estructura: día/mes/año")
        fecha_de_recorrido = self.leer.next_line()

        guia = None
        guia_encontrado = False
        while not guia_encontrado:
            print("Ingrese el CURP del guía que dará el recorrido:")
            curp_guia = self.leer.next_line().upper()
            indice_empleado = self.buscar_empleado_por_curp(curp_guia)
            if indice_empleado != -1:
                rol = self.empleado.personal[indice_empleado].rol
                if rol == "GUIA":
                    guia = self.empleado.personal[indice_empleado]
                    guia_encontrado = True
                else:
                    print("Este empleado no puede realizar esa acción.")
                    opcion = self.leer.next_int()
                    if opcion == 1:
                        return
            else:
                print("Empleado no encontrado. Asegúrese de anotar correctamente el CURP.")
                opcion = self.leer.next_int()
                if opcion == 1:
                    return

        visitantes_en_recorrido = []
        total_adultos = 0
        total_niños = 0
        agregar_visitante = True
        while agregar_visitante:
            print("Ingrese la CURP del visitante:")
            curp_visitante = self.leer.next_line().upper()
            indice_visitante = self.visitantes.buscar_visitante_por_curp(curp_visitante)
            if indice_visitante != -1:
                visitante = self.visitantes.visitantes[indice_visitante]
                visitante.num_visitas += 1
                if visitante.num_visitas % 5 == 0:
                    visitante.num_visitas = 0
                    print("¡Felicidades! Se aplicó un descuento del 20% en el boleto para el visitante con CURP:", visitante.curp)
                visitantes_en_recorrido.append(visitante)
                if visitante.fecha_nacimiento >= 2012:
                    total_adultos += 1
                else:
                    total_niños += 1
            else:
                print("Visitante no encontrado.")

            print("¿Desea agregar otro visitante? (s/n)")
            respuesta = self.leer.next_line().lower()
            if respuesta == "n":
                agregar_visitante = False

        costo_total = (total_adultos * 100) + (total_niños * 50)
        total_visitas_elegibles_descuento = sum(1 for visitante in visitantes_en_recorrido if visitante.num_visitas % 5 == 0)

        if total_visitas_elegibles_descuento > 0:
            descuento = 0.2
            monto_descuento = costo_total * descuento * (total_visitas_elegibles_descuento // 5)
            costo_total -= monto_descuento
            print("Se aplicó un descuento del 20% al costo total.")

        nueva_visita = Visita(fecha_de_recorrido, guia, costo_total, total_adultos, total_niños)
        nueva_visita.lista_de_visitantes_en_recorrido = visitantes_en_recorrido
        self.lista_de_visitas.append(nueva_visita)

        print("Visita registrada exitosamente:")
        print("Fecha del recorrido:", nueva_visita.fecha_de_recorrido)
        print("Guía a cargo:", nueva_visita.guia.name, nueva_visita.guia.apellido)
        print("Número total de adultos:", nueva_visita.num_de_adultos)
        print("Número total de niños:", nueva_visita.num_de_niños)
        print("Costo total de la visita: $", nueva_visita.costo_total)

    def mostrar_todas_las_visitas(self):
        if not self.lista_de_visitas:
            print("No hay visitas registradas.")
        else:
            print("Lista de todas las visitas registradas:")
            for v in self.lista_de_visitas:
                print("Fecha del recorrido:", v.fecha_de_recorrido)
                print("Guía a cargo:", v.guia.name, v.guia.apellido)
                print("Número total de adultos:", v.num_de_adultos)
                print("Número total de niños:", v.num_de_niños)
                print("Costo total de la visita: $", v.costo_total)
                print("---------------------------------------------")

    def imprimir_informacion_visita(self, fecha_de_registro):
        for v in self.lista_de_visitas:
            if v.fecha_de_recorrido == fecha_de_registro:
                print("Información de la visita:")
                print("Fecha del recorrido:", v.fecha_de_recorrido)
                print("Guía a cargo:", v.guia.name, v.guia.apellido)
                print("Número total de adultos:", v.num_de_adultos)
                print("Número total de niños:", v.num_de_niños)
                print("Costo total de la visita: $", v.costo_total)
                print("Visitantes:")
                for visitante in v.lista_de_visitantes_en_recorrido:
                    print("Nombre:", visitante.nombre)
                    print("Apellidos:", visitante.apellidos)
                    print("Fecha de nacimiento:", visitante.fecha_nacimiento)
                    print("CURP:", visitante.curp)
                    print("Número de visitas:", visitante.num_visitas)
                    print("Fecha de registro:", visitante.fecha_registro)
                return
        print("No se encontró ninguna visita registrada para la fecha de registro proporcionada.")

    def registrar_mantenimiento(self):
        print("Ingrese el CURP del empleado que realizará el mantenimiento:")
        curp_empleado = self.leer.next_line().upper()
        indice_empleado = self.buscar_empleado_por_curp(curp_empleado)

        if indice_empleado != -1:
            empleado = self.empleado.personal[indice_empleado]
            if empleado.rol == "MANTENIMIENTO":
                print("Ingrese el ID del animal:")
                ID = self.leer.next_int()
                self.leer.next_line()

                print("Ingrese el proceso realizado:")
                proceso_realizado = self.leer.next_line()

                print("Ingrese la fecha del proceso (formato: día/mes/año):")
                fecha_proceso = self.le

class Mantenimiento:
    def __init__(self, empleado, ID, proceso_realizado, proceso_que_se_realizo, fecha_de_mantenimiento):
        self.empleado = empleado
        self.animal = Animales()
        self.ID = ID
        self.observaciones = ""
        self.fecha_de_mantenimiento = fecha_de_mantenimiento
        self.proceso_qu_se_realizo = proceso_que_se_realizo

class Visita:
    def __init__(self, fecha_de_recorrido, guia, costo_total, num_de_adultos, num_de_niños):
        self.lista_de_visitas = []
        self.fecha_de_recorrido = fecha_de_recorrido
        self.guia = guia
        self.visitante = Visitantes("", " ", 0, " ", " ")
        self.costo_total = costo_total
        self.num_de_niños = num_de_niños
        self.num_de_adultos = num_de_adultos
        self.lista_de_visitantes_en_recorrido = []

    def agregar_visitantes_a_recorrido(self, visitante):
        self.lista_de_visitantes_en_recorrido.append(visitante)

    # Getters and setters
    def get_lista_de_visitantes_en_recorrido(self):
        return self.lista_de_visitantes_en_recorrido

    def set_lista_de_visitantes_en_recorrido(self, lista_de_visitantes_en_recorrido):
        self.lista_de_visitantes_en_recorrido = lista_de_visitantes_en_recorrido