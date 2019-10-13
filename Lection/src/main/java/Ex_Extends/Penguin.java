package Ex_Extends;

public class Penguin {
    public
        int speed = 100;
    public
        int age = 130;
//    private
    protected
        int realy_age = 31;

    String name;

    public
        Penguin(String name){
            this.name = name;
        }

    public
        void plan(){
            System.out.println("Я смотрел недавно Пингвинов из Мадагаскара, поэтому :");
            System.out.println("Ковальски, каковы шансы выжить?");
        }
    public
        static
            void fight(){
        System.out.println("Я еще и драться умею)))");
    }
}
