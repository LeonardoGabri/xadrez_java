package xadrez;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;

    public PartidaXadrez(){
        tabuleiro = new Tabuleiro(8,8);
        configuracaoInicial();
    }

    public PecaXadrez[][]getPecas(){
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0;i < tabuleiro.getLinhas();i++){
            for (int j = 0; j < tabuleiro.getColunas();j++){
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
            }
        }
        return mat;
    }

    private void lugarNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());

    }

    private void configuracaoInicial(){
        lugarNovaPeca('c', 1,new Torre(tabuleiro, Color.BRANCO));
        lugarNovaPeca('c', 2,new Torre(tabuleiro, Color.BRANCO));
        lugarNovaPeca('d', 2,new Torre(tabuleiro, Color.BRANCO));
        lugarNovaPeca('e', 2,new Torre(tabuleiro, Color.BRANCO));
        lugarNovaPeca('e', 1,new Torre(tabuleiro, Color.BRANCO));
        lugarNovaPeca('d', 1,new Rei(tabuleiro, Color.BRANCO));

        lugarNovaPeca('c', 7,new Torre(tabuleiro, Color.PRETO));
        lugarNovaPeca('c', 8,new Torre(tabuleiro, Color.PRETO));
        lugarNovaPeca('d', 7,new Torre(tabuleiro, Color.PRETO));
        lugarNovaPeca('e', 7,new Torre(tabuleiro, Color.PRETO));
        lugarNovaPeca('e', 8,new Torre(tabuleiro, Color.PRETO));
        lugarNovaPeca('d', 8,new Rei(tabuleiro, Color.PRETO));


    }
}
