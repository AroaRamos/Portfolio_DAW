# Cuestionario presentación

### 1. ¿Qué significan las siglas HTTP y para qué se utiliza?
HTTP significa **HyperText Transfer Protocol** y se usa para que los navegadores y los servidores web puedan comunicarse y enviar información, como las páginas y recursos que vemos en internet.

### 2. ¿En qué puerto funciona normalmente el protocolo HTTP?
Normalmente funciona en el **puerto 80**.

### 3. ¿Cuál es la diferencia principal entre HTTP y HTTPS?
HTTPS es la versión segura de HTTP. La diferencia es que **HTTPS cifra la información que se envía**, así nadie puede leerla si la intercepta. HTTP no cifra nada, por eso HTTPS protege mejor los datos.

### 4. ¿Qué función cumple el servidor web Apache dentro de una arquitectura web?
Apache es el programa que recibe las peticiones de los navegadores y se encarga de **entregar las páginas y archivos** para que el usuario pueda ver la web.

### 5. ¿Cómo puedes comprobar si el servicio de Apache está activo en un sistema Ubuntu?
Con el comando:
```
sudo systemctl status apache2
```

### 6. Explica brevemente en qué consiste una arquitectura cliente-servidor.
Es un sistema donde un **cliente** (por ejemplo, un navegador) pide información, y un **servidor** la procesa y la devuelve. Cada uno tiene su función y trabajan juntos.

### 7. ¿Qué diferencia hay entre una arquitectura de dos capas y una de tres capas en entornos web?
- **Dos capas:** el cliente se comunica directamente con el servidor que maneja los datos.  
- **Tres capas:** existe una capa intermedia que se encarga de la lógica y del procesamiento. Esto hace que la aplicación sea más organizada, escalable y fácil de mantener.

### 8. ¿Qué es el protocolo FTP y para qué se usa?
FTP es un protocolo que sirve para **subir y descargar archivos** entre ordenadores a través de internet.

### 9. Menciona un ejemplo de cliente FTP y un ejemplo de servidor FTP.
- Cliente FTP: **FileZilla**
- Servidor FTP: **vsftpd**

### 10. ¿Qué diferencia existe entre FTP y SFTP?
SFTP es más seguro porque **cifra los datos durante la transferencia**, mientras que FTP envía todo sin cifrar.

### 11. Indica tres tipos de alojamiento web y explica brevemente en qué se diferencian.
- **Compartido:** varios usuarios comparten el mismo servidor. Es barato, pero tiene menos rendimiento.
- **VPS:** es un servidor virtual privado con más recursos y control. Da más libertad que el compartido.
- **Dedicado:** es un servidor completo para un solo usuario, con el máximo rendimiento, aunque es el más caro.

### 12. ¿Qué ventajas ofrece un servidor VPS frente a un alojamiento compartido?
Un VPS tiene **más recursos dedicados, más estabilidad y más opciones de configuración**, por lo que el rendimiento es mejor y no depende tanto de otros usuarios.

### 13. Describe brevemente los componentes principales de una arquitectura web moderna.
Normalmente se compone de:  
- Un **cliente** que hace la petición (el navegador).  
- Un **servidor web** que recibe la petición.  
- Un **servidor de aplicaciones** que procesa la lógica.  
- Una **base de datos** donde se guarda la información.  

### 14. ¿Qué papel cumple el servidor de aplicaciones dentro de dicha arquitectura?
Se ocupa de la **lógica del negocio**, es decir, de procesar las acciones que deben hacerse entre el cliente y la base de datos, como validaciones, cálculos o reglas de la aplicación.

### 15. ¿Qué software o paquete puedes usar para instalar Apache fácilmente en Windows?
Se puede usar **XAMPP**, que ya trae Apache y otros servicios listos para usar.

### 16. ¿Qué carpeta suele contener los archivos del sitio web en una instalación de Apache en Windows (por ejemplo, con XAMPP)?
Normalmente se encuentran en:
`C:\xampp\htdocs`

### 17. Escribe el comando para instalar Apache en Ubuntu desde la terminal.
```
sudo apt install apache2
```

### 18. ¿Qué comando se usa para iniciar el servicio Apache en Ubuntu?
```
sudo systemctl start apache2
```

### 19. ¿En qué ruta se almacena normalmente la página web por defecto de Apache en Ubuntu?
`/var/www/html`

### 20. ¿Qué es el protocolo SSH y cuál es su propósito principal?
SSH es un protocolo que permite **conectarse a otro ordenador de forma segura** usando cifrado.

### 21. ¿Qué comando se usa para conectarse a un servidor remoto mediante SSH?
```
ssh usuario@direccion_ip
```
### 22. Menciona una ventaja de usar autenticación mediante claves SSH frente a contraseñas.
Es más segura porque una clave SSH es muy difícil de adivinar, y además evita ataques donde intentan probar contraseñas una por una.
