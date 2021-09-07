# Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot
## Início
- Instalar o SDK MAN
### Comandos
- skd list java | list → listagem das versões
- sdk install java 11.0.11.hs-adpt → instalar versão
- sdk use java 11.0.11.hs-adpt → setar a versão
- sdk list maven → listar versões
- sdk install maven 3.6.3 → instalar versão
- sdk use maven 3.6.3 → setar versão

## O que é Rest?
- Padrão arquitetural
- Melhoria do método SOAP que necessitava de um arquivo xml enorme.
- Objetivo: simplificar a integração entre múltiplos sistemas por meio do protocolo HTTP.
- Verbos: get (read); put(update/replace); patch (update/modify); post(create); delete(exclusion).

## REST x RESTfull
- Rest = padrão arquitural.
- Restfull = adequação ao padrão arquitetural rest.
- Níveis de um restfull 0 (api sem padrão de nomeclatura); 1 (recursos - padronização de rotas); 2 (uso dos verbos get, post, put, delete); 3 (controle de hypermedias = informação de outras operações possíveis após uma operação, por exemplo, operação de um usuário).

## Criação do projeto
- https://start.spring.io/
- Opções: Maven project, Spring boot 2.5.2, jar, java 11
### Dependências
- https://start.spring.io/
- Spring Boot DevTools
- Lombok
- Spring Web
- Spring Data JPA
- Spring Boot Actuator
- H2 Database

## Selecionando o SKD
- Após abrir o projeto no Intellij, selecione file → project → SDK → java 11
- Crie uma classe Controller e teste no localhost 8080

## Subindo o app no Heroku
- Criar um arquivo `system.propersties` na raiz do projeto e definir a versão do java nesse arquivo (`java.runtime.version=11`)
- Criar o app
- Adicionar o repositório
- Habilitar o deploy automático
- Conectar