package aptech.data;
public interface IDocument {
    //int x; //interface cannot contain instance properties
    public static final int xx = 1; //but static is ok
    void input();//only method definition, cannot be private,protected
    void show();
}
