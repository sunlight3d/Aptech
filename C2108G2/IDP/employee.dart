import 'dart:io';

class Employee {
    String? id;
    String name;
    int workingDay;
    double dailySalary;
    Employee({
        this.id,
        required this.name,
        required this.workingDay,
        required this.dailySalary,
    });
    factory Employee.input() {
        print('Enter id: ');
        String id = stdin.readLineSync() ?? "";

        print('Enter name: ');
        String name = stdin.readLineSync() ?? "";
        int workingDay = 0;
        while(true) {
            print('Enter workingDay: ');
            workingDay = int.parse(stdin.readLineSync() ?? "0");
            if(workingDay > 1 && workingDay < 31) {
                break;
            }
        }
        double dailySalary = 0;
        while(true) {
            print('Enter dailySalary: ');
            dailySalary = double.parse(stdin.readLineSync() ?? "0");;
            if(dailySalary > 10 && dailySalary < 100) {
                break;
            }
        }
        return new Employee(id: id, name: name, workingDay: workingDay, dailySalary: dailySalary);
    }
    @override
  String toString() {
    // TODO: implement toString
    return 'id: ${id}, '
        'name: ${name}, '
        'workingDay: ${workingDay}, '
        'dailySalary: ${dailySalary}, '
    ;
  }
}