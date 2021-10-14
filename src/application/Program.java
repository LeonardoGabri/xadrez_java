package application;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadrez.PartidaXadrez;


public class Program {
    public static void main(String[] args) {
        PartidaXadrez px = new PartidaXadrez();
        UI.imprimeTabuleiro(px.getPecas());


    }
}
