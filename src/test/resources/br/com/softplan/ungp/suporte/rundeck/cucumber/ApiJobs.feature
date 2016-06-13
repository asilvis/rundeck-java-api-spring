#language: pt
#encoding: UTF-8
Funcionalidade: Api de Jobs
  Eu como desenvolvedor
  Quero consumir a Api de Jobs
  Para poder realizar integrações com meus sistemas

  Cenario: Listar Jobs de um Projeto
    #application.properties
    Dado que estou autenticado via Token
    Quando buscar os jobs do projeto "PMSBC-TST"
    Então retornará os jobs "Ações do Ambiente, Container Logs, Restart Geral"

  Cenario: Listar definição de um job
    Dado que estou autenticado via Token
    Quando buscar as definições do job com id "4411650d-dcca-4407-a9b8-83bdc0c28011"
    Então retornará a definição de job:
      | name              | description                        | id                                   |
      | Ações do Ambiente | run, start, stop, restart, rm, rmi | 4411650d-dcca-4407-a9b8-83bdc0c28011 |
    E na definição de job estarão presentes as opções:
      | name      | description | enforcedvalues | required | valuesUrl | values                                                                                                                                                                                                 |
      | Instancia |             | true           | true     |           | cpa-pmsbc-ext-1,cpa-pmsbc-int-1,cpa-pmsbc-int-2,cpa-pmsbc-int-3,cpa-pmsbc-int-4,infra-pmsbc-broffice,infra-pmsbc-httpd,sup-pmsbc-int-1,sup-pmsbc-int-2,sup-pmsbc-int-3,sup-pmsbc-int-4,sup-pmsbc-int-5 |
      | Instrucao |             | true           | true     |           | restart,rm,rmi,run,start,stop                                                                                                                                                                          |
