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
        animal_type = input("Enter animal type: ")
        id = random.randint(1, 200)
        self.validate_id(id)
        birth_date = input("\nEnter birth date in the format Day/Month/Year: ")
        arrival_date = input("\nEnter arrival date in the format Day/Month/Year: ")
        weight = float(input("\nEnter weight: "))
        feeding_frequency = input("\nEnter feeding frequency: ")
        feeding_types = input("\nEnter feeding types: ")
        vaccinated = input("\nHas vaccinations 'Yes' No vaccinations 'No': ")
        vaccinated = vaccinated == "Yes"
        diseases = []
        disease = input("\nEnter diseases, when finished enter 'Fin': ")
        while disease != "Fin":
            diseases.append(disease)
            disease = input("Enter disease: ")

        animal = Animales(animal_type, id, birth_date, arrival_date, weight, feeding_frequency, feeding_types, vaccinated)
        animal.set_diseases(diseases)
        self.animals.append(animal)

    def display_animals(self):
        for animal in self.animals:
            print(f"Animal type: {animal.animal_type}")
            print(f"ID: {animal.id}")
            print(f"Birth date: {animal.birth_date}")
            print(f"Arrival date: {animal.arrival_date}")
            print(f"Weight: {animal.weight:.2f} kg")
            print(f"Feeding frequency: {animal.feeding_frequency}")
            print(f"Feeding types: {animal.feeding_types}")
            print(f"Vaccinated: {animal.vaccinated}")
            for i, disease in enumerate(animal.diseases):
                print(f"Disease {i+1}: {disease}")

    def validate_id(self, id: int):
        for animal in self.animals:
            if animal.id == id:
                id = random.randint(1, 200)
                self.validate_id(id)
                return

    def delete_animal(self):
        for i, animal in enumerate(self.animals):
            print(f"\n{i+1} Animal: {animal.animal_type}")
        option = int(input("Enter the number of the animal to delete: "))
        self.animals.pop(option-1)

    def search_animal_by_id(self):
        id = int(input("Enter the animal ID: "))
        print()
        for animal in self.animals:
            if animal.id == id:
                print(f"Animal type: {animal.animal_type}")
                print(f"ID: {animal.id}")
                print(f"Birth date: {animal.birth_date}")
                print(f"Arrival date: {animal.arrival_date}")
                print(f"Weight: {animal.weight:.2f} kg")
                print(f"Feeding frequency: {animal.feeding_frequency}")
                print(f"Feeding types: {animal.feeding_types}")
                print(f"Vaccinated: {animal.vaccinated}")
                for i, disease in enumerate(animal.diseases):
                    print(f"Disease {i+1}: {disease}")

if __name__ == "__main__":
    animal_manager = AnimalManager()
    animal_manager.register_animal()
    animal_manager.display_animals()
    animal_manager.delete_animal()
    animal_manager.search_animal_by_id()
