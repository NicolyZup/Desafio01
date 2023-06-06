// Você deve gerar um número aleatório e comparar com a resposta vinda do usuário. Caso seja
// o mesmo número o usuário ganha 10 pontos, caso seja número diferente o programa deve comparar
// para saber se o número está 1 acima ou 1 abaixo do número sorteado, caso esteja o usuário ganha
// 5 pontos, caso não esteja o usuário apenas perde. No fim deverá ser exibida a pontuação do usuário.
// Tudo via console.
// Entrega Mínima: O sistema sorteia o número e realiza todas as comparações, no final ele exibe a pontuação
// correta.
// Entrega Média: O sistema permite jogar mais de uma vez e soma todas as pontuações.
// Entrega Máxima: O sistema permite adicionar nível de dificuldade de alguma forma e exibe, além da pontuação,
// os números que o usuário errou e acertou.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Desafio01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        List<Integer> numUsuario = new ArrayList<>();

        System.out.println("BEM VINDO(A) AO JOGO!");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Regras : \r\n- Se seu número for 1 acima que o número da máquina: você ganha 5 pontos\r\n- Se seu número for 1 abaixo que o número da máquina: você ganha 5 pontos\r\n- Se seu número for igual ao número da máquina: você ganha 10 pontos\r\n- Caso contrário das regras acima você apenas perde");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Informe o número do nível desejado do jogo:");
        System.out.println("(1)Baixo - números de 0 a 10 \r\n(2)Médio - números de 0 a 100 \r\n(3)Alto - números de 0 a 1.000");
        int nivelInformado = entrada.nextInt();

        int pontuacao = 0;
        boolean jogarNovamente= true;
        int nivel = 0;

        switch (nivelInformado){
            case 1:
                nivel =10;
                break;
            case 2:
                nivel = 100;
                break;
            case 3:
                nivel = 1000;
                break;
            default:
                System.out.println("Nível informado inválido.");
        }

        while(jogarNovamente){

            Random gerador = new Random();
            int numGerado = gerador.nextInt(nivel);

            System.out.println("Informe um número aleatório de 0 a " + nivel + ":");
            int numInformado = entrada.nextInt();;

            if (numInformado == numGerado){
                pontuacao += 10;
                numUsuario.add(numInformado);
                System.out.println("Você ganhou :)");
            } else if (numInformado == numGerado -1) {
                pontuacao += 5;
                System.out.println("Chegou perto: 5 pontos");
            } else if (numInformado == numGerado +1) {
                pontuacao += 5;
                System.out.println("Chegou perto: 5 pontos");
            } else {
                System.out.println("Você perdeu :(");
            }

            System.out.println("Seu número: " + numInformado);
            System.out.println("Sua pontuação: " + pontuacao);

            System.out.println("----------------------------------");
            System.out.println("Deseja jogar novamente? 1-Sim, 2-Não");
            int jogar = entrada.nextInt();

            if(jogar !=1){
                jogarNovamente = false;
            }
        }

        System.out.println("------------------------------");
        System.out.println("Fim de jogo!");
        System.out.println("Seus acertos: " + numUsuario);
        System.out.println("Sua pontuação: " + pontuacao);
    }
}
