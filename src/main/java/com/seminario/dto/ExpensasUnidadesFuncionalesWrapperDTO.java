package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class ExpensasUnidadesFuncionalesWrapperDTO {

    private String periodo;
    private List<ExpensaUnidadFuncionalDTO> expensasUnidadesFuncionales;

    public ExpensasUnidadesFuncionalesWrapperDTO() {
    }

    public ExpensasUnidadesFuncionalesWrapperDTO(String periodo, List<ExpensaUnidadFuncionalDTO> expensasUnidadesFuncionales) {
        this.periodo = periodo;
        this.expensasUnidadesFuncionales = expensasUnidadesFuncionales;
    }

    public String getPeriodo() {
        return periodo;
    }

    public List<ExpensaUnidadFuncionalDTO> getExpensasUnidadesFuncionales() {
        return expensasUnidadesFuncionales;
    }
}
