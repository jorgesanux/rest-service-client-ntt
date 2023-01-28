# Servicio REST de cliente
Prueba técnica para desarrollador backend en NTT Data.
Según como se especificó, se realiza un servicio REST que recibe por parámetros el número de documento del cliente y el tipo de documento, para luego retornar un cliente mockeado.

## Documentación técnica
- **Host**: Varía dependiendo de donde se ejecute, por defecto en una máquina local es ```localhost```
- **Port**: ```8090```
- **EndPoint**: ```/client```
- **Query Params**:
  - *Número de documento*: ```doc_number```
  - *Tipo de documento*: ```doc_type``` \
    Puede tomar dos valores: ```P``` para pasaporte y ```C``` para cédula de ciudadanía.
- **HTTP Code Response**:
  - 400 BAD REQUEST
  ```json
    {
      "timestamp": "2023-01-28T07:17:47.873+00:00",
      "status": 400,
      "error": "Bad Request",
      "message": "Required parameter 'doc_type' is not present.",
      "path": "/client"
    }
  ```
  - 500 INTERNAL SERVER ERROR
  ```json
    {
      "timestamp": "2023-01-28T07:20:51.657+00:00",
      "status": 500,
      "error": "Internal Server Error",
      "message": "Unexpected error",
      "path": "/client"
    }
  ```
  - 200 OK
  ```json
    {
      "statucCode": 200,
      "message": "OK",
      "result": {
          "documentNumber": "23445322",
          "typeDocument": "C",
          "firstName": "Juan",
          "secondName": "Alberto",
          "firstLastName": "Perez",
          "secondLastName": "Diaz",
          "phoneNumber": "987456321",
          "address": "Calle 1 # 1 - 1",
          "city": "Londres"
      }
    } 
  ```
  - 404 NOT FOUND
  ```json
    {
      "statucCode": 404,
      "message": "Client 23445322 with document type P not found",
      "error": "Not Found"
    }
  ```
- **Content Type**: JSON
- **Tests**: ```./src/test/java/com/ex/client```
- **Source code**: ```./src/main/java/com/ex/client```

## Ejemplo
El servicio se podría consumir mediante la siguiente URL, la cual posee las características mencionadas anteriormente:
```localhost:8090/client?doc_number=23445322&doc_type=C```
Se puede observar el puerto ```8090``` y los diferentes query params

## Autor
Jorge Sanabria\
[GitHub](https://github.com/jorgesanux)\
[LinkedIn](https://www.linkedin.com/in/jorge--sanabria/)