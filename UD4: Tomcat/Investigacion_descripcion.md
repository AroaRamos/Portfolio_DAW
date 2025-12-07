# Componentes de Apache Tomcat

En esta tarea he investigado los principales componentes de Apache Tomcat para entender mejor cómo funciona este servidor.

---

## Componentes principales de Tomcat

### Catalina

Catalina es el motor principal de Tomcat. Cuando arrancas Tomcat, lo que realmente estás arrancando es Catalina. Se encarga de gestionar todas las aplicaciones web que tienes: arrancarlas, pararlas, controlar que funcionen bien, etc. También gestiona la memoria y los recursos que usa cada aplicación. Básicamente sin Catalina no hay Tomcat, es el componente más importante de todos.

### Coyote

Coyote es el que recibe las peticiones que llegan desde Internet. Está constantemente escuchando en un puerto (normalmente el 8080) esperando a que lleguen conexiones. Cuando tú pones una URL en el navegador, quien recibe esa petición es Coyote. Luego Coyote se la pasa a Catalina para que la procese, y cuando hay una respuesta lista, Coyote la envía de vuelta al navegador.

### Jasper

Jasper se encarga de las páginas JSP, que son archivos con código Java mezclado con HTML. Lo que hace es convertir esos archivos JSP en código Java normal que el ordenador puede ejecutar. La primera vez que entras en una página JSP tarda un poco porque tiene que hacer esta conversión, pero luego ya la tiene preparada y va rápido. Si modificas el archivo JSP, Jasper lo detecta y lo vuelve a convertir automáticamente.

### Manager y Host Manager

Son dos herramientas que vienen con Tomcat y te permiten administrarlo desde el navegador sin tener que usar comandos. Con el **Manager** puedes ver qué aplicaciones están funcionando, pararlas, arrancarlas, o subir aplicaciones nuevas. El **Host Manager** es parecido pero para gestionar hosts virtuales. Para usarlos necesitas tener un usuario y contraseña configurados.

---

## Estructura de directorios de Tomcat

### bin/

Aquí están los programas para arrancar y parar Tomcat. Los archivos más importantes son `startup.sh` y `shutdown.sh` (en Linux) o `startup.bat` y `shutdown.bat` (en Windows). Cuando quieres encender Tomcat ejecutas startup, y cuando quieres apagarlo ejecutas shutdown. 

### conf/

Esta carpeta tiene todos los archivos de configuración. El más importante es `server.xml` donde se configura todo: el puerto que usa Tomcat, cómo se conecta, etc. También está `tomcat-users.xml` donde defines los usuarios y contraseñas para entrar al Manager. Es como el panel de control de Tomcat.

### webapps/

Aquí es donde pones tus aplicaciones web. Si copias una aplicación aquí, Tomcat la detecta automáticamente y la pone en marcha. Por defecto ya vienen algunas aplicaciones instaladas como la página de inicio, el Manager y algunos ejemplos. Cada carpeta dentro de webapps es una aplicación diferente. 

### lib/

Aquí están las librerías que usa Tomcat para funcionar. Son archivos .jar que contienen código Java. Estas librerías las usan todas las aplicaciones por igual, están compartidas. Normalmente no tienes que tocar nada aquí, son cosas internas de Tomcat. 

### logs/

Aquí se guardan los registros de todo lo que pasa en Tomcat. Cada día se crea un archivo nuevo donde se apunta todo: cuando arranca, cuando para, si hay errores, qué páginas se visitan, etc. Si algo falla y quieres saber qué ha pasado, miras los archivos de esta carpeta. El archivo principal suele ser `catalina.out`.

---

## Flujo interno de funcionamiento

### Recepción de peticiones

Cuando alguien entra en tu página web (por ejemplo escribe `http://localhost:8080/miapp` en el navegador), la primera parada es **Coyote**. Coyote es el que está escuchando en el puerto 8080 esperando peticiones. Recibe toda la información que envía el navegador: qué página quieres, qué datos envías, etc. Una vez que tiene toda esa información, se la pasa a Catalina para que la procese.

### Contenedores

La petición pasa por varios niveles dentro de Tomcat. Primero identifica a qué aplicación web va dirigida mirando la URL. Por ejemplo, si pones `/miapp/index.html`, sabe que tiene que ir a la aplicación "miapp". Luego dentro de esa aplicación busca el archivo o página concreta que has pedido. 

### Despliegue de aplicaciones

Cuando copias una aplicación nueva en la carpeta `webapps/`, Tomcat se da cuenta automáticamente. Si es un archivo .war (que es como un zip con toda la aplicación), lo descomprime él solo. Luego prepara todo lo necesario para que la aplicación funcione: carga la configuración, prepara la memoria, etc. También puedes usar el Manager para subir aplicaciones desde el navegador. Cuando quitas una aplicación de webapps, Tomcat también lo detecta y la quita de memoria.
