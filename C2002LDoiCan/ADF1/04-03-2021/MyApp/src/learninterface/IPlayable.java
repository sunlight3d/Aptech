/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learninterface;

public interface IPlayable {
    public void playFootball();
    public void playGame(String gameName);
    //Phuong thuc trong interface phai la public hoac default
    //Phuong thuc trong interface ko chua phan thuc thi
    //Interface co the chua instance field ?
    //public int x;//NO!
    //Interface co the chua static field dc ko ?
    public static int x = 10;//YES    
}
