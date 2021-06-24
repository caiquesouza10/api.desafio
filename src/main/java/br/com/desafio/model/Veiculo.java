package br.com.desafio.model;

import br.com.desafio.enums.DiaDaSemana;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String ano;

    @Enumerated(EnumType.STRING)
    private DiaDaSemana rodizio;

    private boolean rodizioAtivo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuarioId;

    @Deprecated
    public Veiculo() {

    }

    public Veiculo(String marca, String modelo, String ano, Usuario usuarioId) {

        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.usuarioId = usuarioId;
    }

    public DiaDaSemana adicionaDiaRodizio(int dia) {
        DiaDaSemana diaDaSemana = null;
        switch (dia) {
            case 0:
            case 1:
                diaDaSemana = DiaDaSemana.SEGUNDA;
                break;
            case 2:
            case 3:
                diaDaSemana = DiaDaSemana.TERCA;
                break;
            case 4:
            case 5:
                diaDaSemana = DiaDaSemana.QUARTA;
                break;
            case 6:
            case 7:
                diaDaSemana = DiaDaSemana.QUINTA;
                break;
            case 8:
            case 9:
                diaDaSemana = DiaDaSemana.SEXTA;
                break;
        }
        return diaDaSemana;
    }

    public static boolean hojeTemRodizio(String d) {
        LocalDate instante = LocalDate.now();
        DayOfWeek dia = instante.getDayOfWeek();
        if (dia.toString() == d) {
            return true;
        }
        return false;
    }

    public static List<Veiculo> verificaRodizioAtivo(List<Veiculo> list) {
        if (list == null) {
            return null;
        }
        Assert.state((list.size() >= 1), "Não existe itens a serem exibidos!");

        List<Veiculo> list1 = new ArrayList<>(list.size());
        for (Veiculo v : list) {
            v.setRodizioAtivo(hojeTemRodizio(v.getRodizio().getDia()));
            list1.add(v);
        }
        return list1;
    }

    public DiaDaSemana getRodizio() {
        return rodizio;
    }

    public boolean isRodizioAtivo() {
        return rodizioAtivo;
    }

    public Usuario getUsuario() {
        return usuarioId;
    }

    public void setRodizio(DiaDaSemana rodizio) {
        this.rodizio = rodizio;
    }

    public void setRodizioAtivo(boolean rodizioAtivo) {
        this.rodizioAtivo = rodizioAtivo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano='" + ano + '\'' +
                '}';
    }
}
