
# Tutorial: Quarkus - Simplificando o Hibernate utilizando Panache, criando uma aplicação simples utilizando Quarkus Java + REST + CDI + Panache

[Link do artigo](https://www.linkedin.com/pulse/tutorial-quarkus-simplificando-o-hibernate-panache-da-silva-melo/)

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://quarkus.io">
  </a>
  <h3 align="center">Quarkus IO</h3>
</p>

![Logo do Artigo](https://www.flickr.com/photos/marcus-paulo/8711612303/)  

<!-- TABLE OF CONTENTS -->

## Tabela de Conteúdo

- [Tabela de Conteúdo](#tabela-de-conte%C3%BAdo)
- [Sobre o Projeto](#sobre-o-projeto)
  - [Feito Com](#feito-com)
- [Começando](#come%C3%A7ando)
  - [Pré-requisitos](#pr%C3%A9-requisitos)
  - [Estrutura de Arquivos](#estrutura-de-arquivos)
  - [Instalação](#instala%C3%A7%C3%A3o)
  - [Edição](#edi%C3%A7%C3%A3o)
  - [Publicação](#publica%C3%A7%C3%A3o)
- [Contribuição](#contribui%C3%A7%C3%A3o)
- [Licença](#licen%C3%A7a)
- [Contato](#contato)

<!-- ABOUT THE PROJECT -->

## Sobre o Projeto

Tutorial: Quarkus - Simplificando o Hibernate utilizando Panache, criando uma aplicação simples utilizando Quarkus Java + REST + CDI + Panache

### Feito Com

Tecnologias utilizadas no projeto

- [JAVA](https://www.java.com/pt_BR/download/) - Java é uma linguagem de programação e plataforma computacional lançada pela primeira vez pela Sun Microsystems em 1995. Existem muitas aplicações e sites que não funcionarão, a menos que você tenha o Java instalado, e mais desses são criados todos os dias;
- [Quarkus](https://quarkus.io/) - A Red Hat lançou o Quarkus, um framework Java nativo do Kubernetes feito sob medida para o GraalVM e OpenJDK HotSpot. O Quarkus visa tornar o java uma plataforma líder em ambientes serverless e Kubernetes, oferecendo aos desenvolvedores um modelo unificado de programação reativa e imperativa;
- [Panache](https://quarkus.io/guides/hibernate-orm-panache) - Simplificando a camada de persistência de dados.

<!-- GETTING STARTED -->

## Começando

Para reproduzir o exemplo, é necessário seguir os requisitos mínimos.

### Pré-requisitos

 - Você vai precisar de uma IDE como por exemplo: IntelliJ IDEA, Eclipse, VSCode.
 - Instale a JDK 8 or 11+
 - Instale o Apache Maven 3.5.3+ ou o Gradle
 - Panache Entity

 #### Docker
 - Escolha um cliente para conectar com o Banco de dados, exemplo: DBeaver, PGAdmin, Postico (Mac)
 - Cliente para realizar requisições REST: Postman ou o Insomnia.
 - Instruções Adicionais:
 - Instalação do Docker (Documentação oficial)
 - Instalando Docker no windows: (Youtube, ESR)
 - Instalando o Docker no Linux: (Youtube: LinuxTips)
 - Instalando o Docker no Mac: (Youtube: Wellington Rogati)

### Estrutura de Arquivos

A estrutura de arquivos está da seguinte maneira:

```bash
quarkus-panache-car
├── README.md
├── docs
│   └── postman
│       └── Quarkus-Panache-Car.postman_collection.json
├── pom.xml
├── quarkus-panache-car.iml
└── src
    ├── docs
    ├── main
    │   ├── docker
    │   │   ├── Dockerfile.jvm
    │   │   └── Dockerfile.native
    │   ├── java
    │   │   └── br
    │   │       └── com
    │   │           └── car
    │   │               ├── model
    │   │               │   └── Car.java
    │   │               ├── repository
    │   │               │   └── CarRepository.java
    │   │               └── resource
    │   │                   ├── CarResource.java
    │   │                   └── CarV2Resource.java
    │   └── resources
    │       ├── META-INF
    │       │   └── resources
    │       │       └── index.html
    │       ├── application.properties
    │       └── import.sql
    └── test
        └── java
            └── br
                └── com
                    └── car
                        └── resource
                            ├── CarResourceTest.java
                            └── NativeCarResourceIT.java

22 directories, 15 files

```

### Criação da aplicação

1. Para criar o projeto, basta utlizar o template do Maven + Quarkus, conforme o comando abaixo:

```sh
mvn io.quarkus:quarkus-maven-plugin:1.0.1.Final:create \
     -DprojectGroupId=br.com.car \
     -DprojectArtifactId=quarkus-panache-car \
     -DclassName="br.com.car.resource.CarResource" \
     -Dpath="/cars"
```

(Alternativo) - O Quarkus disponibiliza um site chamado `Quarkus.code.io`, onde é posísvel configurar o projeto de uma forma mais visual, vale a pena conferir, segue o link: https://code.quarkus.io/

---

#### Executando a Instância do Postgresql no Docker 

Para iniciar o Postgresql, basta rodar o comando abaixo (O Docker precisa estar instalado): 

```sh
$ docker run --name postgres-car -e "POSTGRES_PASSWORD=postgres" -p 5433:5432 -v ~/developer/PostgreSQL:/var/lib/postgresql/data -d postgres
```

### Executando o projeto em Quarkus

Para executar um projeto em Quarkus, basta executar o comando: 
```sh
mvn compile quarkus:dev
```

<!-- CONTRIBUTING -->

## Contribuição

Fique a vontade para contribuir com o projeto.

1. Faça um Fork do projeto
2. Crie uma Branch para sua Feature (`git checkout -b feature/newFeature`)
3. Adicione suas mudanças (`git add .`)
4. Comite suas mudanças (`git commit -m 'Nova funcionalidade para facilitar ...`)
5. Faça o Push da Branch (`git push origin feature/newFeature`)
6. Abra um Pull Request

<!-- LICENSE -->

## Licença

Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.

<!-- CONTACT -->

## Contato

Marcus Paulo - [Github](https://github.com/marcuspaulo)
