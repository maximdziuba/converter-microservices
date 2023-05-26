# Currency-converter app #
Currency-converter API built with microservices
This is an API, with the same functionallity as my previous project https://github.com/maximdziuba/custom-converter-api . But this time I have built this app, as microservices. 

To run the app, you have to start all the modules:

1. Config Service
- ``cd config-service``
- ``./mvnw spring-boot:run``
- ``cd ..``

2. Discovery Service
- ``cd discovery-service``
- ``./mvnw spring-boot:run``
- ``cd ..``

3. Converter Service
- ``cd converter-service``
- ``./mvnw spring-boot:run``
- ``cd ..``

4. Currency Service
- ``cd currency-service``
- ``./mvnw spring-boot:run``
- ``cd ..``

5. Parser Service
- ``cd parser-service``
- ``./mvnw spring-boot:run``


Also you have to change path to config directory in ``application.yml`` in config-service.
After all modules are running, you can test the app:
``http://localhost:8082/converter?from=<currency>&to=<currency>&value=<value>``

Example:
``http://localhost:8082/converter?from=uah&to=usd&value=100``

List of currencies: 
- uah
- chf
- eur
- dkk
- cad
- usd
- rub
- byn
- czk
- pln
