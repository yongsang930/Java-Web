package finaly;

import java.util.Scanner;
 
public class javacom{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         
        int one = scan.nextInt();
        int two = scan.nextInt();
         
        scan.close();
         
        boolean thr = one > two;
        boolean fou = one < two;
        boolean fiv = one >= two;
        boolean six = one <= two;
         
        System.out.printf("%d > %d --- %b\n", one, two, thr);
        System.out.printf("%d < %d --- %b\n", one, two, fou);
        System.out.printf("%d >= %d --- %b\n", one, two, fiv);
        System.out.printf("%d <= %d --- %b", one, two, six);
    }
}