#include <iostream>
#include <string>

using namespace std;

// Structure to represent an Employee
struct Employee {
    string name;
    int ID;
    double salary;
};

// Function to add an employee
void addEmployee(Employee employees[], int& numEmployees) {
    if (numEmployees < 100) {
        cout << "Enter employee name: ";
        cin >> employees[numEmployees].name;
        cout << "Enter employee ID: ";
        cin >> employees[numEmployees].ID;
        cout << "Enter employee salary: ";
        cin >> employees[numEmployees].salary;
        numEmployees++;
        cout << "Employee added successfully." << endl;
    } else {
        cout << "Maximum number of employees reached." << endl;
    }
}

// Function to delete an employee
void deleteEmployee(Employee employees[], int& numEmployees) {
    int ID;
    cout << "Enter employee ID to delete: ";
    cin >> ID;
    bool found = false;
    for (int i = 0; i < numEmployees; i++) {
        if (employees[i].ID == ID) {
            for (int j = i; j < numEmployees - 1; j++) {
                employees[j] = employees[j + 1];
            }
            numEmployees--;
            found = true;
            cout << "Employee deleted successfully." << endl;
            break;
        }
    }
    if (!found) {
        cout << "Employee not found." << endl;
    }
}

// Function to update an employee
void updateEmployee(Employee employees[], int& numEmployees) {
    int ID;
    cout << "Enter employee ID to update: ";
    cin >> ID;
    bool found = false;
    for (int i = 0; i < numEmployees; i++) {
        if (employees[i].ID == ID) {
            cout << "Enter new employee name: ";
            cin >> employees[i].name;
            cout << "Enter new employee salary: ";
            cin >> employees[i].salary;
            found = true;
            cout << "Employee updated successfully." << endl;
            break;
        }
    }
    if (!found) {
        cout << "Employee not found." << endl;
    }
}

// Function to display all employees
void displayEmployees(const Employee employees[], int numEmployees) {
    if (numEmployees == 0) {
        cout << "No employees to display." << endl;
    } else {
        cout << "Employee Records:" << endl;
        for (int i = 0; i < numEmployees; i++) {
            cout << "Name: " << employees[i].name << ", ID: " << employees[i].ID << ", Salary: " << employees[i].salary << endl;
        }
    }
}

int main13() {
    const int MAX_EMPLOYEES = 100; // Maximum number of employees
    Employee employees[MAX_EMPLOYEES]; // Array to store employees
    int numEmployees = 0; // Current number of employees

    int choice;
    do {
        // Display menu
        cout << "\nEmployee Records Management Program" << endl;
        cout << "1. Add Employee" << endl;
        cout << "2. Delete Employee" << endl;
        cout << "3. Update Employee" << endl;
        cout << "4. Display Employees" << endl;
        cout << "5. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                addEmployee(employees, numEmployees);
                break;
            case 2:
                deleteEmployee(employees, numEmployees);
                break;
            case 3:
                updateEmployee(employees, numEmployees);
                break;
            case 4:
                displayEmployees(employees, numEmployees);
                break;
            case 5:
                cout << "Exiting program." << endl;
                break;
            default:
                cout << "Invalid choice. Please try again." << endl;
        }
    } while (choice != 5);

    return 0;
}
