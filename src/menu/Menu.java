package menu;

import propriedade.Propriedade;
import propriedade.Reserva;
import usuario.Cadastro;
import usuario.SessaoUsuario;
import usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void abrirMenu(List<Usuario> listaUsuarios, List<Propriedade> listaPropriedades) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Selecione uma opção\n1- Cadastrar novo usuario\n2- Sou usuario\n3- Sou proprietario");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listaUsuarios.add(Cadastro.cadastrarUsuario());
                    abrirMenu(listaUsuarios, listaPropriedades);
                    break;
                case 2:
                    if (Cadastro.login(listaUsuarios)) {
                        MenuUsuario.abrirMenuUsuario(listaPropriedades, listaUsuarios);
                    } else {
                        System.out.println("Login incorreto");
                        Menu.abrirMenu(listaUsuarios, listaPropriedades);
                    }
                    break;
                case 3:
                    if (Cadastro.login(listaUsuarios)) {
                        MenuProprietario.abrirMenuProprietario(listaPropriedades, listaUsuarios);
                    } else {
                        System.out.println("Inválido");
                        Menu.abrirMenu(listaUsuarios, listaPropriedades);
                    }
                    break;
                default:
                    System.out.println("Opção incorreta");
                    Menu.abrirMenu(listaUsuarios, listaPropriedades);
            }
        } while (opcao != 0);
    }
}