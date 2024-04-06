class Personal:
    def __init__(self, name, apellido, fecha_de_nacimiento, rfc, salario, rol, fecha_de_ingreso, curp, horario):
        self.name = name
        self.apellido = apellido
        self.fecha_de_nacimiento = fecha_de_nacimiento
        self.rfc = rfc
        self.salario = salario
        self.rol = rol
        self.fecha_de_ingreso = fecha_de_ingreso
        self.curp = curp
        self.horario = horario

    def get_name(self):
        return self.name

    def get_apellido(self):
        return self.apellido

    def get_fecha_de_nacimiento(self):
        return self.fecha_de_nacimiento

    def get_rfc(self):
        return self.rfc

    def get_salario(self):
        return self.salario

    def get_rol(self):
        return self.rol

    def get_fecha_de_ingreso(self):
        return self.fecha_de_ingreso

    def get_curp(self):
        return self.curp

    def get_horario(self):
        return self.horario

    def registrar_empleado(self):
        name = input("Ingrese nombre: ")
        apellido = input("\nIngrese apellido: ")
        fecha_de_nacimiento = input("\nIngrese Fecha de nacimiento con el formato Dia/Mes/Año: ")
        rfc = input("\nIngrese RFC: ")
        salario = float(input("\nIngrese salario: "))
        band = False
        while not band:
            rol = input("\nIngrese rol: ").upper()
            if rol in ["VETERINARIO", "GUIA", "MANTENIMIENTO", "ADMINISTRACION"]:
                fecha_de_ingreso = input("\nIngrese Fecha de ingreso con el formato Dia/Mes/Año: ")
                curp = input("\nIngrese CURP: ").upper()
                horario = input("\nIngrese Horario: ")
                empleado = Personal(name, apellido, fecha_de_nacimiento, rfc, salario, rol, fecha_de_ingreso, curp, horario)
                self.personal.append(empleado)
                band = True
            else:
                print("ingrese un rol valido")

    def mostrar_empleados(self):
        for i, empleado in enumerate(self.personal):
            print(f"Su nombre: {empleado.get_name()}\nSu Apellido: {empleado.get_apellido()}\nSu Fecha de Nacimiento: {empleado.get_fecha_de_nacimiento()}\nSu RFC: {empleado.get_rfc()}\nSu salario: {empleado.get_salario():.2f}\nSu rol: {empleado.get_rol()}\nSu Fecha de ingreso: {empleado.get_fecha_de_ingreso()}\nSu CURP: {empleado.get_curp()}\nSu Horario: {empleado.get_horario()}\n############################\n")

    def quitar_empleados(self):
        print("La lista de empleados es la siguiente")
        for i, empleado in enumerate(self.personal):
            print(f"{i} Su nombre: {empleado.get_name()}\n   Su Apellido: {empleado.get_apellido()}")
        op = int(input("Ingrese el índice del empleado a eliminar: "))
        del self.personal[op]
        print("\nSe eliminó exitosamente el trabajador")

    def __init__(self):
        self.personal = []

