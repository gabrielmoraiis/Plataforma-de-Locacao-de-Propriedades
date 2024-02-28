package propriedade;

import menu.MenuUsuario;
import usuario.Usuario;

import java.util.List;
import java.util.Scanner;

public class Avaliacao {
    private Propriedade propriedade;
    private float pontuacao;
    private String comentario;

    public Avaliacao(Propriedade propriedade, float pontuacao, String comentario) {
        this.propriedade = propriedade;
        this.pontuacao = pontuacao;
        this.comentario = comentario;
    }

    public String getDados() {
        return getPropriedade() + "\n" + getPontuacao() + "\n" + getComentario();
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public float getPontuacao() {
        return pontuacao;
    }

    public String getComentario() {
        return comentario;
    }


    public static void avaliarPropriedade(List<Propriedade> listaPropriedades, List<Usuario> listaUsuarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o titulo da propriedade que deseja alugar");
        String propriedade = scanner.next();
        for (Propriedade listaPropriedade : listaPropriedades) {
            if (propriedade.equals(listaPropriedade.getTitulo())) {
                System.out.println("Informe a nota de 1 a 5 para essa propriedade");
                float nota = scanner.nextFloat();
                System.out.println("Faça um comentario sobre essa propriedade");
                String comentario = scanner.next();

                Avaliacao avaliacao = new Avaliacao(listaPropriedade, nota, comentario);
                listaPropriedade.avaliaPropriedade(avaliacao);
                System.out.println(avaliacao.getPontuacao());
                System.out.println("Avaliação concluida");
                MenuUsuario.abrirMenuUsuario(listaPropriedades, listaUsuarios);
            }
        }
        MenuUsuario.abrirMenuUsuario(listaPropriedades, listaUsuarios);
    }

}
