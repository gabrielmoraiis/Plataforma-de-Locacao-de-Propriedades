package propriedade;

import menu.MenuUsuario;
import usuario.Usuario;

import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class Reserva {
    private Propriedade propriedade;
    private String dtCheckin;
    private String dtCheckout;
    private double custoTotal;

    public Reserva(Propriedade propriedade, String dtCheckin, String dtCheckout, double custoTotal) {
        this.propriedade = propriedade;
        this.dtCheckin = dtCheckin;
        this.dtCheckout = dtCheckout;
        this.custoTotal = custoTotal;
    }

    public static void reservarPropriedade(List<Propriedade> listaPropriedades, Usuario usuario, List<Usuario> listaUsuarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o titulo da propriedade que deseja alugar");
        String propriedade = scanner.next();


        for (Propriedade listaPropriedade : listaPropriedades) {
            if (propriedade.equals(listaPropriedade.getTitulo())) {
                if (listaPropriedade.isDisponivel()) {
                    System.out.println("Digite a data de checkIn");
                    String dtCheckin = scanner.next();
                    System.out.println("Digite a data de checkOut");
                    String dtCheckout = scanner.next();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataInicial = LocalDate.parse(dtCheckin);
                    LocalDate dataFinal = LocalDate.parse(dtCheckout);

                    String data1 = dataInicial.format(formato);
                    String data2 = dataFinal.format(formato);

                    int diferenca = Period.between(dataInicial, dataFinal).getDays();
                    double precoNoite = listaPropriedade.getPrec();

                    double custoTotal = diferenca * precoNoite;

                    Reserva reserva = new Reserva(listaPropriedade, dtCheckin, dtCheckout, custoTotal);
                    usuario.pedidoDeReserva(reserva);
                    listaPropriedade.mudaDisponibilidade();

                    System.out.println("Reserva realizada com sucesso!");

                } else {
                    System.out.println("Propriedade não encontrada, por favor verificar se o nome esta correto");
                }
            }
        }
    }

    public Propriedade getNomePropriedade() {
        return propriedade;
    }
}
