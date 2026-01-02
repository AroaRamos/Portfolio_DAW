# Tomcat: Despliegue simple de una aplicación web

En este ejercicio realizo el despliegue de una aplicación web en Apache Tomcat, comprobando su funcionamiento desde el navegador y observando el despliegue automático de un archivo WAR.

---

## 1. Comprobación inicial y arranque de Tomcat

En primer lugar intento arrancar Tomcat desde la carpeta donde lo he descargado.  
Al ejecutar el script de inicio (`startup.sh`), Tomcat no arranca correctamente porque no detecta Java instalado en el sistema.

### Captura – Arranque de Tomcat sin Java configurado

![Arranque de Tomcat sin Java](01_arranque_tomcat_sin_java.png)

---

## 2. Instalación de Java (OpenJDK 11)

Para solucionar el problema, instalo **OpenJDK 11**, que es una versión compatible con Tomcat 10.  
Después compruebo que Java se ha instalado correctamente y que la herramienta `keytool` funciona sin errores.

### Captura – Java 11 instalado y verificado

![Java 11 instalado y keytool](02_java_11_jdk_instalado_y_keytool.png)

---

## 3. Arranque correcto de Tomcat

Una vez Java está instalado, vuelvo a ejecutar el script `startup.sh`.  
En esta ocasión Tomcat arranca correctamente y el sistema muestra el mensaje de inicio sin errores.

### Captura – Arranque correcto de Tomcat

![Arranque correcto de Tomcat](03_arranque_correcto_tomcat.png)

---

## 4. Comprobación del puerto 8080

Compruebo que Tomcat está escuchando en el puerto **8080** utilizando un comando de red desde la terminal.  
El resultado confirma que el proceso Java está activo en dicho puerto.

### Captura – Tomcat escuchando en el puerto 8080

![Tomcat escuchando en el puerto 8080](04_tomcat_escuchando_8080.png)

---

## 5. Acceso a Tomcat desde el navegador

Accedo desde el navegador a la dirección:

`http://localhost:8080`

Se puede ver la página de inicio de Apache Tomcat, lo que confirma que el servidor está funcionando correctamente.

### Captura – Página de inicio de Apache Tomcat

![Página de inicio de Tomcat](05_tomcat_pagina_inicio_8080.png)

---

## 6. Descarga de una aplicación WAR de ejemplo

Descargo una aplicación de ejemplo en formato WAR (`sample.war`) desde la documentación oficial de Tomcat utilizando el comando `wget`.

### Captura – Descarga del archivo sample.war

![Descarga del archivo sample.war](06_descarga_sample_war.png)

---

## 7. Despliegue automático del archivo WAR

Muevo el archivo `sample.war` a la carpeta `webapps` de Tomcat.  
Al copiarlo en esta carpeta, Tomcat realiza el despliegue automático de la aplicación, creando la carpeta correspondiente sin necesidad de reiniciar el servidor.

### Captura – Despliegue automático del WAR en webapps

![Despliegue automático del WAR](07_despliegue_automatico_war_sample.png)

---

## 8. Acceso a la aplicación desplegada

Finalmente accedo desde el navegador a la aplicación desplegada en la dirección:

`http://localhost:8080/sample`

Compruebo que la aplicación de ejemplo “Hello World” funciona correctamente.

### Captura – Aplicación “Hello World” funcionando

![Aplicación sample funcionando](08_aplicacion_sample_funcionando.png)
