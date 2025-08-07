package edu.ifma.dcomp.lpweb.campeonato.dto;

// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;

public class CampeonatoDTO {

    // @NotBlank(message = "O nome do campeonato é obrigatório.")
    // @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
