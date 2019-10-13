package Ex_Extends2;

import Ex_Extends.Penguin;
import Ex_Extends.penguin2;

public class penguin3 extends penguin2 {
    public int age;
    String name = "Рико";

    public penguin3(){
//            super("Шкипер");
            this.age = super.realy_age;
            System.out.println(this.age);
        }

    public void plan(){
        System.out.println("бебумаргопваа");
        super.fight();
    }
}
