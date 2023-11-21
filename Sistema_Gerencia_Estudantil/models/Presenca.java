package Sistema_Gerencia_Estudantil.models;

import java.time.LocalDate;

public class Presenca {
    private LocalDate data;
    private boolean presente;
    private String idTurma;
    private String idAluno;

    public Presenca (LocalDate data, String idTurma, String idAluno) {

        presente = true;
        setData(data);
        setIdTurma(idTurma);
        setIdAluno(idAluno);

    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data != null) {
            this.data = data;
        }
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(String idTurma) {
        if (idTurma != null
                && (!idTurma.isBlank()) ) {
            this.idTurma = idTurma;
        }
    }
    public String getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(String idAluno) {
        if (idAluno != null
                && (!idAluno.isBlank())) {
            this.idAluno = idAluno;
        }
    }

}
