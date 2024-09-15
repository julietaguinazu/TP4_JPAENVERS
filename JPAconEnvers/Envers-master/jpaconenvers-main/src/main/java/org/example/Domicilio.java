package org.example;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
//Etiquetas JPA
@Entity
@Table(name = "Domicilio")
@Audited
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombreCalle;
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;

}
