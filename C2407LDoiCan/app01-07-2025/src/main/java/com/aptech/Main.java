package com.aptech;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Playable aPerson = new Playable() {
            @Override
            public void goSwimming() {

            }

            @Override
            public void playTennis() {

            }
        };
        /*
        javascript:
        const sum = (x,y) => x + y;
        const filteredPersons = persons.filter(person => person.age > 18)
        * */
        final ICalculation sumObject = new ICalculation() {
            @Override
            public int sum(int x, int y) {
                return x + y;
            }
        } ;
    }

}