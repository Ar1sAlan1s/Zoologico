import random
from typing import List

class Animales:
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
        self.animals: List[Animales] = []
        self.scanner = input

    def register_animal(self):
        animal_type = input("Ingrese tipo de animal: ")
        id = random.randint(1, 200)
        self.validate_id(id)
        birth_date = input("\n Ingrese fecha de nacimiento dia/mes/año: ")
        arrival_date = input("\nIngrese fecha de llegada dia/mes/año: ")
        weight = float(input("\nIngrese peso: "))
        feeding_frequency = input("\nIngrese fecuencia de alimentacion: ")
        feeding_types = input("\nIngrese tipos de alimentacion: ")
        vaccinated = input("\nVacunado 'Yes' No vacunado 'No': ")
        vaccinated = vaccinated == "Yes"
        diseases = []
        disease = input("\nIngrese enfermedad cuando acabe ingrese 'Fin': ")
        while disease != "Fin":
            diseases.append(disease)
            disease = input("Ingresa enfermedad: ")

        animal = Animales(animal_type, id, birth_date, arrival_date, weight, feeding_frequency, feeding_types, vaccinated)
        animal.set_diseases(diseases)
        self.animals.append(animal)

    def display_animals(self):
        for animal in self.animals:
            print(f"Tipo de animal: {animal.animal_type}")
            print(f"ID: {animal.id}")
            print(f"Fecha de nacimiento: {animal.birth_date}")
            print(f"Fecha de llegada: {animal.arrival_date}")
            print(f"Peso: {animal.weight:.2f} kg")
            print(f"Frecuencia de alimentacion: {animal.feeding_frequency}")
            print(f"Tipo de Alimentacion: {animal.feeding_types}")
            print(f"Vacunado: {animal.vaccinated}")
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
            print(f"\n{i+1} Animal: {animal.animal_type}")
        option = int(input("Ingrese el numero del animal a eliminar: "))
        self.animals.pop(option-1)

    def search_animal_by_id(self):
        id = int(input("Ingrese el ID del animal a buscar: "))
        print()
        for animal in self.animals:
            if animal.id == id:
                print(f"Tipo de animal: {animal.animal_type}")
                print(f"ID: {animal.id}")
                print(f"Fecha de nacimiento: {animal.birth_date}")
                print(f"Fecha de llegada: {animal.arrival_date}")
                print(f"Peso: {animal.weight:.2f} kg")
                print(f"Frecuencia de alimentacion: {animal.feeding_frequency}")
                print(f"Tipo de Alimentacio: {animal.feeding_types}")
                print(f"Vacunado: {animal.vaccinated}")
                for i, disease in enumerate(animal.diseases):
                    print(f"Enfermedad {i+1}: {disease}")

if __name__ == "__main__":
    animal_manager = AnimalManager()
    animal_manager.register_animal()
    animal_manager.display_animals()
    animal_manager.delete_animal()
    animal_manager.search_animal_by_id()
