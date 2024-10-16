<?php 
class Task {
    private int $id; // fields
    private string $name;
    private float $price;
    private int $quantity;

    // Constructor
    public function __construct(
        int $id,
        string $name,
        float $price,
        int $quantity
    ) {
        $this->id = $id;
        $this->name = $name;
        $this->price = $price;
        $this->quantity = $quantity;
    }

    public function getTotalPrice(): float {
        return $this->price * $this->quantity;
    }
}

?>