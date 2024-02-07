# API de Calculo de Rentabilidades

Esta é uma API desenvolvida em Java com Spring Boot para calcular rentabilidades mensais a partir de dados de rentabilidades diárias de um fundo. A API lista as rentabilidades mensais de um determinado ano em ordem decrescente.

## Funcionalidades

- Calcula e lista as rentabilidades mensais de um determinado ano em ordem decrescente.
- Aceita como entrada um arquivo de texto no formato dd/MM/yyyy;rentabilidade onde a primeira linha é o cabeçalho e as linhas seguintes representam as rentabilidades diárias.

## Requisitos

- Java
- SpringBoot
- Maven
- JDK

## Como rodar o projeto

- Clonar o repositório
- Abrir o projeto na IDE de sua preferencia
- Configurar o JDK
- Importar as dependências do Maven
- O arquivo de entrada ja esta configurado, garanta que esteja no caminho "resources/file"
- Executar a aplicação

## Endpoints Disponíveis

### Listar todas as rentabilidades em ordem decrescente

- **URL:** `GET /api/rentabilidades?ano={ano}`
- **Descrição:** Lista todas as rentabilidades do periodo do ano informado.

- **Resposta da Requisição:**

```json
[
  {
    "mes": "04/2023",
    "rentabilidade": 11.12
  },
  {
    "mes": "06/2023",
    "rentabilidade": 7.9
  },
  {
    "mes": "10/2023",
    "rentabilidade": 5.73
  },
  {
    "mes": "09/2023",
    "rentabilidade": 5.59
  },
  {
    "mes": "07/2023",
    "rentabilidade": 5.39
  },
  {
    "mes": "02/2023",
    "rentabilidade": 4.68
  },
  {
    "mes": "05/2023",
    "rentabilidade": 3.69
  },
  {
    "mes": "01/2023",
    "rentabilidade": 3.18
  },
  {
    "mes": "08/2023",
    "rentabilidade": 3.14
  },
  {
    "mes": "12/2023",
    "rentabilidade": 2.66
  },
  {
    "mes": "03/2023",
    "rentabilidade": 1.67
  },
  {
    "mes": "11/2023",
    "rentabilidade": 1.2
  }
]
```