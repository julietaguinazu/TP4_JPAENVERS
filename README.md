# TP4_JPAENVERS
Este proyecto es una aplicación Java desarrollada con IntelliJ IDEA Community Edition. Utiliza la base de datos H2 en memoria y la biblioteca Envers para el registro de cambios en las entidades.

La biblioteca Envers nos permite auditar los cambios en las entidades JPA. Para habilitarla, asegúrate de que tus entidades estén anotadas con @Audited. Luego, Envers registrará automáticamente las modificaciones en una tabla especial de auditoría.
