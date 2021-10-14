package xadrez.pecas;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

    public Torre(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro, color);
    }

    @Override
    public String toString(){
        return "T";
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][]mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

        Posicao p = new Posicao(0,0);

        //Acima
        p.setValor(posicao.getLinha()-1, posicao.getColuna());
        while(getTabuleiro().posicaoExiste(p)&& !getTabuleiro().pecaNoLocal(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() - 1);
        }
        if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //Esquerda
        p.setValor(posicao.getLinha(), posicao.getColuna()-1);
        while(getTabuleiro().posicaoExiste(p)&& !getTabuleiro().pecaNoLocal(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() - 1);
        }
        if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //direita
        p.setValor(posicao.getLinha(), posicao.getColuna()+1);
        while(getTabuleiro().posicaoExiste(p)&& !getTabuleiro().pecaNoLocal(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() + 1);
        }
        if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //Baixo
        p.setValor(posicao.getLinha()+1, posicao.getColuna());
        while(getTabuleiro().posicaoExiste(p)&& !getTabuleiro().pecaNoLocal(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() + 1);
        }
        if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        return mat;
    }
}
