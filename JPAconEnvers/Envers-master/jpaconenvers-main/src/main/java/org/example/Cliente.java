package org.example;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Etiquetas de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
//Etiquetas JPA
@Entity
@Table(name = "cliente")
@Audited
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    @Column(name = "dni", unique = true)
    private int dni;

    @OneToOne(cascade = CascadeType.ALL)// all al crear un cliente tambien un domicilio y si borro el cliente se borra el domicilio
    @JoinColumn(name="fk_domicilio")
    private Domicilio domicilio;


    @OneToMany(mappedBy = "cliente")
    @Builder.Default
    private List <Factura> facturas = new ArrayList<Factura>();

}
