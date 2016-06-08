#language: pt
#encoding: UTF-8
Funcionalidade: Api de Projetos
  Eu como desenvolvedor
  Quero consumir a Api de Projetos
  Para poder realizar integrações com meus sistemas

  Cenario: Listar Projetos
    #application.properties
    Dado que estou autenticado via Token
    Quando buscar os projetos existentes
    Então retornará a listagem de definições do projetos


  Cenario: Listar Informação de um projetos
    Dado que estou autenticado via Token
    Quando buscar o projeto "PMSBC-TST"
    Então retornará a definição:
      | url                                                           | name      | description |
      | https://rundeck-ungp.softplan.com.br/api/17/project/PMSBC-TST | PMSBC-TST |             |