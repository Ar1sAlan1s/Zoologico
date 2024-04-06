
import random
from typing import List

class Animal:
    def __init__(self, animal_type: str, id: int, birth_date: str, arrival_date: str, weight: float, feeding_frequency: str, feeding_types: str, vaccinated: bool):
        self.animal_type = animal_type
        self.id = id
        self.birth_date = birth_date
        self.arrival_date = arrival_date
        self.weight = weight
        self.feeding_frequency = feeding_frequency
        self.feeding_types = feeding_types
        self.vaccinated = vaccinated
        self.diseases: List[str] = []

    def set_diseases(self, diseases: List[str]):
        self.diseases = diseases

class AnimalManager:
    def __init__(self):
        self.animals: List[Animal] = []
        self.scanner = input

    def register_animal(self):
        animal_type = self.scanner("Ingrese tipo de Animal:")
        id = random.randint(1, 200)
        self.validate_id(id)
        birth_date = self.scanner("\nIngrese fecha de nacimiento con el formato Dia/Mes/Año:")
        arrival_date = self.scanner("\nIngrese Fecha de llegada con el formato Dia/Mes/Año:")
        weight = float(self.scanner("\nIngrese peso:"))
        feeding_frequency = self.scanner("\nIngrese Frecuencia de alimentacion:")
        feeding_types = self.scanner("\nIngrese tipos de alimentacion:")
        vaccinated = self.scanner("\nTiene vacunas 'Si' No tiene vacunas 'No':") == "Si"

        diseases = []
        disease = self.scanner("\nIngrese enfermedades, cuando acabe ingrese Fin:")
        while disease != "Fin":
            diseases.append(disease)
            disease = self.scanner("Ingrese enfermedad:")

        animal = Animal(animal_type, id, birth_date, arrival_date, weight, feeding_frequency, feeding_types, vaccinated)
        animal.set_diseases(diseases)
        self.animals.append(animal)

    def display_animals(self):
        for animal in self.animals:
            print(f"Tipo de animal:{animal.animal_type}\nSu id:{animal.id}\nFecha de nacimiento:{animal.birth_date}\nFecha de llegada:{animal.arrival_date}\nPeso:{animal.weight:.2f}Kg\nFrecuencia de alimentacion:{animal.feeding_frequency}\nTipos de alimentacion:{animal.feeding_types}\nVacunas:{animal.vaccinated}")
            for i, disease in enumerate(animal.diseases):
                print(f"Enfermedad {i+1}: {disease}")

    def validate_id(self, id: int):
        for animal in self.animals:
            if animal.id == id:
                id = random.randint(1, 200)
                self.validate_id(id)
                return

    def delete_animal(self):
        for i, animal in enumerate(self.animals):
            print(f"\n{i+1} Animal:{animal.animal_type}\n")
        option = int(self.scanner("Ingrese el numero del animal a eliminar:"))
        self.animals.pop(option-1)

    def search_animal_by_id(self):
        id = int(self.scanner("Ingrese el id del animal:"))
        print()
        for animal in self.animals:
            if animal.id == id:
                print(f"Tipo de animal:{animal.animal_type}\nSu id:{animal.id}\nFecha de nacimiento:{animal.birth_date}\nFecha de llegada:{animal.arrival_date}\nPeso:{animal.weight:.2f}Kg\nFrecuencia de alimentacion:{animal.feeding_frequency}\nTipos de alimentacion:{animal.feeding_types}\nVacunas:{animal.vaccinated}")
                for i, disease in enumerate(animal.diseases):
                    print(f"Enfermedad {i+1}: {disease}")

