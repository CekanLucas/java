package learning.basic;

public class ForLoop {
    public static void main(String[] args) {
        int firstBadGuy = 4;
        int secondBadGuy = 6;

        for(int i=0;i<7;i++){
            if(firstBadGuy==i || secondBadGuy==i){
                System.out.println("Bad guy\t\t\t" + i);
            } else {
                System.out.println("Good guy\t\t" + i);
            }
        }
    }
}
