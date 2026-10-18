package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes.
 *
 * @author eliane
 *
 */
public class FilmNow {

    private static final int TAMANHO = 100;

    private Filme[] filmes; //uma representacao simploria da lista de filmes

    /**
     * Cria o FilmNow.
     */
    public FilmNow() {
        this.filmes = new Filme[TAMANHO];
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
     * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior.
     * @param posicao Posição do filme.
     * @param nome Nome do filme.
     * @param ano Ano de lançamento do filme.
     * @param local Local onde o filme pode ser assitido.
     */
    public String cadastraFilme(int posicao, String nome, String ano, String local) {
        if(posicao > TAMANHO){
            return "POSIÇÃO INVALIDA";
        }

        if(nome.equals("") || ano.equals("") || local.equals("")){
            return "FILME INVÁLIDO";
        }
        Filme novoFilme = new Filme(nome, ano, local);
        for (int i = 0; i < TAMANHO; i++){
            if(filmes[i].equals(novoFilme)){
                return "FILME JA ADICIONADO";
            }
        }
        this.filmes[posicao] = novoFilme;
        return "FILME ADICIONADO";
    }

}