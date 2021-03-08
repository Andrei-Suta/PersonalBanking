import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        ContBancar obj = new ContBancar("Suta Andrei-Radu", 4429);
        obj.sold = 6000.00;
        DecimalFormat formatBani = new DecimalFormat("###,##0.00");
        obj.Meniu();
    }
}

class ContBancar {
    double sold;
    String ultimaTranzactie;
    String titular;
    int  id;

    ContBancar(String tit, int i){
        titular = tit;
        id = i;
        ultimaTranzactie = "Nu a fost gasita nicio tranzactie!";
    }


    void depunere(double suma){
        if (suma > 0) {
            sold = sold + suma;
            ultimaTranzactie = "Ati depus in cont suma de "+suma+" lei"; //afisam string-ul ultimaTranzactie ca mesaj pe ecran ca si confirmare
            System.out.println(ultimaTranzactie);

        }

    }

    void retragere(double suma){
        if(suma > 0){
            sold = sold - suma;
            ultimaTranzactie = "Ati retras suma de "+suma+" lei";
            System.out.println(ultimaTranzactie); //afisam string-ul ultimaTranzactie ca mesaj pe ecran ca si confirmare
        }
    }

    String getUltimaTranzactie(){
        return ultimaTranzactie;
    }

    void Meniu(){
        Scanner scanner = new Scanner(System.in);
        int optiune = 0;
        int pin = 4429;
        System.out.println("Bine ati venit, " + titular+"!");
        System.out.println("Introduceti PIN-ul ");
        int x = scanner.nextInt();
        if(x != pin){
            System.out.println("PIN incorect, va rugam incercati din nou!");
            System.exit(0);
        }
        System.out.println("\n");
        System.out.println("PIN corect! Alegeti optiunea dorita:");
        System.out.println("\n");
        System.out.println("1. Afisarea soldului pe ecran");
        System.out.println("2. Depuneti o suma in cont");
        System.out.println("3. Retrageti o suma din cont");
        System.out.println("4. Verificat tranzactia precedenta");
        System.out.println("5. Iesire");

        do {
            System.out.println("==============================================");
            System.out.println("Alegeti optiunea pe care o doriti:");
            System.out.println("==============================================");
            optiune = scanner.nextInt();
            System.out.println("\n");

            switch(optiune){
                case 1:
                    System.out.println("---------------------------------------");
                    System.out.println("Fonduri disponibile: "+ sold);
                    System.out.println("---------------------------------------");
                    System.out.println("\n");
                    break;

                case 2:
                    System.out.println("---------------------------------------");
                    System.out.println("Introduceti suma pe care doriti sa o depozitati");
                    System.out.println("---------------------------------------");
                    double suma = scanner.nextDouble();
                    depunere(suma);
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.println("---------------------------------------");
                    System.out.println("Introduceti suma pe care doriti sa o retargeti");
                    System.out.println("---------------------------------------");
                    double retragere = scanner.nextDouble();
                    if(sold < retragere){
                        System.out.println("Fonduri insuficiente!");
                        break;
                    }
                    retragere(retragere);
                    break;

                case 4:
                    System.out.println("---------------------------------------");
                    System.out.println(getUltimaTranzactie());
                    System.out.println("---------------------------------------");

                case 5:
                    System.out.println("****************************************");
                    break;

                default:
                    System.out.println("Optiune invalida! Va rugam sa incercati din nou");
                    break;



            }
        }while(optiune != 5);
        System.out.println("Va multumim!");
        System.out.println("O zi buna, "+ titular);
    }


}
