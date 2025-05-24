# 🎵 Spotifei – Projeto Java com PostgreSQL

Bem-vindo ao **Spotifei**, um sistema de músicas inspirado no Spotify, desenvolvido em Java com interface gráfica (Swing), banco de dados PostgreSQL e arquitetura MVC.

---

## 🚀 Funcionalidades

- **Login e Cadastro de Usuário**
- **Buscar Músicas** por Nome, Gênero ou Artista
- **Curtir e Descurtir Músicas**
- **Histórico de Buscas** (últimas 5 buscas)
- **Visualizar Músicas Curtidas**
- **Recomendar Músicas Não Curtidas**
- **Sistema de Playlists**:
  - Criar, visualizar e excluir playlists
  - Adicionar e remover músicas da playlist

---

## 🧱 Tecnologias Utilizadas

- **Java** (Swing para interface gráfica)
- **PostgreSQL** (via pgAdmin 4)
- **JDBC** para conexão com o banco
- **NetBeans** como IDE principal

---
```
## 🗃️ Estrutura do Projeto
├── Controller
│ └── LoginController.java, CadastroController.java, ...
├── DAO
│ └── Conexao.java, UsuarioDAO.java, CurtidaDAO.java, ...
├── Model
│ └── Usuario.java, Musica.java, Playlist.java, ...
├── View
│ └── LoginFrame.java, BuscarMusicaFrame.java, ...
├── README.md
└── Relatorio_Spotifei.docx

```
---

## 🗄️ Banco de Dados

O banco foi criado com as seguintes tabelas principais:

- `usuario`
- `artista`
- `musica`
- `curtida` (chave composta)
- `playlist`
- `playlist_musica`
- `historico_busca`

As **chaves estrangeiras** garantem integridade entre entidades.

---

## 💡 Funcionalidades em Destaque

### 🎶 Buscar e Curtir Músicas
- Buscar músicas por qualquer campo
- Curtir com apenas um clique
- Exibir histórico de buscas no mesmo frame

### ❤️ Curtidas
- Visualizar suas músicas curtidas
- Descurtir diretamente da lista
- Ver sugestões de músicas ainda não curtidas

### 📂 Playlists
- Criar playlists personalizadas
- Adicionar/remover músicas da playlist
- Ver todas as músicas dentro de uma playlist

---

## 🧠 Padrões Utilizados

- **MVC (Model-View-Controller)** para separar responsabilidades
- **DAO (Data Access Object)** para acesso ao banco
- Classe `UsuarioLogado` para manter o usuário em sessão

---

## 📝 Relatório do Projeto e Javadoc

Um documento com todo o passo a passo está disponível:  
📄 [Relatorio_Spotifei.docx](./Relatorio_Spotifei.docx)  
📄 file:///C:/Users/erikg/OneDrive/Documentos/NetBeansProjects/Spotfei/dist/javadoc/index.html

---

## 📌 Observações

Este projeto foi desenvolvido para praticar conceitos de Java Orientado a Objetos, integração com banco de dados e construção de interfaces gráficas.

---

## 🧑‍💻 Desenvolvedor

**Erik Ordine**  
[GitHub](https://github.com/erikordine)  
Aluno de Ciência da Computação  
Centro Universitário FEI

---
