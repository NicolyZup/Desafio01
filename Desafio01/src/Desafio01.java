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
        List<Integer> numComputador =new ArrayList<>();

        System.out.println("BEM VINDO(A) AO JOGO!");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Regras : \r\n- Se seu número for maior que o número da máquina: você ganha 5 pontos\r\n- Se seu número for menor que o número da máquina você apenas perde\r\n- Se seu número for igual ao número da máquina: você ganha 10 pontos");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Informe o número do nível desejado do jogo:");
        System.out.println("(1)Baixo - números de 0 a 10 \r\n(2)Médio - números de 0 a 100 \r\n(3)Alto - números de 0 a 1.000");
        int nivelInformado = entrada.nextInt();

        int pontuacao = 0;
        int contador = 1;
        int numInformado = 0;
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

        while(contador >= 1){
            Random gerador = new Random();
            int numGerado = gerador.nextInt(nivel);
            numComputador.add(numGerado);

            System.out.println("Informe um número aleatório de 0 a " + nivel + ":");
            numInformado = entrada.nextInt();
            numUsuario.add(numInformado);

            if (numInformado == numGerado){
                pontuacao += 10;
            } else if (numInformado > numGerado) {
                pontuacao += 5;
            } else {
                System.out.println("Você perdeu :(");
            }

            System.out.println("Seu número: " + numInformado);
            System.out.println("Número da máquina: " + numGerado);
            System.out.println("Sua pontuação: " + pontuacao);

            System.out.println("----------------------------------");
            System.out.println("Deseja jogar novamente? 1-Sim, 2-Não");
            int jogarNovamente = entrada.nextInt();

            if(jogarNovamente ==1){
                contador += 1;
            } else {
                contador = 0;
            }
        }

        System.out.println("------------------------------");
        System.out.println("Fim de jogo!");
        System.out.println("Seus números: " + numUsuario);
        System.out.println("Números da máquina: " + numComputador);
        System.out.println("Sua pontuação: " + pontuacao);
    }
}
