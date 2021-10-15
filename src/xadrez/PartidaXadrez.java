package xadrez;

import boardgame.Peca;
import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

import java.util.ArrayList;
import java.util.List;

public class PartidaXadrez {
    private  int turno;
    private Color jogadorAtual;
    private Tabuleiro tabuleiro;

    private List<Peca> pecasDentroTabuleiro = new ArrayList<>();
    private List<Peca> pecasCapturadas = new ArrayList<>();

    public PartidaXadrez(){
        tabuleiro = new Tabuleiro(8,8);
        turno = 1;
        jogadorAtual = Color.BRANCO;
        configuracaoInicial();
    }

    public int getTurno() {
        return turno;
    }

    public Color getJogadorAtual() {
        return jogadorAtual;
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

    public boolean[][] movimentosPossiveis (PosicaoXadrez inicioPosicao){
        Posicao posicao= inicioPosicao.toPosicao();
        validandoPosicaoInicial(posicao);
        return tabuleiro.peca(posicao).movimentosPossiveis();
    }

    public PecaXadrez executarMovimento(PosicaoXadrez posicaoInicial, PosicaoXadrez posicaoAlvo ){
        Posicao inicio = posicaoInicial.toPosicao();
        Posicao alvo = posicaoAlvo.toPosicao();
        validandoPosicaoInicial(inicio);
        validandoPosicaoDestino(inicio, alvo);
        Peca pecaCapturada = fazerMovimento(inicio, alvo);
        proximoTurno();
        return (PecaXadrez) pecaCapturada;
    }

    private void validandoPosicaoInicial (Posicao posicao){
        if (!tabuleiro.pecaNoLocal(posicao)){
            throw new excecaoXadrez("Não existe peça na posição de origem");
        }
        if (jogadorAtual != ((PecaXadrez)tabuleiro.peca(posicao)).getColor()){
            throw new excecaoXadrez("A peça escolhida não é sua");
        }
        if (!tabuleiro.peca(posicao).existeAlgumMovimentoPossivel()){
            throw new excecaoXadrez("Não existe movimentos possiveis para a peça escolhida");
        }
    }

    private void validandoPosicaoDestino(Posicao inicio, Posicao alvo){
        if(!tabuleiro.peca(inicio).movimentoPossivel(alvo)){
            throw new excecaoXadrez("A peça escolhida não pode se mover para posição alvo");
        }
    }

    private void proximoTurno(){
        turno++;
        jogadorAtual = (jogadorAtual == Color.BRANCO) ? Color.PRETO : Color.BRANCO;
    }

    private Peca fazerMovimento(Posicao inicial, Posicao alvo){
        Peca p = tabuleiro.removerPeca(inicial);
        Peca capturada = tabuleiro.removerPeca(alvo);
        tabuleiro.lugarPeca(p, alvo);
        if (capturada!= null){
            pecasDentroTabuleiro.remove(pecasCapturadas);
            pecasCapturadas.add((Peca) pecasCapturadas);
        }
        return capturada;
    }

    private void lugarNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
        pecasDentroTabuleiro.add(peca);

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
