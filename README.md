# Avaliação Java

## O que é essa API ?
Se trata de uma camada de serviço de calculo de frete de uma empresa de transportes SigaBem,
calculando o valor total do frete e o prazo de entrega.

## Execução e Ferramentas
Para efetuar a execução do projeto basta executar o comando abaixo na pasta raiz do projeto:

    mvn clean install && cd target/ && java -jar demoFrete-0.0.1-SNAPSHOT.jar


## EndPoint
* POST http://localhost:8080/frete/calcular

  Realiza o calculo do valor do frete com base no peso do produto e no cep de origem e destino, recebendo os dados

  RequestBody:
```json
{
    "peso": 100,
    "cepOrigem": "12230720",
    "cepDestino": "23932490",
    "nomeDestinatario": "Deodato"
}
```

Response:
```json
{
    "peso": 100,
    "cepOrigem": "12230720",
    "cepDestino": "23932490",
    "nomeDestinatario": "Deodato",
    "vlTotalFrete": 100.0,
    "dataPrevistaEntrega": "2022-07-20",
    "dataConsulta": "2022-07-10"
}
```

## Frameworks

Foi utilizado no projeto o framework Spring-Boot, utilizei os módulos JPA(Spring-JPA) e banco de dados(Spring-Data). Utilizei ambos por serem os que tenho familiaridade e por eles auxiliarem na manipulação de repositório e integração com o banco de dados.

Também utilizei o Lombok, que auxilia no desenvolvimento, fazendo com que seja necessário menos escrita de código, pois ele possui uma inteligencia para gerar esses códigos, nesse projeto, ele me ajudou nos Getters, Setters e Constructors.