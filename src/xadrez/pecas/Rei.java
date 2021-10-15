package xadrez.pecas;

import boardgame.Peca;
import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

    public Rei(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro, color);
    }
    @Override
    public String toString(){
        return "R";
    }


    private boolean podeMover(Posicao posicao){
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][]mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0,0);
        //ACIMA
        p.setValor(posicao.getLinha() - 1, posicao.getColuna());
        if (getTabuleiro().posicaoExiste(p)&& podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //ABAIXO
        p.setValor(posicao.getLinha() + 1, posicao.getColuna());
        if (getTabuleiro().posicaoExiste(p)&& podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //DIREITA
        p.setValor(posicao.getLinha(), posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(p)&& podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //ESQUERDA
        p.setValor(posicao.getLinha(), posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExiste(p)&& podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //NORDESTE
        p.setValor(posicao.getLinha() - 1, posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(p)&& podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //NOROESTE
        p.setValor(posicao.getLinha() - 1, posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExiste(p)&& podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //SUDESTE
        p.setValor(posicao.getLinha() + 1, posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(p)&& podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //SUDOESTE
        p.setValor(posicao.getLinha() + 1, posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExiste(p)&& podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        return mat;
    }




}
