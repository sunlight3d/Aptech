class LinkedList {
    //Quan ly danh sach lien ket
    Node head;//Tham chieu den phan tu hien tai
    public LinkedList() {
        this.head = null;//khoi tao danh sasch lien ket rong
    }
    public void addNode(int data) {
        //them phan tu vao danh sach lien ket
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void doSomethingWithList() {
        //sap xep linklist
        Node current = head;
        while (current != null) {
            Node node = current;
            Node temp = current.next;
            while (temp != null) {
                if (temp.data > node.data) {
                    node = temp;
                }
                temp = temp.next;
            }

            //doi cho, swap
            int tempData = current.data;
            current.data = node.data;
            node.data = tempData;
            current = current.next;
        }
    }
}
