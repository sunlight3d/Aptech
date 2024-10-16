public interface IPlayable {
    //trong interface chi chua cac function/method, ko chua phan thuc thi
    //interface can be "private" ? NO !, if YES, add implementation
    //interface can be "protected" ? NO
    //interface can be "default", "public" ? YES
    //protected, public, private,... => access modifier
    public void playAGame(String gameName);
    public void playFootball();
    //có nhiều function khác
    //interface can contain "static method" ? YES, but with body(implementation)
    public static void doAbc() {
        System.out.println("haha");
    }
    //interface can contain "static property" ? YES
    public static String MY_URL = "https://www.google.com";
    //interface can contain "instance property" ? NO
    //public String name; //NO!
}
