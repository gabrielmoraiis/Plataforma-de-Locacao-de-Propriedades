package propriedade;

import java.util.ArrayList;
import java.util.List;

public class Propriedade {
    private String titulo;
    private String descricao;
    private String localizacao;
    private int capacidade;
    private float precoNoite;
    private usuario.Usuario proprietario;
    private boolean disponivel = true;
    private List<Avaliacao> avaliacoesDaPropriedade;

    public Propriedade(String titulo, String descricao, String localizacao, int capacidade, float precoNoite) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.precoNoite = precoNoite;
        this.proprietario = proprietario;
        this.disponivel = disponivel;
        this.avaliacoesDaPropriedade = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDesc() {
        return descricao;
    }

    public String getLoc() {
        return localizacao;
    }

    public int getCap() {
        return capacidade;
    }

    public float getPrec() {
        return precoNoite;
    }

    public String getDados() {
        return getTitulo() + "\n" + getDesc() + "\n" + getLoc() + "\nPara " + getCap() + " pessoas\nR$ " + getPrec() + " por noite\n";
    }

    public void setProprietario(usuario.Usuario proprietario) {
        this.proprietario = proprietario;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void mudaDisponibilidade() {
        disponivel = !disponivel;
    }

    public void avaliaPropriedade(Avaliacao avaliacao) {
        avaliacoesDaPropriedade.add(avaliacao);
    }


    public void listaAvaliacoes() {
        float mediaAvaliacoes;
        float nota = 0;
        for (Avaliacao avaliacao : avaliacoesDaPropriedade) {
            nota += avaliacao.getPontuacao();
        }
        mediaAvaliacoes = nota / avaliacoesDaPropriedade.size();
        System.out.println("Média de avaliações: " + mediaAvaliacoes);
    }
}

