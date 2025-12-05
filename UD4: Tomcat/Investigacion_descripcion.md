# Componentes de Apache Tomcat
---

## Componentes principales de Tomcat

### Catalina

Catalina es el corazón de Tomcat, básicamente es el motor de servlets. Es el componente que se encarga de implementar todas las especificaciones de Java Servlet y JSP. Cuando arrancas Tomcat, lo que realmente estás arrancando es Catalina. Es como el cerebro que gestiona todo: las aplicaciones web, los contenedores, el ciclo de vida de los servlets, etc. El nombre Catalina viene de la isla de Santa Catalina en California, que está cerca de donde trabajaban los desarrolladores originales de Tomcat.

### Coyote

Coyote es el conector HTTP que usa Tomcat. Su trabajo es recibir las peticiones que llegan desde el navegador (o desde un servidor web como Apache) y convertirlas en algo que Catalina pueda entender. Básicamente hace de traductor entre el protocolo HTTP que hablan los navegadores y el lenguaje interno que usa Tomcat. También se encarga de enviar las respuestas de vuelta al cliente. Es el componente que está "escuchando" en el puerto 8080 esperando conexiones. Sin Coyote, Tomcat no podría comunicarse con el mundo exterior.

### Jasper

Jasper es el motor que se encarga de compilar las páginas JSP (JavaServer Pages). Cuando tienes un archivo .jsp en tu aplicación web, Jasper lo convierte en un servlet de Java, lo compila y luego lo ejecuta.

### Manager y Host Manager

Estos son dos aplicaciones web que vienen incluidas con Tomcat y sirven para administrarlo de forma visual desde el navegador. El **Manager** te permite gestionar las aplicaciones web que tienes desplegadas: arrancarlas, pararlas, desplegarlas nuevas, ver su estado, etc. Todo esto sin tener que tocar archivos de configuración ni reiniciar Tomcat. El **Host Manager** es parecido pero a nivel más alto, sirve para gestionar hosts virtuales completos.

---

## Estructura de directorios de Tomcat

### bin/

Aquí están todos los scripts y ejecutables para arrancar, parar y administrar Tomcat. Los archivos más importantes son `startup.sh` y `shutdown.sh` (o `.bat` en Windows). También está `catalina.sh` que es el script principal que controla todo. Básicamente todo lo que necesitas para controlar el servidor está aquí. Cuando instalas Tomcat, esta es una de las primeras carpetas que miras para saber cómo arrancarlo.

### conf/

Esta carpeta contiene todos los archivos de configuración. El más importante es `server.xml` donde se configura cómo funciona Tomcat: los puertos, los conectores, los hosts virtuales, etc. También está `web.xml` que tiene la configuración por defecto de todas las aplicaciones web, `tomcat-users.xml` donde defines los usuarios para acceder al Manager, y `context.xml` para configuración de contextos. Es como el cerebro de la configuración, cualquier cambio importante que quieras hacer en Tomcat probablemente lo tengas que hacer aquí.

### webapps/

Aquí es donde van todas las aplicaciones web que despliegues. Cuando copias un archivo .war o una carpeta con tu aplicación web aquí, Tomcat lo detecta automáticamente y lo despliega. Por defecto viene con algunas aplicaciones ya instaladas como ROOT (la página de inicio), el Manager, Host Manager, docs y examples. Cada carpeta dentro de webapps es una aplicación web diferente y el nombre de la carpeta se convierte en parte de la URL para acceder a ella.

### lib/

En esta carpeta están todas las librerías (archivos .jar) que usa Tomcat internamente y que están disponibles para todas las aplicaciones web. Aquí están las implementaciones de servlets, JSP, y otras librerías del núcleo de Tomcat. Es como la biblioteca común que comparten todas tus aplicaciones. Si necesitas que una librería esté disponible para todas tus aplicaciones, la pones aquí, aunque normalmente cada aplicación lleva sus propias librerías dentro de su carpeta WEB-INF/lib.

### logs/

Aquí se guardan todos los archivos de log de Tomcat. Cada día se crea un archivo nuevo donde se registra todo lo que pasa: arranques, paradas, errores, accesos, etc. Los archivos más importantes son `catalina.out` (el log principal) y `localhost_access_log` (los accesos a las aplicaciones). Cuando algo va mal, esta es la primera carpeta donde tienes que mirar para ver qué ha pasado.

---

## Flujo interno de funcionamiento

### 1. Recepción de peticiones

Todo empieza cuando alguien hace una petición HTTP a Tomcat, por ejemplo poniendo `http://localhost:8080/miapp` en el navegador. Lo primero que ocurre es que **Coyote** (el conector HTTP) recibe esa petición en el puerto 8080. Coyote se encarga de "leer" toda la petición HTTP que viene del navegador: la URL, los headers, los parámetros, etc. Una vez que ha leído todo, convierte esa petición HTTP en objetos Java que el resto de Tomcat puede entender, básicamente crea un objeto Request y un objeto Response.

### 2. Paso por los contenedores

Después, la petición pasa por una serie de **contenedores** que van procesándola en orden jerárquico. Primero pasa por el Engine (el motor principal), luego por el Host (que representa un host virtual), después por el Context (que representa una aplicación web específica), y finalmente llega al Wrapper (que representa un servlet concreto). Es como un sistema de cajas chinas, cada contenedor hace su trabajo y pasa la petición al siguiente nivel más específico. Por ejemplo, el Host decide a qué aplicación va dirigida la petición según la URL, y el Context identifica qué servlet debe procesarla.

### 3. Procesamiento de la petición

Si la petición es para un archivo JSP, entra en juego **Jasper**, que compila el JSP a un servlet si es necesario (o usa la versión ya compilada si existe). Si es para un servlet normal, simplemente se ejecuta directamente. El servlet procesa la petición, hace lo que tenga que hacer (consultar base de datos, lógica de negocio, etc.) y genera una respuesta, normalmente HTML. Todo esto lo gestiona **Catalina**, que es quien controla el ciclo de vida de los servlets y se asegura de que todo funcione correctamente.

### 4. Envío de la respuesta

Una vez que el servlet ha terminado de procesar la petición y ha generado la respuesta, todo el proceso se hace al revés. La respuesta vuelve a pasar por los contenedores, llega a Coyote, y Coyote la convierte de nuevo en una respuesta HTTP que el navegador puede entender. Finalmente Coyote envía la respuesta de vuelta al navegador a través de la red y el usuario ve el resultado en su pantalla. Todo este proceso normalmente pasa en milisegundos, por eso las páginas web cargan tan rápido.

### 5. Despliegue de aplicaciones

El despliegue de aplicaciones en Tomcat puede ser automático o manual. Si copias un archivo .war o una carpeta en `webapps/`, Tomcat lo detecta automáticamente (gracias a un componente llamado Host que está vigilando esa carpeta) y despliega la aplicación: descomprime el .war si hace falta, carga las clases, inicializa los servlets, etc. También puedes usar el **Manager** para desplegar aplicaciones desde el navegador sin tocar archivos. Cuando despliegas una aplicación, Tomcat crea un Context para ella, carga su configuración del web.xml, e inicializa todo lo necesario. Si paras una aplicación, Tomcat se encarga de liberar todos los recursos correctamente.

---

## Conclusión

Investigar sobre los componentes de Tomcat me ha ayudado a entender mucho mejor cómo funciona realmente un servidor de aplicaciones Java. Antes veía Tomcat como una caja negra donde metías un .war y de alguna forma funcionaba, pero ahora entiendo que hay muchos componentes trabajando juntos de forma coordinada.

Lo que más me ha gustado descubrir es cómo cada componente tiene su función específica: Coyote para las comunicaciones, Catalina para gestionar todo, Jasper para compilar JSPs, y cómo todos trabajan juntos. También me ha quedado claro por qué la estructura de directorios está organizada así, cada carpeta tiene su propósito y ahora sé dónde buscar cada cosa.

Entender el flujo de una petición HTTP desde que llega hasta que sale la respuesta también ha sido muy útil. Ahora cuando despliegue aplicaciones web en Tomcat voy a saber exactamente qué está pasando por dentro y dónde mirar si algo falla.
