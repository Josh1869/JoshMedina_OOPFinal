Project Overview:
The EcoCycle Manager is an interactive Java console application designed to help manage and track recycling materials, calculate their environmental impact, and generate reports. It allows users to input various types of recycling materials, customize their environmental impact factors, and manage them by adding, editing, or removing entries. The system provides valuable feedback by calculating and displaying the total environmental impact in terms of carbon dioxide (CO₂) emissions.

The program is designed with core Object-Oriented Programming (OOP) principles, which include:
Encapsulation: Using private fields and public getter/setter methods to control access to material data.
Inheritance: Extending a base class (RecyclingMaterial) with different subclasses (e.g., CustomMaterial).
Polymorphism: Allowing the calculateEnvironmentalImpact method to behave differently depending on the material type.
Abstraction: Abstracting the calculation logic into an abstract class while hiding implementation details in subclasses.

Key Features:
Interactive Menu System: The program operates with a menu that offers multiple choices, allowing users to interact with the system by selecting options to add, remove, edit, or view materials.
Customizable Material Types: Users can define their own material types and environmental impact factors. Unlike traditional static systems, this makes the application highly flexible.
Environmental Impact Calculation: Each material’s environmental impact is calculated by multiplying its weight by a user-defined impact factor, resulting in a CO₂ equivalent.
Material Management: Users can add materials with custom types and weights, edit existing materials, or remove them from the list. This gives them complete control over the data.
Impact Report Generation: The system generates a detailed environmental impact report based on the materials entered by the user, showing both individual material impacts and the total impact of all materials combined.

Detailed Breakdown of Program Components:
a. Class Structure:

1. RecyclingMaterial (Abstract Class):
This is the base class for all recycling materials. It holds common attributes such as materialType and weight (both private), and it includes getter and setter methods for these attributes (encapsulation).
The abstract method calculateEnvironmentalImpact() is defined here and will be overridden by the subclasses to calculate the material’s environmental impact.

2. CustomMaterial (Subclass):
This class extends the RecyclingMaterial class and is designed to handle custom materials that are defined by the user. It takes an additional parameter, impactFactor, which is used to calculate the environmental impact for that material.

3. RecyclingCenter (Manager Class):
The RecyclingCenter class manages a list of RecyclingMaterial objects. It provides methods to add, remove, and edit materials. It also has a method generateImpactReport() that calculates the total environmental impact and displays a report for all materials in the system.
The listMaterials() method helps users view all entered materials.

4. EcoCycleManager (Main Program):
The EcoCycleManager class is the main entry point to the application. It drives the interactive user interface by offering a menu and processing user input.
Based on the user’s choice, it either adds a new material, removes a material, edits a material, generates an impact report, or lists all materials.
The input is handled via a Scanner object that reads from the console.
Sustainable Development Goal (SDG) Alignment:
This program supports SDG 12: Responsible Consumption and Production, specifically Target 12.5 — By 2030, substantially reduce waste generation through prevention, reduction, recycling, and reuse. By helping individuals and organizations track and manage their recycling efforts, the program promotes waste reduction and responsible consumption practices.

User Interaction & Output:
The user interacts with the system by selecting menu options. Based on their choice, the program either:
Prompts them to input material data.
Displays a list of materials.
Shows an environmental impact report.
For example, if a user adds "Cardboard" with a weight of 20 kg and an impact factor of 0.9, the program will calculate the environmental impact as 20 * 0.9 = 18 kg CO₂. The program will then display the impact and update the report.

Conclusion:
The EcoCycle Manager program is a robust, flexible, and user-friendly application designed to help individuals and organizations manage recycling materials. By using OOP principles effectively, the program not only demonstrates good software design but also contributes to environmental sustainability by tracking the environmental impact of recycled materials.
