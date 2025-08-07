package edu.ifma.dcomp.lpweb.campeonato.dto;

// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;

public class EstadioDTO {

    // @NotBlank(message = "O nome do estádio é obrigatório.")
    // @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    // @NotBlank(message = "O endereço é obrigatório.")
    // @Size(min = 5, max = 200, message = "O endereço deve ter entre 5 e 200 caracteres.")
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
