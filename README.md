# Proyecto hecho con ia

## Estos fueron los prompts usados para crear el proyecto:

### Primer prompt
Hola Claude, antes que nada voy a hablar en español rioplatense. Tengo el siguiente requerimiento para desarrollar en este proyecto. Para el requerimiento las acciones van a estar escritas desde el "nosotros":
Queremos crear un usuario basándonos en datos suministrados por el usuario por un POST por API REST. El usuario tiene como datos Nombre Completo, DNI, email y contraseña. Vamos a persistir estos datos en una base de datos PostgreSQL. La password se debe guardar hasheada por SHA256. El DNI no puede repetirse. El email no puede repetirse. La contraseña debe tener al menos 8 caracteres. El email debe tener formato de email. Hay que validar contra un ente regulador que el DNI sea de una persona viva y mayor a 18 años. Para este caso vamos a asumir que el ente regulador habilita una API REST con metodo GET pasando el DNI como request param y devuelve un caso fechaNacimiento indicando la fecha de nacimiento y un campo isDeceased indicando por booleano si esta muerto.

Quiero que el desarrollo sea realizado utilizando Clean Architecture con Java + Spring boot. Respetando la estructura de paquetes de los controllers, casos de uso, repositorios, dtos, entidades de dominio y clases de infraestructura. Tambien separar en distintos casos de uso las validaciones del caso de uso principal para crear el usuario. Para las validaciones de formato y de largo de contraseña usar las validaciones de Spring.

### Segundo prompt
Please add to gradle the dependency missing for PasswordEncoder in the file @CreateUserUseCase.java 

### Tercer prompt
Please create different interfaces for the classes @DniValidatorClient.java and @CreateUserUseCase.java to decouple them from calling the classes directly