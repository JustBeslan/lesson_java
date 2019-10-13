package Ex_Extends;

import Ex_Extends2.penguin3;

import java.nio.channels.SelectionKey;

public class Brain {
    public static void main(String[] args) {
        Penguin Shkiper = new Penguin("Шкипер версия 2");
        penguin2 Kovalsky = new penguin2();
        penguin3 Rico = new penguin3();
        System.out.println(Shkiper.name+": "+Shkiper.age + " лет");
        System.out.println(Kovalsky.name+": "+ Kovalsky.age + " лет");
        System.out.println(Shkiper.realy_age);
        System.out.println(Kovalsky.realy_age);
        Shkiper.plan();
        Kovalsky.plan();
        System.out.println(Kovalsky.speed);
        System.out.println(Shkiper.speed);
        System.out.println(Rico.age);

        Penguin Prapor = new penguin2();
        Prapor.plan();
        System.out.println("age="+Prapor.realy_age);

        Shkiper.fight();
        Kovalsky.fight();

        Point3D p3 = new Point3D(1,2,3);
        p3.getX();

    }
}
