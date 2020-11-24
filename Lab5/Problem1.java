package Lab5;

public class Problem1 {
    public static void main(String[] args) {
       Hacker [] hackers = new Hacker[3];
       hackers[0] = new Hacker("ABCD",20);
       hackers[1] = new Hacker("ABCD",30);
       hackers[2] = new Hacker("ABCD",40);
        System.out.println("Average System Compromises = " + (hackers[0].getSystemCompro()+hackers[1].getSystemCompro()+hackers[2].getSystemCompro())/3);
    }
}
class Hacker{
    String name;
    int systemCompro;

    public Hacker(String name, int systemCompro) {
        this.name = name;
        this.systemCompro = systemCompro;
    }

    public int getSystemCompro() {
        return systemCompro;
    }
}
