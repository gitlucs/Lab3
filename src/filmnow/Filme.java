package filmnow;

import java.util.Objects;

public class Filme {
    private String nome;
    private String lancamento;
    private String local;
    private boolean ehHot;

    public Filme(String nome, String lancamento, String local) {
        this.nome = nome;
        this.lancamento = lancamento;
        this.local = local;
        this.ehHot = false;
    }

    public String getNome() {
        return this.nome;
    }

    public String getLancamento() {
        return this.lancamento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, lancamento);

    }

    public void virouHot(){
        this.ehHot = true;
    }

    public void removeuHot(){
        this.ehHot = false;
    }

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



    @Override
    public String toString(){
        String saida = "";
        if(this.ehHot){
            saida += "🔥";
        }
        return saida + this.nome + ", " + this.lancamento + "\n" + this.local;
    }
}
