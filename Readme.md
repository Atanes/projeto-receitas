# Projeto Receitas API
Criando uma API Rest para gerenciar e disponibilizar informações sobre receitas (bolos, doces, salgados, etc) de forma geral

## Objetivo
Mostrar como utilizar o Java em conjunto com o Spring Framwork para criar uma aplicação Rest de forma simples e direta

### Tecnologias/Ferramentas Utilizadas
Git, GitHub, Git Bash, Intellij, Java 11, Spring Web, Spring Boot, Spring JPA, PostgreSql, Postman

### Estrutura inicial do projeto 😉

[Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)  
[Spring Boot](https://spring.io/projects/spring-boot)  
[Maven](https://maven.apache.org/)  

Dependências iniciais:  
-	Spring Web;  
-	Spring Boot DevTools;  
-	Spring Data JPA  
- [PostgreSQL 14](https://www.postgresql.org/download/);  
- Lombok  

Utilizar o site [spring.io](https://start.spring.io/) para configurar a estrutura inicial do projeto:

![image](https://user-images.githubusercontent.com/18126923/217337970-f82eff9e-8654-4ae1-a795-4fdf4f3eef45.png)

Criar uma diretorio **projetos** na máquina para um melhor controle sobre os arquivos do projeto e não deixar nada **solto** na sua máquina:

![image](https://user-images.githubusercontent.com/18126923/217338328-b43da580-e033-48e2-a7be-6b0bc1cc81ff.png)

Pelo IntelliJ, através do menu **Open -> Project**, selecionar o projeto receitas na pasta Projetos e depois clicar para abrir o projeto:

![image](https://user-images.githubusercontent.com/18126923/217338512-6208209a-7d97-4dfe-ac7f-04a2384559ed.png)

**Configurar o Banco de Dados:**
Através do **PgAdmin**, criar um banco de dados no PostgreSQL com o nome de receitasAPI:

![image](https://user-images.githubusercontent.com/18126923/217338668-57c70912-da99-4630-93dd-cc0e25dcbf8d.png)

**Configurar o arquivo application.properties dentro do projeto pelo IntelliJ:** 

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect  
spring.jpa.hibernate.ddl-auto=none  
spring.jpa.hibernate.show-sql=true  
spring.datasource.url=jdbc:postgresql://localhost:5432/receitasAPI  
spring.datasource.username=atanes  
spring.datasource.password=receitas123  

**Criar os pacotes de trabalho base pelo IntelliJ**:  
- **controller** -> classes com os endpoints da api que vão receber as chamadas externas e devolver as informações/recursos da nossa API  
- **error.handler** -> classes relacionadas com o controle e gestão de excessões (erros) da aplicação  
- **model** -> classes de modelo com as estruturas base da nossa aplicação (receita, imagem, ingrediente)  
- **repository** -> classes responsáveis pela persistência de dados da aplicação  
- **service** -> classes que vão fazer e controlar toda a lógica de nécio por trás de cada endpoint da aplicação  

![estrututaAtualProjeto](https://user-images.githubusercontent.com/18126923/224127458-ee86f32f-d02c-4f9b-9199-19c4d68075b3.png)

**Criando nosso primeiro endpoint pelo IntelliJ:**  

![image](https://user-images.githubusercontent.com/18126923/217339357-a811c60c-6005-41f8-a43e-649fefc71d8b.png)

**Executar o projeto e testar os endpoints criados:**

Como o arquivo **ReceitaApiApplication.java** selecionado, clicar no botão **RUN**
![image](https://user-images.githubusercontent.com/18126923/217344933-b9124bfa-d279-4b07-bc86-4810c138c3e3.png)

Depois que a aplicação subir sem erros e apresentar a mensagem **Started ReceitaApiApplication**
![image](https://user-images.githubusercontent.com/18126923/217345017-5b71158a-f1d4-4c9f-a169-6484d6e54df2.png)

Acessar pelo seu Browser de preferencia o endereço **http://localhost:8080/receita-api/listar**
![image](https://user-images.githubusercontent.com/18126923/217345134-f8c3eefc-f1e5-4afb-88b7-a283c566e7e8.png)

### Videos do projeto
[API, guia rápido](https://youtu.be/FyI6vsLK0ng)🚀  
[Aula 1   Montando a estrutura base do projeto](https://youtu.be/WTW24-XmRfg)  
[Aula 2   Criando o repositório remoto para o projeto](https://youtu.be/e6D8KAQMexY)

### Links para consulta e mais estudos
[Defining JPA Entities](https://www.baeldung.com/jpa-entities)  
[JPA Repositories](https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html)  
[Database initialization](https://docs.spring.io/spring-boot/docs/1.1.0.M1/reference/html/howto-database-initialization.html)  
[Jackson Date](https://www.baeldung.com/jackson-serialize-dates)  
[JPA: avoiding columns to being insertable and/or updatable](https://medium.com/@bortolattol/jpa-avoiding-columns-to-being-insertable-and-or-updatable-fc8e8d54ccee)  
[Spring boot Exceptions Handler (tratamento de erros)](https://www.baeldung.com/exception-handling-for-rest-with-spring)
