class Visitantes:
    def __init__(self, nombre, apellidos, fechaNacimiento, CURP, fechaRegistro):
        self.nombre = nombre
        self.apellidos = apellidos
        self.fechaNacimiento = fechaNacimiento
        self.CURP = CURP
        self.fechaRegistro = fechaRegistro
        self.numVisitas = 0
        self.visitante = []

    def getNumVisitas(self):
        return self.numVisitas

    def setNumVisistas(self, Visitas):
        self.numVisitas = Visitas

    def getNombre(self):
        return self.nombre

    def getApellidos(self):
        return self.apellidos

    def getFechaNacimiento(self):
        return self.fechaNacimiento

    def getCURP(self):
        return self.CURP

    def getFechaRegistro(self):
        return self.fechaRegistro

    def getVisitantes(self):
        return self.visitante

    def addVisitante(self, visitantes):
        self.visitante.append(visitantes)

    def eliminarVisitante(self):
        print("Proporcione la CURP del visitante que desea eliminar: ")
        curp = input()
        indiceVisitante = self.buscarVisitantePorCURP(curp)

        if indiceVisitante != -1:
            if self.visitante[indiceVisitante].getNumVisitas() == 0:
                del self.visitante[indiceVisitante]
                print("El visitante con la CURP " + curp + " ha sido eliminado exitosamente.")
            else:
                print("No se puede eliminar el visitante, ya que tiene visitas registradas.")
        else:
            print("No se encontró ningún visitante con esa CURP.")

    def mostrarVisitantes(self):
        for visitantes in self.visitante:
            print("-------------------------------")
            print("|Nombre del Visitante: |" + visitantes.getNombre()
                  + "| Apellidos del Visitante: |" + visitantes.getApellidos()
                  + "| Fecha de Nacimiento: |" + str(visitantes.getFechaNacimiento())
                  + "| CURP del Visitante: |" + visitantes.getCURP())
            print("-------------------------------")

    def visitanteValido(self, valido):
        if valido == -1:
            return False
        else:
            return True

    def getSubindiceVisitante(self):
        verificacion = -1
        print("Proporcione la CURP del visitante: ")
        curp = input()
        for i in range(len(self.visitante)):
            if curp == self.visitante[i].CURP:
                verificacion = i
                break
        return verificacion

    def getDatosVisitante(self):
        if not self.visitante:
            print("No se han añadido visitantes al Sistema.")
        else:
            i = self.getSubindiceVisitante()
            if self.visitanteValido(i):
                print("-------------------------------")
                print("|Nombre del Visitante: |" + self.visitante[i].getNombre()
                      + "| Apellidos del Visitante: |" + self.visitante[i].getApellidos()
                      + "| Fecha de Nacimiento: |" + str(self.visitante[i].getFechaNacimiento())
                      + "| CURP del Visitante: |" + self.visitante[i].getCURP()
                      + "| Visitas totales: |" + str(self.visitante[i].getNumVisitas()))
                print("-------------------------------")
            else:
                print("Este visitante no existe.")

    def buscarVisitantePorCURP(self, curp):
        for i in range(len(self.visitante)):
            if curp == self.visitante[i].getCURP():
                return i
        return -1

    def aumentarVisitas(self):
        print("Ingrese la CURP del visitante:")
        curp = input()

        indiceVisitante = self.buscarVisitantePorCURP(curp)

        if indiceVisitante != -1:
            visitasActuales = self.visitante[indiceVisitante].getNumVisitas()
            self.visitante[indiceVisitante].setNumVisistas(visitasActuales + 1)
            print("Visitas actualizadas para el visitante con CURP: " + curp)
        else:
            print("No se encontró ningún visitante con esa CURP.")
