class Element implements Comparable<Element> {
    private String name;//thuoc tinh
    private float density;
    //ham khoi tao
    public Element(String name, float density) {
        this.name = name;
        this.density = density;
    }
    //getter. setter
    //Khi in doi tuong Element thi no se goi den ham toString
    public String toString() { return name; }
    public float getDensity() { return density; }
    public int compareTo(Element other) { //implement interface Comparable
        //so sanh 2 doi tuong Element
        //doi tuong A > doi tuong B neu co density <
        if(this.getDensity() > other.getDensity()) {
            return -1;
        }
        else if(this.getDensity() < other.getDensity()) {
            return 1;
        }
        else {
            //Hai doi tuong density duoc goi la bang nhau neu density giong nhau
            return 0;
        }
        //ten bat ky, ko so sanh ten
    }
}