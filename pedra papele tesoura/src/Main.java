import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao jogo Pedra, Papel e Tesoura!");

        while (true) {
            System.out.println("Escolha: 1 para Pedra, 2 para Papel e 3 para Tesoura (ou 0 para sair)");
            int playerChoice = scanner.nextInt();

            if (playerChoice == 0) {
                System.out.println("Obrigado por jogar!");
                break;
            }

            int computerChoice = getRandomChoice();

            System.out.println("Você escolheu: " + choiceToString(playerChoice));
            System.out.println("O computador escolheu: " + choiceToString(computerChoice));

            int result = getResult(playerChoice, computerChoice);
            if (result == 0) {
                System.out.println("Empate");
            } else if (result == 1) {
                System.out.println("Você ganhou");
            } else {
                System.out.println("Você perdeu");
            }
        }

        scanner.close();
    }

    public static int getRandomChoice() {
        return (int) (Math.random() * 3) + 1;
    }

    public static String choiceToString(int choice) {
        switch (choice) {
            case 1:
                return "Pedra";
            case 2:
                return "Papel";
            case 3:
                return "Tesoura";
            default:
                return "Escolha inválida";
        }
    }

    public static int getResult(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return 0;
        } else if ((playerChoice == 1 && computerChoice == 3) ||
                (playerChoice == 2 && computerChoice == 1) ||
                (playerChoice == 3 && computerChoice == 2)) {
            return 1;
        } else {
            return -1;
        }
    }
}
