# Treinamento ApiRest para desenvolvedores backend Java

## Sobre o projeto
> A proposta do desafio é capacitar profissional desenvolvedor back-end em desenvolver e manter micro serviços em nuvem implementados com Java, que inclui tecnologias fortemente cobradas pelo mercado como APIs Rest com Spring Cloud e MySQL como banco de dados, implementação com boas praticas utilizando Java 11, versionamento de codigo com Git entre outras stacks.

## Sobre o case

> Você precisa criar uma API Rest para armazenar uma lista de produtos de diferentes fornecedores para serem usados em nossas aplicações mobile e web.

## Cenário

> Sua implementação deve possuir apenas duas entidades:
 A entidade Supplier com os seguintes campos:

```sql
* id
* name
* date of creation
* date of the last update
```

> Você **não precisa** criar endpoints para gerenciar supplier. Basta criar a tabela e inserir pelo menos 3 registros para serem utilizados nas associações com os endpoints dos produtos.


> E a entidade Product e ses respectivos campos:
```sql
* id
* name
* quantity in stock
* unit price
* supplier_id (reference to suppliers table)
* date of creation
* date of the last update
```
> voce deverá implementar a API com o CRUD completo de produtos com os seguintes recursos:
```sql
* Um endpoint para buscar todos os produtos paginados;
* Um endpoint para buscar apenas um produto por Id;
* Um endpoint para inserir um novo produto;
* Um endpoint para atualizar um produto;
* Um endpoint para deletar um produto;
* Um endpoint para incrementar e decrementar a quantidade de produto em seu estoque;
```
## O que queremos ao finalizar o desafio:
- O script do banco de dados;
- O código fonte da API em seu repositório git;
- Uma forma de utilizar esta API: Postman Collection ou uma sequência de comandos Curl;
- Documentação dos endpoints e schemas da aplicação utilizando o Swagger
- Cobertura de testes acima de 80%
- Um README.md auto-explicativo de como instalar e usar a API.


## Requerimentos de Stacks
- Spring
- Java 11
- Maven
- Lombok
- Fly
- Spring Validation
- Spring Security
- Junit e Mockito
- Swagger
- Mysql, H2
- Docker
- Git
- CI e CD com Actions

## Por onde começar?
> Não existe uma regra pois em nosso universo **nada é talhado em pedra**, porém sugiro a seguinte estratégia:

- Clonar esse repositorio;
- Criar um Aplicação ApiRest utilizando o [Spring Initializr](https://start.spring.io/)
  * Inicie apenas com as dependências necessárias para startar o projeto e na jornada da implementação voce irá adicionado apenas o necessário;
  * [Sugestão de projeto](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.7.15&packaging=jar&jvmVersion=11&groupId=com.academy.fourtk&artifactId=treinamento-apirest&name=treinamento-apirest&description=Create%20a%20Rest%20API%20to%20store%20a%20list%20of%20products%20from%20different%20vendors%20to%20be%20used%20in%20our%20mobile%20and%20web%20applications.&packageName=com.academy.fourtk.treinamento-apirest&dependencies=web)


Inicie sua implementação dos recursos na seguinte ordem:
  1. Controller
  2. DTOS
  3. Service
  4. Dominio
  5. Repository
  6. Validação
  7. Exceção
  8. Teste
