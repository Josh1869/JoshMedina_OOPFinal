Recycling Management System 🌍♻️
Overview
The Recycling Management System is a command-line application designed to manage and track different types of recyclable materials, calculate their environmental impact, and generate reports. The system utilizes Object-Oriented Programming (OOP) principles such as inheritance, polymorphism, encapsulation, and abstraction for a structured and scalable approach to managing recycling data.

Features
Add new recyclable materials with custom details (material type, weight, environmental impact factor).
Edit and remove existing materials.
List all materials currently stored in the system.
Generate an environmental impact report, displaying the individual and total environmental impact of all materials.
Implemented using Object-Oriented Programming (OOP) concepts such as Abstraction, Inheritance, Encapsulation, and Polymorphism.
OOP Design Principles Used
1. Abstraction 🤔
The system uses an abstract class RecyclingMaterial to represent the general concept of a recyclable material. The abstract method calculateEnvironmentalImpact() forces subclasses to provide their specific implementations of the environmental impact calculation, depending on the type of material.

2. Inheritance 📚
The CustomMaterial class extends RecyclingMaterial, inheriting its properties and methods. By doing so, we can easily create new types of materials while still maintaining the basic structure provided by the base class.

3. Encapsulation 🔒
All properties of materials, such as materialType and weight, are encapsulated within the RecyclingMaterial class, with getters and setters provided to access and modify these properties. This ensures that the data is protected and can only be accessed through the proper methods.

4. Polymorphism 🔄
The method calculateEnvironmentalImpact() is overridden in the CustomMaterial class. This allows us to create different material types that can all be treated as RecyclingMaterial objects, yet behave differently when calculating their environmental impact.

Class Structure
1. RecyclingMaterial (Abstract Class)
Attributes:
materialType: The type of material (e.g., Plastic, Paper, etc.).
weight: The weight of the material in kilograms.
Methods:
calculateEnvironmentalImpact(): An abstract method that must be implemented by subclasses.
displayMaterialInfo(): Displays the details of the material (material type and weight).
2. CustomMaterial (Subclass of RecyclingMaterial)
Attributes:

impactFactor: A factor that determines how much environmental impact is caused by the material.
Methods:

calculateEnvironmentalImpact(): Calculates the environmental impact of the material based on its weight and impact factor.
3. RecyclingCenter
Attributes:
materials: A list that stores all recyclable materials.
Methods:
addMaterial(RecyclingMaterial material): Adds a material to the system.
removeMaterial(int index): Removes a material from the system.
editMaterial(int index, String newMaterialType, double newWeight): Edits the details of a material.
generateImpactReport(): Calculates and displays the total environmental impact of all materials in the system.
listMaterials(): Lists all materials currently in the system.
4. RecyclingManagementSystem (Main Program Class)
Attributes:

scanner: A Scanner object used for taking user input.
center: An instance of RecyclingCenter that manages all materials.
Methods:

main(): The entry point of the application, which presents the user with a menu of actions.
showMenu(): Displays the main menu with options for adding, removing, and editing materials.
addMaterial(): Prompts the user to input details of a new material and adds it to the system.
removeMaterial(): Prompts the user to remove a material from the system.
editMaterial(): Prompts the user to edit the details of an existing material.
