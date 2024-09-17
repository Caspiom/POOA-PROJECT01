
---

# Versão em Português:

## Sistema de Gestão de Artigos
Este é um pequeno programa em Java que implementa um sistema de gestão de artigos. Ele permite que você adicione, liste, edite e exclua conteúdos (artigos) usando um banco de dados `HSQL`.

### Funcionalidades:
#### Login:
- O programa solicita um login e senha.
- Se o login e a senha forem iguais, o usuário é autenticado com sucesso.

#### Opções do Menu:
1. **Criar novo conteúdo**: Adiciona um novo artigo à lista.
2. **Listar os conteúdos**: Exibe todos os artigos atualmente armazenados.
3. **Editar conteúdo**: Permite modificar o conteúdo de um artigo existente.
4. **Deletar conteúdo**: Remove um artigo da lista.
5. **Criar novo usuário**: Cria um usuário novo.
6. **Listar os usuários**: Faz uma lista de todos usuários.
7. **Alterar usuário**: Altera o login de um usuário.
8. **Excluir usuário**: Exclui um usuário.
9. **Alterar Senha**: Muda a senha do usuário atual.
10. **Sair da conta**: Encerra a sessão do usuário.

### Métodos da classe DbFunctions
A classe `DbFunctions` fornece métodos para interagir com o banco de dados HSQLDB, incluindo:

- **connect_to_hsql**: Conecta ao banco de dados HSQLDB.
- **update**: Atualiza um conteúdo da tabela baseado no nome.
- **search_name**: Procura um conteúdo da tabela pelo nome.
- **delete_row**: Deleta uma linha dentro de uma tabela.
- **delete_table**: Deleta uma tabela inteira (use com cuidado).

### Métodos da classe ContentHSQL
A classe `ContentHSQL` fornece métodos para gerenciar o conteúdo dos artigos, incluindo:

- **createTable**: Cria uma tabela de conteúdo.
- **insertInto**: Insere conteúdo na tabela de conteúdo.
- **read**: Lê a tabela de conteúdo.
- **createContent**: Método placeholder para criar conteúdo (a ser implementado).
- **changeContent**: Método placeholder para alterar conteúdo (a ser implementado).
- **deleteContent**: Deleta conteúdo da tabela de conteúdo.

### Métodos da classe ContentList
A classe `ContentList` implementa a interface `Persistencia<Content>` e fornece métodos para gerenciar uma lista de conteúdos, incluindo:

- **save**: Salva um novo conteúdo na lista.
- **atualizar**: Atualiza um conteúdo existente na lista.
- **listar**: Lista todos os conteúdos armazenados.
- **remover**: Remove um conteúdo da lista pelo ID.

### Métodos da classe ContentService
A classe `ContentService` fornece métodos para gerenciar o serviço de conteúdo, incluindo:

- **ConteudoService**: Construtor para inicializar a persistência.
- **save**: Salva um novo conteúdo usando a persistência.
- **atualizarConteudo**: Atualiza um conteúdo existente.
- **listarConteudos**: Lista todos os conteúdos armazenados.
- **removerConteudo**: Remove um conteúdo pelo ID.

### Métodos da classe Content
A classe `Content` representa um artigo e fornece métodos para gerenciar suas propriedades, incluindo:

- **getTitle**: Retorna o título do conteúdo.
- **setTitle**: Define o título do conteúdo.
- **getContent**: Retorna o texto do conteúdo.
- **setContent**: Define o texto do conteúdo.
- **getId**: Retorna o ID do conteúdo.
- **setId**: Define o ID do conteúdo.
- **getAutor**: Retorna o autor do conteúdo.
- **setAutor**: Define o autor do conteúdo.

### Métodos da classe UsersHSQL
A classe `UsersHSQL` fornece métodos para gerenciar os usuários, incluindo:

- **createTable**: Cria a tabela de usuários.
- **insertInto**: Insere um novo usuário na tabela de usuários.
- **read**: Lê a tabela de usuários.
- **createUser**: Cria um novo usuário.
- **updateUser**: Atualiza o nome de usuário.
- **deleteUser**: Deleta um usuário da tabela de usuários.
- **getCurrentPassword**: Recupera a senha atual do usuário.
- **updatePass**: Atualiza a senha do usuário.

### Métodos da classe UsersService
A classe `UsersService` fornece métodos para validar o login dos usuários, incluindo:

- **validarLogin**: Valida o login do usuário.
- **userExists**: Verifica se o usuário já existe na tabela de usuários.

### Métodos da classe Users
A classe `Users` representa um usuário e fornece métodos para gerenciar suas propriedades, incluindo:

- **getName**: Retorna o nome do usuário.
- **setName**: Define o nome do usuário.
- **getPassword**: Retorna a senha do usuário.
- **setPassword**: Define a senha do usuário.
- **toString**: Retorna uma representação em string do usuário, ocultando a senha.

### Métodos da interface Persistencia
A interface `Persistencia<T>` define métodos para operações CRUD (Create, Read, Update, Delete), incluindo:

- **save**: Salva uma nova entidade.
- **atualizar**: Atualiza uma entidade existente.
- **listar**: Lista todas as entidades armazenadas.
- **remover**: Remove uma entidade pelo ID.

---

# English Version:

## Article Management System
This is a small Java program that implements an article management system. It allows you to add, list, edit, and delete content (articles) using a database `HSQL`.

### Features:
#### Login:
- The program prompts for a login and password.
- If the login and password are the same, the user is successfully authenticated.

#### Menu Options:
1. **Create new content**: Adds a new article to the list.
2. **List contents**: Displays all currently stored articles.
3. **Edit content**: Allows modifying the content of an existing article.
4. **Delete content**: Removes an article from the list.
5. **Create new user**: Adds a new user to the system.
6. **List users**: Displays all currently stored users.
7. **Update user**: Allows modifying the username of an existing user.
8. **Delete user**: Removes a user from the system.
9. **Change password**: Allows changing the password of an existing user.
10. **Log out**: Ends the user's session.

### Methods of the `DbFunctions` Class
The `DbFunctions` class provides methods to interact with the HSQLDB database, including:

- **connect_to_hsql**: Connects to the HSQLDB database.
- **update**: Updates a content in the table based on the name.
- **search_name**: Searches for a content in the table by name.
- **delete_row**: Deletes a row within a table.
- **delete_table**: Deletes an entire table (use with caution).

### Methods of the `ContentHSQL` Class
The `ContentHSQL` class provides methods to manage article content, including:

- **createTable**: Creates a content table.
- **insertInto**: Inserts content into the content table.
- **read**: Reads the content table.
- **createContent**: Placeholder method to create content (to be implemented).
- **changeContent**: Placeholder method to change content (to be implemented).
- **deleteContent**: Deletes content from the content table.

### Methods of the `ContentList` Class
The `ContentList` class implements the `Persistencia<Content>` interface and provides methods to manage a list of contents, including:

- **save**: Saves a new content to the list.
- **atualizar**: Updates an existing content in the list.
- **listar**: Lists all stored contents.
- **remover**: Removes a content from the list by ID.

### Methods of the `ContentService` Class
The `ContentService` class provides methods to manage content services, including:

- **ConteudoService**: Constructor to initialize persistence.
- **save**: Saves a new content using persistence.
- **atualizarConteudo**: Updates an existing content.
- **listarConteudos**: Lists all stored contents.
- **removerConteudo**: Removes a content by ID.

### Methods of the `Content` Class
The `Content` class represents an article and provides methods to manage its properties, including:

- **getTitle**: Returns the content title.
- **setTitle**: Sets the content title.
- **getContent**: Returns the content text.
- **setContent**: Sets the content text.
- **getId**: Returns the content ID.
- **setId**: Sets the content ID.
- **getAutor**: Returns the content author.
- **setAutor**: Sets the content author.

### Methods of the `UsersHSQL` Class
The `UsersHSQL` class provides methods to manage users, including:

- **createTable**: Creates the users table.
- **insertInto**: Inserts a new user into the users table.
- **read**: Reads the users table.
- **createUser**: Creates a new user.
- **updateUser**: Updates the username.
- **deleteUser**: Deletes a user from the users table.
- **getCurrentPassword**: Retrieves the current password of the user.
- **updatePass**: Updates the user's password.

### Methods of the `UsersService` Class
The `UsersService` class provides methods to validate user login, including:

- **validarLogin**: Validates the user's login.
- **userExists**: Checks if the user already exists in the users table.

### Methods of the `Users` Class
The `Users` class represents a user and provides methods to manage its properties, including:

- **getName**: Returns the user's name.
- **setName**: Sets the user's name.
- **getPassword**: Returns the user's password.
- **setPassword**: Sets the user's password.
- **toString**: Returns a string representation of the user, hiding the password.

### Methods of the `Persistencia` Interface
The `Persistencia<T>` interface defines methods for CRUD (Create, Read, Update, Delete) operations, including:

- **save**: Saves a new entity.
- **atualizar**: Updates an existing entity.
- **listar**: Lists all stored entities.
- **remover**: Removes an entity by ID.

---