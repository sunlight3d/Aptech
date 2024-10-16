#include <iostream>
#include <cmath> // Thư viện để sử dụng hàm M_PI

int main() {
    double radius, height, volume;

    // Nhập bán kính và chiều cao của hình trụ
    std::cout << "Enter the radius of the cylinder: ";
    std::cin >> radius;
    std::cout << "Enter the height of the cylinder: ";
    std::cin >> height;

    // Tính toán thể tích của hình trụ
    volume = M_PI * radius * radius * height;

    /*In thể tích của hình trụ*/    
    std::cout << "The volume of the cylinder is: " << volume << std::endl;

    return 0;
}
