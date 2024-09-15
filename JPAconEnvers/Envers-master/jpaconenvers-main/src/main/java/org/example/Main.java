package org.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");

        EntityManager em = emf.createEntityManager();
        System.out.println("FUNCIONANDO");

        try {
            // Persistir una nueva entidad
            em.getTransaction().begin();

//            Factura factura1= Factura.builder().build();
//
//            factura1.setNumero(12);
//            factura1.setFecha("10/12/24");
//
//            Domicilio dom = Domicilio.builder()
//                    .nombreCalle("san martin")
//                    .numero(123)
//                    .build();
//            Cliente cliente= Cliente.builder()
//                    .nombre("Mariano")
//                    .apellido("camacho")
//                    .dni(35098821)
//                    .build();
//            cliente.setDomicilio(dom);
//            dom.setCliente(cliente);
//
//           factura1.setCliente(cliente);
//
//            Categoria perecederos= Categoria.builder()
//                    .denominacion("Perecederos")
//                    .build();
//            Categoria lacteos= Categoria.builder()
//                    .denominacion("Lacteos")
//                    .build();
//            Categoria limpieza= Categoria.builder()
//                    .denominacion("Limpieza")
//                    .build();
//
//            Articulo art1= Articulo.builder()
//                    .cantidad(200)
//                    .denominacion("Yogurt")
//                    .precio(20)
//                    .build();
//            Articulo art2= Articulo.builder()
//                    .cantidad(200)
//                    .denominacion("detergente")
//                    .precio(200)
//                    .build();
//
//          art1.getCategorias().add(perecederos);
//            art1.getCategorias().add(lacteos);
//
//            lacteos.getArticulos().add(art1);
//            perecederos.getArticulos().add(art1);
//
//           art2.getCategorias().add(limpieza);
//            limpieza.getArticulos().add(art2);
//
//            DetalleFactura detalle1= DetalleFactura.builder().build();
//
//            detalle1.setArticulo(art1);
//            detalle1.setCantidad(2);
//            detalle1.setSubtotal(40);
//
//            art1.getDetalle().add(detalle1);
//            factura1.getDetalles().add(detalle1);
//
//            detalle1.setFactura(factura1);
//
//            DetalleFactura detalle2= DetalleFactura.builder().build();
//            detalle2.setArticulo(art2);
//            detalle2.setCantidad(1);
//            detalle2.setSubtotal(80);
//
//            art2.getDetalle().add(detalle2);
//            factura1.getDetalles().add(detalle2);
//
//            detalle2.setFactura(factura1);
//
//           factura1.setTotal(120);
            Factura factura1= em.find(Factura.class,1L);

            factura1.setNumero(90);

             //em.merge(factura1);
            em.remove(factura1);
            em.flush();
            em.getTransaction().commit();

//            // Actualizar la persona
//            em.getTransaction().begin();
//
//            em.getTransaction().commit();
//
//
//
//            // Eliminar la persona
//            em.getTransaction().begin();
//            em.remove();
//            em.getTransaction().commit();






            // Consultar y mostrar la entidad persistida
    //        Persona personaRecuperada = em.find(Persona.class, persona.getId());
   //         System.out.println("Retrieved Persona: " + personaRecuperada.getNombre());

        }catch (Exception e){

            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase ");}

        // Cerrar el EntityManager y el EntityManagerFactory
      em.close();
        emf.close();
    }
}
