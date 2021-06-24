package br.com.desafio.enums;

public enum DiaDaSemana {
    SEGUNDA("MONDAY"),
    TERCA("TUESDAY"),
    QUARTA("WEDNESDAY"),
    QUINTA("THURSDAY"),
    SEXTA("FRIDAY");

    private String dia;

    DiaDaSemana(String dia) {
        this.dia = dia;
    }

    public String getDia() {
        return dia;
    }
}
