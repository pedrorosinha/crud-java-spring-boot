package br.com.dbserver.crud.domains.pessoa;

import br.com.dbserver.crud.domains.endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.*;

@Table(name = "pessoa")
@Entity(name = "pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    @JsonIgnoreProperties("pessoa")
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    public Pessoa(RequestPessoa requestPessoa) {
        this.nome = requestPessoa.nome();
        this.cpf = requestPessoa.cpf();
        this.dataNascimento = requestPessoa.dataNascimento();
    }
}
