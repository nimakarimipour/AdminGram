/**
 *  Created by nima on 5/23/16.
 */

public class TestCode {
    public static void main(String[] args) {
        Child child = new Child();
        child.printSuperAge();
    }
}


class Child extends Father{
    int age = 10;

    public void printAge(){
        System.out.println(age);
    }

    public void printSuperAge(){
        System.out.println(super.age);
    }
}

class Father{
    int age = 20;
}
