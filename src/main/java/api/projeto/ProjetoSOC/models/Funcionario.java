package api.projeto.ProjetoSOC.models;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
@Table(
        name = "product_serial_group_mask",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "date"),
                @UniqueConstraint(columnNames = "exame")
        }
)
public class Funcionario {

    @GeneratedValue(strategy = GenerationType.AUTO)

    @Id
    private long id;

    @NotBlank(message = "Nome do funcionário deve ser definido!")
    @Column(nullable = false, name = "name")
    private String name;

    @NotBlank(message = "Nome do exame deve ser definido!")
    @Column(nullable = false, name = "exame")
    private String exame;

    @Column(name="date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

}