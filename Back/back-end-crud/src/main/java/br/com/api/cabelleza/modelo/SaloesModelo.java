package br.com.api.cabelleza.modelo;


import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "saloes")
@Getter
@Setter
public class SaloesModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 60)
    @NotBlank (message = "O nome do salão tem que ser preenchido!")
    private String nomeSalao; //nome do salao

    @Column(nullable = false, length = 100)
    @NotBlank (message = "O nome do proprietario tem que ser preenchido!")
    private String proprietarioSalao; //dono do salao

    @Column(nullable = false, length = 100)
    @NotBlank (message = "O campo do email tem que ser preenchido!")
    @Email
    private String email; //email do salao

    @Column(nullable = false, length = 100)
    private String senha; //senha

    @Column(nullable = false, length = 100)
    private String ruaSalao; //logradouro do salao

    @Column(nullable = false, length = 100)
    private String numeroSalao; //numero do esabelecimento

    @Column(nullable = false, length = 100)
    private String bairroSalao; //bairro do salao

    @Column(nullable = false, length = 100)
    private String cnpj; //CNPJ do salao

    @Column(nullable = false, length = 100)
    private String telefoneSalao; //telefone de contato do salao;

    @Value("#{'${seloSalao}'.split('Bronze', 'Prata', 'Ouro')}") // Separa os valores por vírgula
    @Column(nullable = false, length = 100)
     private String seloSalao; //selo do salao

}
