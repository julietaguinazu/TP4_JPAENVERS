package org.example;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
//Etiquetas JPA
@Entity
@Table(name = "factura")
@Audited
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fecha;
    private int numero;
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST) // si elimino una factura el cliente sigue estando
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;
    //relacion uniderccional
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)// al ser una composicion cuando elimine una factura se eliminara el detalle
//    private List<DetalleFactura> detalles= new ArrayList<DetalleFactura>();

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL,orphanRemoval = true)
    @Builder.Default
    private List<DetalleFactura> detalles= new ArrayList<DetalleFactura>();

}

