package menu;

import propriedade.Avaliacao;
import propriedade.Reserva;
import usuario.SessaoUsuario;
import usuario.Usuario;
import propriedade.Propriedade;

import java.util.List;
import java.util.Scanner;

public class MenuUsuario {
    public static void abrirMenuUsuario(List<Propriedade> listaPropriedades, List<Usuario> listaUsuarios) {
        Scanner scanner = new Scanner(System.in);
        boolean repetir = true;
        int opcao1;
        while (repetir == true) {
            System.out.println("Selecione uma opção\n1- Vizualizar propriedades disponiveis\n2- Alugar propriedade\n3- Avaliar propriedades alugadas\n4- Voltar");
            opcao1 = scanner.nextInt();

            switch (opcao1) {
                case 1:
                    MenuUsuario.listarPropriedades(listaPropriedades);
                    System.out.println("Fazer reserva? Digite 1");
                    int resposta = scanner.nextInt();

                    if (resposta == 1) {
                        Reserva.reservarPropriedade(listaPropriedades, SessaoUsuario.getUsuarioLogado(), listaUsuarios);
                    } else {
                        MenuUsuario.abrirMenuUsuario(listaPropriedades, listaUsuarios);
                    }
                    break;
                case 2:
                    listarPropriedades(listaPropriedades);
                    Reserva.reservarPropriedade(listaPropriedades, SessaoUsuario.getUsuarioLogado(), listaUsuarios);
                    break;
                case 3:
                    SessaoUsuario.getUsuarioLogado().listaReservaUsuario();
                    Avaliacao.avaliarPropriedade(listaPropriedades, listaUsuarios);
                    break;
                case 4:
                    repetir = false;
                    break;
                default:
                    System.out.println("Inválido");
            }
        }
    }

    public static void listarPropriedades(List<Propriedade> listaPropriedades) {
        for (int i = 0; i < listaPropriedades.size(); i++) {
            if (listaPropriedades.get(i).isDisponivel()) {
                System.out.printf("----------------%d------------------\n", i + 1);
                System.out.println(listaPropriedades.get(i).getDados());
            }
        }
    }
}