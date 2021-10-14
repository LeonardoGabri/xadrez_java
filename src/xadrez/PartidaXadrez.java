package xadrez;

import boardgame.Peca;
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

    public PecaXadrez executarMovimento(PosicaoXadrez posicaoInicial, PosicaoXadrez posicaoAlvo ){
        Posicao inicio = posicaoInicial.toPosicao();
        Posicao alvo = posicaoAlvo.toPosicao();
        validandoPosicaoInicial(inicio);
        Peca pecaCapturada = fazerMovimento(inicio, alvo);
        return (PecaXadrez) pecaCapturada;
    }

    private void validandoPosicaoInicial (Posicao posicao){
        if (!tabuleiro.pecaNoLocal(posicao)){
            throw new excecaoXadrez("Não existe peça na posição de origem");
        }
        if (tabuleiro.peca(posicao).existeAlgumMovimentoPossivel()){
            throw new excecaoXadrez("Não existe movimentos possiveis para a peça escolhida");
        }
    }

    private Peca fazerMovimento(Posicao inicial, Posicao alvo){
        Peca p = tabuleiro.removerPeca(inicial);
        Peca capturada = tabuleiro.removerPeca(alvo);
        tabuleiro.lugarPeca(p, alvo);
        return capturada;
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
