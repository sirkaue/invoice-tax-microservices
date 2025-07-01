# 🧾 Tax Calculator API

Este projeto simples em **Spring Boot** demonstra o uso do padrão de design **Strategy** dentro de uma 
arquitetura hexagonal para cálculo flexível e extensível de impostos.

## Objetivos

- **Praticar o padrão Strategy** dentro de arquitetura hexagonal.
- **Cálculo de impostos**: cálculo modular e desacoplado de impostos com base em solicitações simples.
- **Mock de dados**: simulação de dados sem necessidade de banco.

---

## Arquitetura do Projeto

O projeto adota a arquitetura hexagonal, separando o domínio, casos de uso, portas e adaptadores para 
máxima modularidade e testabilidade.

Organizado em três camadas principais:

`application`, `domain` e `infra`

### Estrutura de Pastas
```plaintext
.
└── com.sirkaue.taxcalculatorapistrategy/
    ├── application/
    │   ├── context/
    │   │   ├── TaxContext.java
    │   │   └── TaxContextImpl.java
    │   ├── ports/
    │   │   ├── in/
    │   │   │   └── CalculateTaxUseCase.java
    │   │   └── out/
    │   │       ├── factory/
    │   │       │   └── TaxStrategyFactory.java
    │   │       └── strategy/
    │   │           └── TaxStrategy.java
    │   └── usecase/
    │       └── CalculateTaxUseCaseImpl.java
    ├── domain/
    │   └── enums/
    │       └── TaxType.java
    ├── infra/
    │   ├── adapters/
    │   │   ├── in/
    │   │   │   ├── controller/
    │   │   │   │   └── TaxController.java
    │   │   │   ├── dto/
    │   │   │   │   ├── ErrorResponse.java
    │   │   │   │   ├── TaxRequest.java
    │   │   │   │   └── TaxResponse.java
    │   │   │   └── exception/
    │   │   │       └── GlobalExceptionHandler.java
    │   │   └── out/
    │   │       ├── factory/
    │   │       │   └── TaxStrategyFactoryImpl
    │   │       └── strategy/
    │   │           ├── ICMSStrategy.java
    │   │           ├── IRStrategy.java
    │   │           └── ISSStrategy.java
    │   └── config/
    │       └── CalculateTaxConfig
    └── TaxCalculatorApiStrategyApplication.java
```

## Componentes Principais

### Camada Application
- **TaxContext / TaxContextImpl**: Contexto que orquestra as estratégias de cálculo.
- **CalculateTaxUseCase (interface)**: Porta de entrada para o caso de uso.
- **CalculateTaxUseCaseImpl**: Implementação da lógica de cálculo que usa o contexto.

### Camada Domain
- **TaxType (enum)**: Enumeração dos tipos de imposto, fortalecendo o domínio.

### Camada Infra

#### Adaptadores de Entrada (in):
- **TaxController**: API REST que expõe o endpoint para cálculo.
- **TaxRequest / TaxResponse**: DTOs para comunicação via HTTP.

#### Adaptadores de Saída (out):
- Implementações específicas do **TaxStrategy** para ICMS, ISS e IR.

#### Configuração:
- **CalculateTaxConfig**: Configura os beans das estratégias e contexto.
---

## Endpoints Disponíveis

### 📌 Calcular imposto
**`POST /tax/calculate`**  
Calcula um imposto com base no tipo e no valor fornecido.

📥 **Requisição (JSON)**
```json
{
  "taxType": "ICMS",
  "amount": 1000
}
```
📥 **Resposta (JSON)**
```json
{
  "taxType": "ICMS",
  "amount": 1000.0,
  "totalTaxes": 170.0
}
```

### Tipos de imposto suportados:
- **ICMS**: → 17%
- **ISS**: → 5%
- **IR**: → 27.5%

---

## 🐳 Como Rodar com Docker

Este projeto utiliza um **Dockerfile multi-stage**, separando as etapas de build e runtime para gerar
uma imagem leve e eficiente.

### Clonar o repositório:
```bash
git clone https://github.com/sirkaue/tax-calculator-api-strategy.git
cd tax-calculator-api-strategy
```


### 📦 Build da Imagem

Execute o comando abaixo na raiz do projeto (onde está o `Dockerfile` e o `docker-compose.yml`):

```bash
docker-compose up --build
```


## Conclusão

Este projeto é um exemplo prático de como aplicar o padrão **Strategy** em uma aplicação com **Spring Boot**. 
Ele demonstra como calcular diferentes impostos de forma modular e flexível, 
permitindo fácil extensão para novos tipos de impostos.

Sinta-se à vontade para expandir este projeto, adicionando novos tipos de impostos, melhorias no design ou integração 
com outras fontes de dados!
