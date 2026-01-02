# Documentación final — Apache Tomcat

En esta documentación recojo todo el trabajo realizado con **Apache Tomcat**, desde su arquitectura básica hasta el despliegue en contenedores Docker. El objetivo es dejar constancia de la configuración, pruebas y buenas prácticas aprendidas durante las distintas prácticas.

---

## 1. Arquitectura básica de Tomcat

Apache Tomcat es un **servidor de aplicaciones Java** que implementa principalmente las especificaciones **Servlet** y **JSP**.

La arquitectura básica de Tomcat se organiza de la siguiente forma:

- **Server**  
  Es el componente principal que engloba toda la configuración del servidor.

- **Service**  
  Une uno o varios **Connectors** con un **Engine**.

- **Connector**  
  Se encarga de recibir las peticiones HTTP/HTTPS (por ejemplo en los puertos 8080 y 8443).

- **Engine**  
  Procesa las peticiones y las envía al host correspondiente.

- **Host**  
  Representa un host virtual (por ejemplo `localhost`).

- **Context**  
  Corresponde a una aplicación web concreta.

Gracias a esta estructura, Tomcat permite gestionar múltiples aplicaciones y hosts de forma organizada.

---

## 2. Configuración del servidor

La configuración principal de Tomcat se realiza mediante archivos XML ubicados en el directorio `conf/`.

Los archivos más importantes que he utilizado son:

- **server.xml**  
  Configuración de conectores, puertos, hilos y HTTPS.
- **tomcat-users.xml**  
  Gestión de usuarios y roles.
- **web.xml**  
  Configuración global de aplicaciones.

Ejemplo de conector HTTP configurado:

```xml
<Connector
    port="8080"
    protocol="HTTP/1.1"
    connectionTimeout="20000"
    redirectPort="8443"
    maxParameterCount="1000" />
````

Ejemplo de conector HTTPS configurado:

```xml
<Connector port="8443"
           protocol="org.apache.coyote.http11.Http11NioProtocol"
           maxThreads="150"
           SSLEnabled="true">
    <SSLHostConfig>
        <Certificate
            certificateKeystoreFile="conf/tomcat.jks"
            certificateKeystorePassword="changeit"
            type="RSA" />
    </SSLHostConfig>
</Connector>
```

Después de cualquier cambio en la configuración, reinicio Tomcat para aplicar los ajustes.

---

## 3. Integración con servidor web

Tomcat puede integrarse con servidores web como **Apache HTTP Server** o **Nginx**, funcionando como servidor de aplicaciones mientras el servidor web actúa como frontal.

Las ventajas de esta integración son:

* Mejor rendimiento para contenido estático.
* Mayor seguridad.
* Posibilidad de balanceo de carga.
* Separación de responsabilidades.

En mi caso, trabajo directamente con Tomcat, pero entiendo que en entornos reales esta integración es muy habitual.

---

## 4. Seguridad aplicada

Durante las prácticas aplico varias medidas básicas de seguridad en Tomcat:

### Autenticación y roles

Configuro usuarios y roles en `tomcat-users.xml` para proteger las aplicaciones de administración:

```xml
<role rolename="manager-gui"/>
<role rolename="admin-gui"/>

<user username="admin"
      password="admin123"
      roles="manager-gui,admin-gui"/>
```

Esto restringe el acceso al **Manager** y **Host Manager** solo a usuarios autorizados.

### HTTPS

Configuro HTTPS mediante un **keystore** generado con `keytool` y un conector SSL en el puerto 8443, garantizando una comunicación cifrada.

### Restricción de accesos

Las aplicaciones de administración no están disponibles sin autenticación, lo que evita accesos no autorizados.

---

## 5. Pruebas de rendimiento

Realizo pruebas de rendimiento utilizando la herramienta **ApacheBench (ab)**.

Ejecuto pruebas de carga simulando múltiples usuarios concurrentes:

```bash
ab -n 1000 -c 10 http://localhost:8080/sample/
```

Analizo principalmente:

* Peticiones por segundo.
* Tiempo medio por petición.
* Tiempo total de la prueba.
* Peticiones fallidas.

Comparo los resultados **antes y después** de realizar ajustes en el servidor, comprobando cómo los cambios en la configuración pueden afectar al rendimiento.

---

## 6. Recomendaciones de administración

Tras trabajar con Tomcat, destaco las siguientes recomendaciones:

* Reiniciar Tomcat siempre después de cambios en configuración.
* Usar HTTPS en entornos reales.
* Proteger Manager y Host Manager con usuarios y roles.
* Monitorizar el rendimiento periódicamente.
* Ajustar los hilos según la carga esperada.
* Mantener Tomcat y Java actualizados.

Estas buenas prácticas ayudan a mantener un servidor estable y seguro.

---

## 7. Despliegue en contenedores (Docker)

También trabajo con **Tomcat en contenedores Docker**, lo que facilita el despliegue y la portabilidad.

Pasos principales realizados:

* Descarga de la imagen oficial:

```bash
docker pull tomcat:latest
```

* Creación y arranque del contenedor:

```bash
docker run -d --name tomcat-docker -p 8081:8080 tomcat:latest
```

* Despliegue de una aplicación copiando el directorio `ROOT`:

```bash
docker cp ROOT tomcat-docker:/usr/local/tomcat/webapps/
docker restart tomcat-docker
```

Docker permite aislar el servidor, evitar conflictos y replicar fácilmente el entorno.
