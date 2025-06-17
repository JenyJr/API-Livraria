# Documentação Livraria Arco-Iris API

## 1. Visão Geral
A Livraria Arco-Iris API é uma aplicação Spring Boot que fornece endpoints para gerenciamento de livros. A API permite listar, baixar e cadastrar livros no sistema.

## 2. Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Jakarta EE
- Lombok
- Maven

## 3. Estrutura do Projeto
```
livraria-arco-iris/
├── src/                    # Código fonte
├── .mvn/                   # Configurações Maven
├── pom.xml                 # Dependências do projeto
├── Dockerfile             # Configuração para containerização
└── .gitignore            # Arquivos ignorados pelo Git
```


## 4. API Endpoints

### 4.1 Listar Livros
- **Endpoint:** `GET /v1/livro/listar`
- **Descrição:** Retorna uma lista de todos os livros cadastrados
- **Resposta:** Lista de `ListarLivrosDTO`
- **Status Code:** 200 (OK)

### 4.2 Download de Livro
- **Endpoint:** `GET /v1/livro/download/{idLivro}`
- **Descrição:** Realiza o download de um livro específico
- **Parâmetros:**
  - Path Variable: `idLivro` (Integer)
  - Query Parameter: `idUsuario` (Integer)
- **Resposta:** `LivroDownloadDTO`
- **Status Code:** 200 (OK)

### 4.3 Cadastrar Livro
- **Endpoint:** `POST /v1/livro/cadastrar`
- **Descrição:** Cadastra um novo livro no sistema
- **Corpo da Requisição:** `CadastrarLivroDTO`
```json
{
    "descricao": "string",
    "url_imagem": "string",
    "link_Livro": "string",
    "titulo": "string",
    "paginas": "integer"
  }
```

- **Resposta:** `LivroModel`
- **Status Code:** 201 (Created)

## 5. DTOs (Data Transfer Objects)

### 5.1 ListarLivrosDTO
- Utilizado para retornar a listagem de livros

### 5.2 LivroDownloadDTO
- Contém informações necessárias para download do livro

### 5.3 CadastrarLivroDTO
- Contém os dados necessários para cadastro de um novo livro
- Campos:
  - descricao
  - url_imagem
  - link_Livro
  - titulo
  - paginas

### 5.4 BaixarLivroDTO
- Utilizado internamente para processar o download de livros
- Campos:
  - idLivro
  - idUsuario

## 6. Modelo de Dados

### LivroModel
Entidade principal que representa um livro no sistema com os seguintes atributos:
- descricao
- url_imagem
- link_Livro
- titulo
- paginas

## 7. Camadas da Aplicação
- **Controllers:** Responsável pelo tratamento das requisições HTTP
- **Services:** Contém a lógica de negócio
- **Models:** Representa as entidades do sistema
- **DTOs:** Objetos para transferência de dados

## 8. Configuração e Execução

### Requisitos
- JDK 17
- Maven

### Comandos para Execução
```shell script
# Compilar o projeto
mvn clean install

# Executar a aplicação
mvn spring-boot:run
```


### Docker
O projeto inclui um Dockerfile para containerização:
```shell script
# Construir a imagem
docker build -t livraria-arco-iris .

# Executar o container
docker run -p 8080:8080 livraria-arco-iris
```


## 9. Observações de Segurança
- O endpoint de download requer autenticação do usuário através do `idUsuario`
- As operações de download são transacionais para garantir a integridade dos dados

Esta documentação fornece uma visão geral do projeto e pode ser expandida conforme novas funcionalidades forem adicionadas. Recomenda-se manter esta documentação atualizada para facilitar a manutenção e o desenvolvimento do sistema.
