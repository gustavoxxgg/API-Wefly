# API da Agência de Viagens: WeFly ✈️

Esta API fornece a ponte entre o site WeFly e o banco de dados, permitindo a busca, inserção, atualização e deleção de informações sobre voos, reservas e detalhes relacionados.

## 🚀 Tecnologias Utilizadas

- Java
- Maven
- Spring Boot

## 🖥️ Instalação e Execução

1. Clone este repositório:
`git clone [link-do-repositorio]`

2. Navegue até a pasta do projeto:
`cd nome-da-pasta`

3. Construa o projeto com Maven:
`mvn clean install`

4. Execute a aplicação:
`mvn spring-boot:run`

## 🌐 Endpoints

- GET /: Retorna Welcome.
- GET /voos: Retorna a Lista de Voos.
- GET /users: Retorna a lista de usuários cadastrados.
- POST /save: Salva novos usuarios na DB
- PUT /update/{id}: Atualiza uma informação do usuário com id correspondente
- DELETE /delete/{id}: Deleta o usuário com id correspondente
- POST /login: Tenta fazer a autenticação dos dados do usuário e após isso faz o login

## 📝 Configuração

Certifique-se de configurar o arquivo application.properties para definir detalhes do banco de dados, como URL, usuário e senha.

## 🚧 Contribuições

Este projeto está aberto para sugestões e contribuições. Sinta-se à vontade para abrir um issue ou enviar um pull request.

## 📜 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.