package boardgame;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca [][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if (linhas < 1 || colunas < 1){
            throw new excecaoTabuleiro("Erro ao criar tabuleiro, é necessário que tenha pelo menos 1 linha e 1 coluna");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Peca peca(int linha, int coluna){
        if(!posicaoExiste(linha, coluna)){
            throw  new excecaoTabuleiro("posição não existe no tabuleiro");
        }
        return pecas [linha][coluna];
    }

    public Peca peca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw  new excecaoTabuleiro("posição não existe no tabuleiro");
        }
        return pecas [posicao.getLinha()][posicao.getColuna()];
    }

    public void lugarPeca(Peca peca, Posicao posicao){
        if (pecaNoLocal(posicao)){
            throw new excecaoTabuleiro("já existe uma peça nessa posição "+ posicao);
        }
        pecas [posicao.getLinha()][posicao.getColuna()]=peca;
        peca.posicao = posicao;
    }

    public boolean posicaoExiste(Posicao posicao){
        return posicaoExiste(posicao.getLinha(), posicao.getColuna());
    }

    private boolean posicaoExiste (int linha, int coluna){
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }

    public boolean pecaNoLocal(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw  new excecaoTabuleiro("posição não existe no tabuleiro");
        }
        return peca(posicao)!= null;
    }

}
