import menu.CopulaMenu;
import menu.Menu;
import propriedade.Propriedade;
import usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Usuario> listaUsuarios = new ArrayList<>();
        List<Propriedade> listaPropriedades = new ArrayList<>();
        CopulaMenu.implementa(listaPropriedades, listaUsuarios);
        Menu.abrirMenu(listaUsuarios, listaPropriedades);
    }
}
