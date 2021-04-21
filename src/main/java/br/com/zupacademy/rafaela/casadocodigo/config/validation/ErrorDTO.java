package br.com.zupacademy.rafaela.casadocodigo.config.validation;

public class ErrorDTO {
    String Field;
    String Error;

    public ErrorDTO(String field, String error) {
        Field = field;
        Error = error;
    }

    public String getField() {
        return Field;
    }

    public String getError() {
        return Error;
    }
}
