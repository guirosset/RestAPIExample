package br.com.example.pom.models;

import java.util.ArrayList;
import java.util.List;

public class ErrorScenarioResponse {

    private List<ErrorResponse> errors = new ArrayList<>(  );

    public List<ErrorResponse> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorResponse> errors) {
        this.errors = errors;
    }
}
