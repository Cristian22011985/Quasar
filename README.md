# Examen de Mercadolibre Operación Fuego de Quasar

Examen tecnico enfocado en desarrollo backend, el cual consiste en la realizacion de una API Rest que debe devolver un mensaje y posicion (puntos cardinales) de acuerdo a la informacion recibida, la misma puede llegar en un unico envio o varios.


El enunciado completo del proyecto se describe en el archivo Challenge BE.pdf que se encuentra en la carpeta documentacion. 

## Tecnologias utilizadas 

Java 8,
Spring Boot,
Junit,
Postgresql,
Maven


## Pasos para ejecutar el programa

Para poder correr la applicacion de forma local se requiere contar con :

Java JDK 1.8
Maven
Servidor de Base de datos Postgresql (recomendable usar version 13 o superior)

El fuente se puede descargar o clonar (mediante Git) del siguiente repositorio:

     - https://github.com/Cristian22011985/Quasar.git

Para clonar el repositorio se debe abrir la consola de git y ejecutar el siguiente comando: 

     - Git clone https://github.com/Cristian22011985/Quasar.git

Una vez obtenido el codigo fuente se puede ejecutar desde un IDE ej: IntelliJ IDEA, Netbeans, Eclipse, etc.

O con maven ejecutando la siguiente linea :

mvn exec:java -Dexec.mainClass="exam.cristian.quasar.QuasarApplication"

El archivo properties debera contener se deberan modificar los valores correspondientes a la base de datos utilizada para poder conectarse correctamente.

## Aplicacion en Heroku

Actualmente la aplicacion se encuentra alojada en heroku en la url :

   - https://quasarbe.herokuapp.com/


Se pueden realizar las siguientes peticiones:

   - GET /topsecret_split:en caso de que se exista en la base la informacion necesaria retornara el mensaje completo y las cordenadas del punto desde el cual se envio.en caso contrario retornara HTTP Status ```NOT FOUND```. 

   - POST /topsecret_split/{satellite_name} ,acepta la informacion tal cual la recibio uno solo de los satellites, satellite_name solo acepta 3 valores   (sato,skywalker,kenobi) en caso de no ser uno de los mencionado devuelve ```BAD_REQUEST```, el cuerpo se debe enviar con uno de los siguientes formatos, en el caso de enviar name si el mismo no coincide con el de la url se tomara el que se encuentra en la url.
	
   - formato 1
    
   ```
   
   { 
     "distance": 100.0,
     "message": ["este", "", "", "mensaje", ""]      
   }
   
  ```
  
  - formato 2
     
  ```
  
  { 
    "name": "sato", 
    "distance": 100.0,
    "message": ["este", "", "", "mensaje", ""]      
   }
   
  ```
   - DELETE /topsecret_split/delete   borrara toda la informacion que se haya enviado anteriormente

  
   - POST /topsecret/ se debe enviar la informacion tal cual la recibieron los 3 satellites el cuerpo del mensaje debe poseer este 
     formato para poder retornar el mensaje completo y las coordenadas desde donde se envio el mensaje
  
  ```
  
   {
	"satellites": [{
			"name": "kenobi",
			"distance": 100.0,
			"message": ["este", "", "", "mensaje", ""]
		},
		{
			"name": "skywalker",
			"distance": 115.5,
			"message": ["", "es", "", "", "secreto"]
		},
		{
			"name": "sato",
			"distance": 142.7,
			"message": ["este", "", "un", "", ""]
		}
	 ]
  }	
  
  ```
  

Para realizar las peticiones, se puede usar CURL, postman o cualquier otra herramienta.



