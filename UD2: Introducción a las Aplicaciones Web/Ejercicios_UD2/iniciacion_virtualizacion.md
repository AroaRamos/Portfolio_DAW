# Informe Técnico: Instalación de Ubuntu y Docker en VirtualBox

---

## 1. Descripción del proceso de instalación de Ubuntu en VirtualBox

Para realizar esta práctica, he instalado **Ubuntu 24.04 LTS** dentro de una máquina virtual en **VirtualBox**. El objetivo es tener un entorno Linux donde después pueda trabajar con Docker y montar servicios web.

### Pasos que he seguido

1. Primero he descargado la imagen **ISO oficial de Ubuntu 24.04 LTS** desde la página de Ubuntu.
2. Después he creado una nueva máquina virtual en VirtualBox con esta configuración:
   - **Nombre:** `Ubuntu-DAW2DAW`
   - **Memoria RAM:** `4096 MB`
   - **Disco duro virtual:** `50 GB`
   - **Tipo de red:** `NAT`
3. He arrancado la máquina virtual usando la ISO y he seguido el asistente de instalación normal de Ubuntu (idioma, usuario, contraseña, etc.).
4. Una vez terminada la instalación y reiniciado el sistema, he instalado las **Guest Additions**.

---

## 2. Pasos seguidos para instalar Docker en Ubuntu

En esta parte he instalado y configurado Docker dentro de Ubuntu. Docker me va a permitir ejecutar contenedores con servicios (por ejemplo, un servidor web).

### Paso 1: Actualizar paquetes del sistema

He actualizado el sistema antes de instalar nada:

```
sudo apt update && sudo apt upgrade -y
````

### Paso 2: Instalar la terminal GNOME

He instalado `gnome-terminal` para habilitar el acceso a la terminal desde Docker Desktop:

```
sudo apt install gnome-terminal
```

**Captura 1. Instalación de GNOME Terminal y confirmación en consola**
![Instalación de GNOME Terminal]([capturas_docker_desktop/1.png](https://github.com/AroaRamos/Portfolio_DAW/blob/main/UD2%3A%20Introducci%C3%B3n%20a%20las%20Aplicaciones%20Web/Ejercicios_UD2/Capturas_Docker_Desktop/1.png))

### Paso 3: Preparar el sistema para Docker

He instalado las dependencias necesarias, he creado la carpeta de claves y he añadido la clave GPG oficial de Docker:

```
sudo apt-get update
sudo apt-get install ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc
```

### Paso 4: Añadir el repositorio oficial de Docker

Después he añadido el repositorio oficial de Docker a mi sistema para poder instalar la última versión:

```
echo \
"deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] \
https://download.docker.com/linux/ubuntu \
$(. /etc/os-release && echo "$UBUNTU_CODENAME") stable" | \
sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
```

Y luego he vuelto a actualizar los repositorios:

```
sudo apt-get update
```

**Captura 2. Añadiendo la clave y el repositorio oficial de Docker y actualizando repositorios**
![Repositorio Docker](2.png)

### Paso 5: Instalar Docker

He instalado Docker y los componentes principales (el motor de Docker, el cliente, containerd y los plugins):

```
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

**Captura 3. Instalación de Docker CE y los plugins**
![Instalación Docker](3.png)

### Paso 6: Comprobar el servicio Docker

He comprobado si Docker estaba activo con este comando:

```
sudo systemctl status docker
```

**Captura 4. Docker en estado "active (running)"**
![Estado Docker](4.png)

Si Docker no se hubiese iniciado, lo puedo arrancar manualmente así:

```
sudo systemctl start docker
```

**Captura 5. Inicio manual del servicio Docker**
![Inicio manual Docker](5.png)

### Paso 7: Probar Docker

Para asegurarme de que Docker funciona bien, he hecho dos cosas:

1. Ver la versión instalada:

   ```
   docker --version
   ```

2. Ejecutar el contenedor de prueba oficial `hello-world`:

   ```
   sudo docker run hello-world
   ```

Cuando `hello-world` se ejecuta bien, Docker muestra un mensaje de bienvenida explicando que todo está funcionando.

**Captura 6. Resultado de `docker --version` y `docker run hello-world`**
![Hello world Docker](6.png)

---

## 3. Comandos usados para crear y ejecutar los contenedores

Después de tener Docker instalado y funcionando, he creado dos contenedores:

* Uno con **Nginx** (servidor web).
* Otro con **Tomcat** (servidor de aplicaciones Java).

### Paso 1: Buscar imágenes en Docker Hub

He buscado las imágenes oficiales que iba a usar:

```
sudo docker search nginx
sudo docker search tomcat
```

**Captura 7. Búsqueda de la imagen de Nginx (`docker search nginx`)**
![Buscar Nginx](7.png)

**Captura 8. Búsqueda de la imagen de Tomcat (`docker search tomcat`)**
![Buscar Tomcat](8.png)

### Paso 2: Descargar e iniciar los contenedores

He creado y lanzado los dos contenedores con estos comandos:

```
sudo docker run -d -p 8080:80 --name webserver nginx
sudo docker run -d -p 8081:8080 --name appserver tomcat
```

**Captura 9. Descarga de las imágenes y arranque de los contenedores Nginx y Tomcat**
![Run contenedores](9.png)

### Paso 3: Verificar que los contenedores están activos

He usado este comando para ver qué contenedores estaban en marcha:

```
sudo docker ps
```

**Captura 10. Listado de contenedores activos (`docker ps`)**
![docker ps](10.png)

En `docker ps` puedo ver:

* El contenedor `webserver` basado en Nginx → publicado en el puerto 8080.
* El contenedor `appserver` basado en Tomcat → publicado en el puerto 8081.

### Paso 4: Probar los servicios desde el navegador

Por último he comprobado que realmente responden desde el propio navegador del sistema:

* He ido a `http://localhost:8080` y me ha salido la página de bienvenida de **Nginx**.
* He ido a `http://localhost:8081` y me ha salido la pantalla por defecto de **Tomcat**.

**Captura 11. Página de Nginx cargando en `localhost:8080`**
![Nginx navegador](11.png)

**Captura 12. Página de Tomcat cargando en `localhost:8081`**
![Tomcat navegador](12.png)

Con esto demuestro que los dos servidores (web y aplicaciones) se están ejecutando dentro de contenedores Docker en mi Ubuntu virtualizado.

---

## 4. Requerimientos mínimos para implantar una aplicación web

### 4.1 Requisitos de hardware y software

* **Hardware mínimo necesario:**
  * Procesador **de 64 bits** con soporte para virtualización (Intel VT-x o AMD-V)
  * Al menos **2 GB de RAM** (recomendable 4 GB)
  * **25 GB de espacio libre en disco**
  * Conexión a Internet estable para descargar los paquetes

* **Software necesario:**
  * **Sistema operativo anfitrión:** Windows, macOS o Linux
  * **Virtualizador:** VirtualBox (o similar)
  * **Sistema operativo invitado:** Ubuntu 24.04 LTS
  * **Herramientas adicionales:** Docker Engine, Docker Compose y un navegador web

Estos son los requisitos mínimos para poder instalar Ubuntu en una máquina virtual, ejecutar Docker correctamente y desplegar una aplicación web sencilla dentro de contenedores.

---

### 4.2 Infraestructura de red

* He configurado la red de la máquina virtual en modo **NAT**, lo que permite que Ubuntu tenga acceso a Internet.  

---

### 4.3 Configuración del servidor web y del servidor de aplicaciones

* **Servidor web (Nginx):**
  * Contenedor creado con el nombre `webserver`
  * Imagen utilizada: `nginx:latest`
  * Puerto expuesto: `8080`
  * Acceso desde navegador: `http://localhost:8080`

* **Servidor de aplicaciones (Tomcat):**
  * Contenedor creado con el nombre `appserver`
  * Imagen utilizada: `tomcat:latest`
  * Puerto expuesto: `8081`
  * Acceso desde navegador: `http://localhost:8081`

---

### 4.4 Seguridad y mantenimiento

Para mantener los contenedores y el sistema seguros he tenido en cuenta lo siguiente:

* Ejecutar los comandos con `sudo` solo cuando es necesario.  
* Mantener el sistema y las imágenes actualizadas con `apt update` y `apt upgrade`.  
* Descargar siempre **imágenes oficiales** desde Docker Hub (por ejemplo, `nginx` y `tomcat` oficiales).  
* Comprobar el estado de los servicios con `sudo docker ps` y `sudo systemctl status docker`.  
---

## 5. Conclusión

En esta práctica he montado un entorno completo de pruebas:

1. He creado una máquina virtual con Ubuntu 24.04 LTS en VirtualBox.
2. He instalado Docker en esa máquina virtual.
3. He arrancado dos contenedores:

   * Un servidor web (**Nginx**) en el puerto 8080.
   * Un servidor de aplicaciones (**Tomcat**) en el puerto 8081.
4. He comprobado que ambos responden desde el navegador usando `localhost`.

Gracias a esto he podido ver cómo se puede desplegar una aplicación web usando contenedores Docker, sin tener que instalar todo directamente en mi sistema físico.

---

 **Autora:** Aroa Ramos
 **Módulo:** Despliegue de Aplicaciones Web (2º DAW)

---
