#include <stdio.h>
#include <string.h>

typedef struct {
    char name[100]; // Assuming a name length of up to 100 characters
    float price;
    int quantity;
} Product;
Product inventory[5];

void displayProduct(const Product* p) {
    printf("Name: %s, Price: $%.2f, Quantity: %d\n", p->name, p->price, p->quantity);
}
Product* findMostExpensiveProduct(Product* products, int count) {
    if (count == 0) return NULL;
    Product* mostExpensive = &products[0];
    for (int i = 1; i < count; i++) {
        if (products[i].price > mostExpensive->price) {
            mostExpensive = &products[i];
        }
    }
    return mostExpensive;
}
void searchProductByName(Product* products, int count, const char* name) {
    for (int i = 0; i < count; i++) {
        if (strcmp(products[i].name, name) == 0) {
            displayProduct(&products[i]);
            return;
        }
    }
    printf("Product not found.\n");
}
float calculateTotalInventoryValue(Product* products, int count) {
    float total = 0;
    for (int i = 0; i < count; i++) {
        total += products[i].price * products[i].quantity;
    }
    return total;
}
Product* findProductWithLowestQuantity(Product* products, int count) {
    if (count == 0) return NULL;
    Product* lowestQuantity = &products[0];
    for (int i = 1; i < count; i++) {
        if (products[i].quantity < lowestQuantity->quantity) {
            lowestQuantity = &products[i];
        }
    }
    return lowestQuantity;
}
void sortProductsByPrice(Product* products, int count) {
    for (int i = 0; i < count - 1; i++) {
        for (int j = i + 1; j < count; j++) {
            if (products[i].price > products[j].price) {
                Product temp = products[i];
                products[i] = products[j];
                products[j] = temp;
            }
        }
    }
}
float calculateAveragePrice(Product* products, int count) {
    if (count == 0) return 0.0f;
    float sum = 0;
    for (int i = 0; i < count; i++) {
        sum += products[i].price;
    }
    return sum / count;
}

int main() {
    int choice;
    int count = 0; // To keep track of the number of products

    do {
        printf("1. Add a new product\n2. Display product information\n3. Update product quantity\n4. Quit\nEnter your choice: ");
        scanf("%d", &choice);
        getchar(); // consume the newline character

        switch(choice) {
            case 1:
                if (count < 5) {
                    printf("Enter product name: ");
                    fgets(inventory[count].name, 100, stdin);
                    inventory[count].name[strcspn(inventory[count].name, "\n")] = 0; // Remove newline character
                    printf("Enter price: ");
                    scanf("%f", &inventory[count].price);
                    printf("Enter quantity: ");
                    scanf("%d", &inventory[count].quantity);
                    count++;
                } else {
                    printf("Inventory full.\n");
                }
                break;
            case 2:
                for (int i = 0; i < count; i++) {
                    displayProduct(&inventory[i]);
                }
                break;
            case 3:
                if (count > 0) {
                    char name[100];
                    printf("Enter product name to update quantity: ");
                    fgets(name, 100, stdin);
                    name[strcspn(name, "\n")] = 0; // Remove newline character

                    for (int i = 0; i < count; i++) {
                        if (strcmp(inventory[i].name, name) == 0) {
                            printf("Enter new quantity: ");
                            scanf("%d", &inventory[i].quantity);
                            break;
                        }
                    }
                } else {
                    printf("No products to update.\n");
                }
                break;
            case 4:
                printf("Quitting...\n");
                break;
            default:
                printf("Invalid choice.\n");
        }
    } while (choice != 4);

    return 0;
}
