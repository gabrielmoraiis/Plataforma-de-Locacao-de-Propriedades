package menu;

import propriedade.Propriedade;
import usuario.Cadastro;
import usuario.SessaoUsuario;
import usuario.Usuario;

import java.util.List;
import java.util.Scanner;

public class MenuProprietario {
    public static void abrirMenuProprietario(List<Propriedade> listaPropriedades, List<Usuario> listaUsuarios) {
        Scanner scanner = new Scanner(System.in);
        int opcao2;
        do {
            System.out.println("Selecione uma opção\n1- Cadastrar propriedade\n2- Exibir minhas propriedades\n3- Exibir propriedades alugadas\n4- Voltar");
            opcao2 = scanner.nextInt();
            switch (opcao2) {
                case 1:
                    Cadastro.cadastrarPropriedade(SessaoUsuario.getUsuarioLogado(), listaPropriedades, listaUsuarios);
                    break;
                case 2:
                    SessaoUsuario.getUsuarioLogado().listaPropriedadeUsuario(listaPropriedades, listaUsuarios);
                    //Media de avaliações
                    break;
                case 3:
                    SessaoUsuario.getUsuarioLogado().propridadesAlugadas();
                    //propriedade.Propriedade disponivel = false
                    break;
                case 4:
                    Menu.abrirMenu(listaUsuarios, listaPropriedades);
                    break;
                default:
                    System.out.println("Inválido");
                    break;
            }
        } while (opcao2 != 0);
    }
}
