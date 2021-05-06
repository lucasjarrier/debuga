package com.ufcg.psoft.util;

public enum Estagio {
    NaoHabilitado("Paciente Não Habilitado!"),
    HabilitadoPrimeiraDose("Paciente Habilitado 1 Dose!"),
    TomouPrimeiraDose("Paciente Tomou Primeira Dose!"),
    HabilitadoSegundaDose("Paciente Habilitado 2 Dose!"),
    Finalizado("Paciente concluiu Vacinação!");

    private String state;

    Estagio(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
