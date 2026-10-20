package filmnow;

import java.util.Objects;

/**
 * Representação dos filmes no sistema.
 *
 * @author Lucas Gabriel
 *
 */
public class Filme {
    private String nome;
    private String lancamento;
    private String local;
    private boolean ehHot;

    /**
     * Cria um filme.
     *
     * @param nome nome do filme criado
     * @param lancamento ano do lancamento desse filme
     * @param local local disponivel para assistir o filme
     */
    public Filme(String nome, String lancamento, String local) {
        this.nome = nome;
        this.lancamento = lancamento;
        this.local = local;
        this.ehHot = false;
    }

    /**
     * Pega o nome do filme.
     *
     * @return o nome do filme
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Pega o lancamento do filme.
     *
     * @return o lancamento do filme
     */
    public String getLancamento() {
        return this.lancamento;
    }

    /**
     * Quando o filme estiver na HotList o atributo ehHot se torna verdadeiro
     *
     */
    public void virouHot(){
        this.ehHot = true;
    }

    /**
     * Quando o filme sair da HotList o atributo ehHot se torna falso
     *
     */
    public void removeuHot(){
        this.ehHot = false;
    }


    /**
     * Cria o HashCode do Objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, lancamento);

    }

    /**
     * verifica se o Filme é igual à outro
     *
     * @param o objeto comparado
     * @return se é igual ou não
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Filme filme = (Filme) o;

        return this.nome.equals(filme.getNome()) && this.lancamento.equals(filme.getLancamento());
    }

    /**
     * Faz a representação em String do Filme com todas as suas informações
     *
     * @return a representação em String
     */
    @Override
    public String toString(){
        String saida = "";
        if(this.ehHot){
            saida += "🔥";
        }
        return saida + this.nome + ", " + this.lancamento + "\n" + this.local;
    }
}
