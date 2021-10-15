package application;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.excecaoXadrez;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PartidaXadrez px = new PartidaXadrez();
        while (true) {
            try {
                UI.limpaTela();
                UI.imprimePartida(px);
                System.out.println();
                System.out.print("Inicial: ");
                PosicaoXadrez inicial = UI.lendoPosicaoXadrez(sc);
                boolean [][] movimentosPossiveis = px. movimentosPossiveis(inicial);
                UI.limpaTela();
                UI.imprimeTabuleiro(px.getPecas(), movimentosPossiveis);

                System.out.println();
                System.out.print("Alvo: ");
                PosicaoXadrez alvo = UI.lendoPosicaoXadrez(sc);

                PecaXadrez pecaCapturada = px.executarMovimento(inicial, alvo);
            }catch (excecaoXadrez e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }


    }
}
