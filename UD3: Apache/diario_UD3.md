# **Diario de aprendizaje: UD3 – Apache**

## **Qué he aprendido**

En esta unidad he aprendido a trabajar con Apache. Hasta ahora sabía lo que era un servidor web, pero no había configurado uno desde cero. En esta unidad he podido instalarlo en Ubuntu, entender mejor cómo funciona y crear mi propio sitio web.

He aprendido cosas como:

- Instalar Apache desde la terminal.
- Ver qué es el **DocumentRoot** y qué carpeta usa Apache para mostrar una web.
- Configurar un **VirtualHost** para tener un sitio propio en `/var/www/gci`.
- Crear una **página web personalizada** y comprobar que funciona entrando desde `http://localhost`.
- Activar `AllowOverride` para que Apache permita usar `.htaccess`.
- Crear una **página de error 404 personalizada** para practicar configuraciones extra.

---

## **Qué no entiendo**

Aunque voy entendiendo Apache, todavía me cuesta un poco tener claro:

- Cómo funciona exactamente cuando hay varios VirtualHost al mismo tiempo.
- Cuál es la diferencia real entre usar `.htaccess` o modificar directamente los archivos `.conf`.
- En qué momentos hay que reiniciar Apache y cuándo basta solo con recargar la configuración.

---

## **Qué es lo que más me ha gustado y qué es lo que menos**

Lo que más me ha gustado ha sido crear una página web propia dentro del servidor y ver que funcionaba perfectamente. También me gustó personalizar el error 404.

Otra cosa positiva es que he perdido un poco el miedo a tocar configuraciones del sistema. Al principio pensaba que iba a romper algo, pero ahora entiendo mejor lo que estoy haciendo.

Lo que menos me ha gustado es que cualquier pequeño detalle mal puesto (como una carpeta equivocada o una ruta mal escrita) hace que el servidor no funcione, y a veces me ha costado encontrar el fallo.

---

## **Qué más me gustaría saber relacionado con la Unidad**

Me gustaría aprender:

- Cómo manejar varios VirtualHost y cómo saber cuál está funcionando primero.
- Cómo poner un sitio con HTTPS y certificados.
- Cómo desplegar aplicaciones más completas usando Apache junto con otros servicios.
