package filmnow;

import java.lang.classfile.instruction.TableSwitchInstruction;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes no sistema e 20 podem estar na HotList.
 *
 * @author eliane
 *
 */
public class FilmNow {

    private static final int TAMANHO = 100;
    private static final int TAMHOT = 20;

    private Filme[] filmes;
    private Filme[] hotList;

    /**
     * Cria o FilmNow.
     */
    public FilmNow() {
        this.filmes = new Filme[TAMANHO];
        this.hotList = new Filme[TAMHOT];
    }

    /**
     * Acessa a lista de filmes mantida.
     * @return O array de filmes.
     */
    public Filme[] getFilmes() {
        return this.filmes.clone();
    }

    /**
     * Acessa os dados de um filme específico.
     * @param posicao Posição do filme no sistema.
     * @return Dados do filme. Null se não há filme na posição.
     */
    public Filme getFilme(int posicao) {
        return filmes[posicao];
    }

    /**
     * Acessa a lista de filmes mantida na HotList.
     * @return O array de filmes da HotList.
     */
    public Filme[] getHot(){
        return this.hotList;
    }

    /**
     * Remove um filme em uma posição da HotList.
     * @param posicao Posição do filme na HotList.
     */
    public void removeHot(int posicao){
        this.hotList[posicao - 1].removeuHot();
        this.hotList[posicao - 1] = null;
    }

    /**
     * Adiciona um filme em uma posição da HotList. Se já existir filme na posição, sobrescreve o anterior.
     * @param posicaoPrincipal Posição do filme na lista principal.
     * @param posListaHot Posição desejada para inserir o filme na HotList.
     * @return o resultado do cadastro do filme na HotList
     */
    public String cadastraHOT(int posicaoPrincipal, int posListaHot){
        if(posListaHot > TAMHOT){
            return "POSIÇÃO INVALIDA PARA HOTLIST";
        }

        for(int i = 0; i < TAMHOT; i ++){
            if(filmes[posicaoPrincipal - 1].equals(hotList[i])){
                return "FILME JÁ EXISTE NA HOTLIST";
            }
        }
        this.hotList[posListaHot - 1] = this.filmes[posicaoPrincipal - 1];
        this.filmes[posicaoPrincipal].virouHot();
        return "ADICIONADO Á HOTLIST NA POSIÇÃO " + posListaHot + "!";
    }

    /**
     * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior.
     * @param posicao Posição do filme.
     * @param nome Nome do filme.
     * @param ano Ano de lançamento do filme.
     * @param local Local onde o filme pode ser assitido.
     * @return o resultado do cadastro do filme
     */
    public String cadastraFilme(int posicao, String nome, String ano, String local) {
        if(posicao > TAMANHO){
            return "POSIÇÃO INVALIDA";
        }

        if(nome.equals("") || ano.equals("") || local.equals("")){
            return "FILME INVÁLIDO";
        }
        if (filmes[posicao] != null){
            for(int i = 0; i < TAMHOT; i ++){
                if(filmes[posicao].equals(hotList[i])){
                    this.removeHot(i + 1);
                }
            }
        }
        Filme novoFilme = new Filme(nome, ano, local);
        for (int i = 0; i < TAMANHO; i++){
            if(novoFilme.equals(filmes[i])){
                return "FILME JA ADICIONADO";
            }
        }
        this.filmes[posicao - 1]= novoFilme;
        return "FILME ADICIONADO";
    }

}