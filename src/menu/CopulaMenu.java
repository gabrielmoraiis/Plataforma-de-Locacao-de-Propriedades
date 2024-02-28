package menu;

import propriedade.Propriedade;
import usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class CopulaMenu {

    public static void implementa(List<Propriedade> listaPropriedades, List<Usuario> listaUsuarios) {

        Propriedade chale = new Propriedade("Chalé", "chalé nas montanhas interior de São Paulo", "Embu das Artes-SP", 2, 399.99F);
        Propriedade casa = new Propriedade("Casa", "Casa no Morumbi", "Morumbi - SP", 20, 1000F);
        Propriedade resort = new Propriedade("Resort", "resort All Inclusive frente á praia", "Paraty-RJ", 3, 899.99F);
        listaPropriedades.add(casa);
        listaPropriedades.add(chale);
        listaPropriedades.add(resort);

        Usuario marina = new Usuario("Marina", "marina@gmail.com", "123");
        Usuario paulo = new Usuario("Paulo", "paulo@gmail.com", "456");
        Usuario gabriel = new Usuario("Gabriel", "gabriel@gmail.com", "789");
        listaUsuarios.add(marina);
        listaUsuarios.add(paulo);
        listaUsuarios.add(gabriel);

        gabriel.cadastroPropriedadeUsuario(chale);
        gabriel.cadastroPropriedadeUsuario(casa);
        paulo.cadastroPropriedadeUsuario(resort);
    }
}
