# PT:

# Sistema de Gestão de Artigos

Este é um pequeno programa em Java que implementa um sistema de gestão de artigos. Ele permite que você adicione, liste, edite e exclua conteúdos (artigos) usando uma estrutura de dados chamada `LinkedList`.

## Funcionalidades:

### Login:
- O programa solicita um login e senha.
- Se o login e a senha forem iguais, o usuário é autenticado com sucesso.

### Opções do Menu:

1. **Criar novo conteúdo**: Adiciona um novo artigo à lista.
2. **Listar os conteúdos**: Exibe todos os artigos atualmente armazenados.
3. **Editar conteúdo**: Permite modificar o conteúdo de um artigo existente.
4. **Deletar conteúdo**: Remove um artigo da lista.
5. **Sair da conta**: Encerra a sessão do usuário.

# Métodos da classe DbFunctions

## connect_to_db(String dbname, String user, String pass)
Conecta ao banco de dados PostgreSQL.

**Parâmetros:**
- `dbname`: Nome do banco de dados.
- `user`: Nome de usuário do banco de dados.
- `pass`: Senha do banco de dados.

**Retorna:** Objeto `Connection` se a conexão for bem-sucedida, `null` caso contrário.

## read(Connection conn, String table_name)
Lê a tabela de conteúdo (se necessário, podemos criar uma para ver a de usuário).

**Parâmetros:**
- `conn`: Objeto `Connection` para o banco de dados.
- `table_name`: Nome da tabela a ser lida.

**Retorna:** Nada.

## update(Connection conn, String table_name, String Column, String old_name, String new_name)
Atualiza um conteúdo da tabela baseado no nome.

**Parâmetros:**
- `conn`: Objeto `Connection` para o banco de dados.
- `table_name`: Nome da tabela onde os dados serão atualizados.
- `Column`: Nome da coluna a ser atualizada.
- `old_name`: Nome antigo do conteúdo.
- `new_name`: Novo nome do conteúdo.

**Retorna:** Nada.

## search_name(Connection conn, String table_name, String Column, String name)
Procura um conteúdo da tabela pelo nome.

**Parâmetros:**
- `conn`: Objeto `Connection` para o banco de dados.
- `table_name`: Nome da tabela onde os dados serão procurados.
- `Column`: Nome da coluna a ser procurada.
- `name`: Nome do conteúdo a ser procurado.

**Retorna:** Nada.

## delete_row(Connection conn, String table_name, String Column, String name)
Deleta uma linha dentro de uma tabela.

**Parâmetros:**
- `conn`: Objeto `Connection` para o banco de dados.
- `table_name`: Nome da tabela onde a linha será deletada.
- `Column`: Nome da coluna a ser deletada.
- `name`: Nome do conteúdo a ser deletado.

**Retorna:** Nada.

## delete_table(Connection conn, String table_name)
Deleta uma tabela inteira (cuidado).

**Parâmetros:**
- `conn`: Objeto `Connection` para o banco de dados.
- `table_name`: Nome da tabela a ser deletada.

**Retorna:** Nada.

# Métodos da classe Users

## createTable(Connection conn, String table_name)
Cria a tabela de usuários se ela não existir.

**Parâmetros:**
- `conn`: Objeto `Connection` para o banco de dados.
- `table_name`: Nome da tabela a ser criada.

**Retorna:** Nada.

## insertIntoUsers(Connection conn, String table_name, String username, String password)
Insere um novo usuário na tabela de usuários.

**Parâmetros:**
- `conn`: Objeto `Connection` para o banco de dados.
- `table_name`: Nome da tabela onde os dados serão inseridos.
- `username`: Nome de usuário a ser inserido.
- `password`: Senha a ser inserida.

**Retorna:** Nada.

# Métodos da classe Content

## createTable(Connection conn, String table_name)
Cria uma tabela de conteúdo se ela não existir.

**Parâmetros:**
- `conn`: Objeto `Connection` para o banco de dados.
- `table_name`: Nome da tabela a ser criada.

**Retorna:** Nada.

## insertInto(Connection conn, String table_name, String texto, String titulo, String autor)
Insere conteúdo na tabela de conteúdo.

**Parâmetros:**
- `conn`: Objeto `Connection` para o banco de dados.
- `table_name`: Nome da tabela onde os dados serão inseridos.
- `texto`: Texto a ser inserido.
- `titulo`: Título a ser inserido.
- `autor`: Autor a ser inserido.

**Retorna:** Nada.

# EN:

# Article Management System

This is a small Java program that implements an article management system. It allows you to add, list, edit, and delete content (articles) using a data structure called `LinkedList`.

## Features:

### Login:
- The program prompts for a login and password.
- If the login and password match, the user is successfully authenticated.

### Menu Options:

1. **Create new content**: Adds a new article to the list.
2. **List contents**: Displays all currently stored articles.
3. **Edit content**: Allows modifying the content of an existing article.
4. **Delete content**: Removes an article from the list.
5. **Log out**: Ends the user's session.

# Methods of the DbFunctions Class

## connect_to_db(String dbname, String user, String pass)
Connects to the PostgreSQL database.

**Parameters:**
- `dbname`: Name of the database.
- `user`: Database username.
- `pass`: Database password.

**Returns:** `Connection` object if the connection is successful, `null` otherwise.

## read(Connection conn, String table_name)
Reads the content table (if necessary, we can create one to view the user table).

**Parameters:**
- `conn`: `Connection` object for the database.
- `table_name`: Name of the table to be read.

**Returns:** Nothing.

## update(Connection conn, String table_name, String Column, String old_name, String new_name)
Updates content in the table based on the name.

**Parameters:**
- `conn`: `Connection` object for the database.
- `table_name`: Name of the table where the data will be updated.
- `Column`: Name of the column to be updated.
- `old_name`: Old name of the content.
- `new_name`: New name of the content.

**Returns:** Nothing.

## search_name(Connection conn, String table_name, String Column, String name)
Searches for content in the table by name.

**Parameters:**
- `conn`: `Connection` object for the database.
- `table_name`: Name of the table where the data will be searched.
- `Column`: Name of the column to be searched.
- `name`: Name of the content to be searched.

**Returns:** Nothing.

## delete_row(Connection conn, String table_name, String Column, String name)
Deletes a row within a table.

**Parameters:**
- `conn`: `Connection` object for the database.
- `table_name`: Name of the table where the row will be deleted.
- `Column`: Name of the column to be deleted.
- `name`: Name of the content to be deleted.

**Returns:** Nothing.

## delete_table(Connection conn, String table_name)
Deletes an entire table (use with caution).

**Parameters:**
- `conn`: `Connection` object for the database.
- `table_name`: Name of the table to be deleted.

**Returns:** Nothing.

# Methods of the Users Class

## createTable(Connection conn, String table_name)
Creates the user table if it does not exist.

**Parameters:**
- `conn`: `Connection` object for the database.
- `table_name`: Name of the table to be created.

**Returns:** Nothing.

## insertIntoUsers(Connection conn, String table_name, String username, String password)
Inserts a new user into the user table.

**Parameters:**
- `conn`: `Connection` object for the database.
- `table_name`: Name of the table where the data will be inserted.
- `username`: Username to be inserted.
- `password`: Password to be inserted.

**Returns:** Nothing.

# Methods of the Content Class

## createTable(Connection conn, String table_name)
Creates a content table if it does not exist.

**Parameters:**
- `conn`: `Connection` object for the database.
- `table_name`: Name of the table to be created.

**Returns:** Nothing.

## insertInto(Connection conn, String table_name, String text, String title, String author)
Inserts content into the content table.

**Parameters:**
- `conn`: `Connection` object for the database.
- `table_name`: Name of the table where the data will be inserted.
- `text`: Text to be inserted.
- `title`: Title to be inserted.
- `author`: Author to be inserted.

**Returns:** Nothing.