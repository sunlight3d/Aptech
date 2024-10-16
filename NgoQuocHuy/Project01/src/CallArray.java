class CallArray {
    static int[] arr = {24, -7, 123456, 25, -64};
    CallArray() {
        //ham khoi tao
        for(int i=0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println("haha");
       //[0, 1, 2, ...4]
    }
    int[] arrayFunc(int[] arr) {
        for(int i=0;i < arr.length;i++)
            arr[i] = 100;
        arr = this.arr;
        return arr;
    }

}