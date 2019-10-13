package Ex_Extends;

public class penguin2 extends Penguin {
    public
        int age = 15;
    public
        int realy_age = 43;
    String name = "Ковальски";

    public
        penguin2(){
            super("Шкипер");
            System.out.println("Для "+this.name+": "+super.name);
        }

    public
    void plan(){
        System.out.println("Это голодный и злой 4ый курс ФПМа после 8ми пар с утра.");
        System.out.println("Я понятия не имею, что будет. Спроси,что полегче. Похоже, это вообще, наша последняя битва(((");
//        System.out.println(super.realy_age);
//        System.out.println(this.realy_age);
        super.fight();
    }
}
