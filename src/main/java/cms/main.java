package cms;
import java.util.InputMismatchException;
import java.util.Scanner;
public class main {

	  public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
        int count = 0;
    	int x;
        TUI ui = new TUI();

        TuiList inter = new TuiList();

       System.out.println("==========================================================");
       System.out.println("Você deseja armazenar os dados no HSQL ou no LINKEDLIST ?");
       System.out.println("==========================================================");
       System.out.println("Digite 1 para HSQL");
       System.out.println("Digite 2 para LinkedList");
       System.out.println("==========================================================");

       while(count == 0){
       try{
       x= scan.nextInt();
       switch (x) {
       case 1:
            ui.start();
            count++;
       case 2 : inter.start();
            count++;
       }
      } catch (InputMismatchException e) {
           System.out.println("Opção inválida. Digite novamente.");
           scan.next(); // Limpar o buffer do Scanner
           continue;
       }}
}}
