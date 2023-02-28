# Car Portal

## Portal de Anúncios de Carros

Poc utilizando comunicação híbrida de microserviços com Java, Spring Boot, API's REST e Apache Kafka.

Através da API principal se faz o crud do Anunciante e também dos Carros anunciados. 
A API se comunica de forma assíncrona através de eventos Kafka e de forma síncrona através da api Rest Template com os outros serviços.


![Arquitetura](https://github.com/antoniocesarlopes/car-portal/raw/main/architecture.png)

