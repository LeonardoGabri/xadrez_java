package application;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PartidaXadrez px = new PartidaXadrez();
        while (true) {
            UI.imprimeTabuleiro(px.getPecas());
            System.out.println();
            System.out.print("Inicial: ");
            PosicaoXadrez inicial = UI.lendoPosicaoXadrez(sc);
            System.out.println();
            System.out.print("Alvo: ");
            PosicaoXadrez alvo = UI.lendoPosicaoXadrez(sc);

            PecaXadrez pecaCapturada = px.executarMovimento(inicial, alvo);
        }


    }
}
