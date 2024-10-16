import java.util.Arrays;

public class Main {
    public static int myFunc(int x, int y) {
        for (int r; (r = x % y) != 0; x = y, y = r) { }
        return y;//ớc chung lớn nhất của x và y.
    }
    public static String switchCallMethod(DaysOfWeek day) {
        return(switch(day) {
            case Monday -> "first";
            default -> "rest";
        });
    }
    public static void main(String[] args) {
        System.out.println (
                switchCallMethod(DaysOfWeek.day1)
                        + " " +
                        switchCallMethod(DaysOfWeek.day2)
        );


        //khoi tao doi tuong
        /*
        Element element1 = new Element("element 01", 15);
        Element element2 = new Element("element 01", 12);
        System.out.println("element 1 compare to element 2 : ");
        System.out.println(element1.compareTo(element2));
        */
        int l = 0;
        int k = 5;
        for(; k > l; ) {
            //duyet cho den khi k <= l thi dung lai
            //neu KO thi tang l, giam k
            ++l;
            k--; //
        }
        System.out.println("k:" + k + " l:" +l); // Ausgabe 1)
        Element[] feld = {
                new Element("Lithium", 0.5f),
                new Element("Kupfer", 8.9f),
                new Element("Aluminium", 2.7f),
                new Element("Chrom", 7.1f)
        };
        Arrays.sort(feld);//sap xep ngay tren mang da cho
        //thuc chat la sap xep theo thu tu "Tang dan",
        //nhung trong ham compareTo(density nao nho hon la "LON HON")
        //ket qua cuoi cung => sap sep theo thu tu nguyen to, giam dan theo density
        System.out.println(feld[0] + " " + feld[1] + " " +
                feld[2] + " " + feld[3]); // Ausgabe 2)

        int[] arr1 = {24, -7, 123456, 25, -64};
        int[] arr2 = arr1;//reference
        /*
        int xx = 22;
        int yy = xx; //clone
        yy = 99;
        */
        for(int i=0;i < arr1.length;i++)
            arr1[i] = 10;
        System.out.println("1: " + arr2[2]); // Ausgabe 3)
        CallArray arr = new CallArray();//khoi tao 1 doi tuong CallArray
        arr2 = arr.arrayFunc(arr1);
        System.out.println("1: " + arr1[2] + " 2: " + arr2[2]); // Ausgabe 4)

        String[][] personen = {
                { "Maximilian", "Anzinger"},
                { "Rudiger", "Westermann" },
                { "Ali", "Kocal"}
        };
        String[] person = new String[2];
        person[0] = "Donald";
        person[1] = "Trump";
        personen[1] = person;
        for (int i = 0; i < personen.length; i++) {
            for (int j = 0; j < personen[i].length; j++) {
                System.out.print(personen[i][j] + " "); // Ausgabe 5)
            }
        }
        int myVal = myFunc(16,24);//USCLN cua 16, 24
        System.out.print("myVal: " + myVal); // Ausgabe 6)
        //8 la so lon nhat ma ca 16 va 24 deu chia het

        LinkedList list = new LinkedList();
        list.addNode(64);
        list.addNode(25);
        list.addNode(12);
        list.addNode(22);
        list.addNode(11);//da co danh sach lien ket ngon lanh
        list.doSomethingWithList();
        Node temp = list.head;
        while (temp != null) {
            //in ra danh sach lien ket, phan thu cuoi cung la phan tu co temp == null
            System.out.print(temp.data + " "); // Ausgabe 7)
            temp = temp.next;
        }
    }
}