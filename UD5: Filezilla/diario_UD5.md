# Diario de aprendizaje: UD5 – Servidor FTP

## Qué he aprendido

En esta unidad he aprendido a trabajar con **servidores FTP** desde cero. Antes sabía que FTP se usaba para transferir archivos, pero nunca había configurado ni administrado un servidor.

A lo largo de la unidad he aprendido cosas como:

- Instalar y configurar **vsftpd** en Ubuntu.
- Entender la estructura de directorios y permisos en Linux para FTP.
- Crear usuarios FTP y configurar sus permisos de acceso.
- Usar **chroot** para enjaular usuarios y que solo vean su carpeta.
- Configurar el **modo pasivo** para que funcione con firewalls.
- Generar certificados SSL y configurar **FTPS** para cifrar las conexiones.
- Obligar el uso de cifrado para que las contraseñas no viajen en texto plano.
- Trabajar con diferentes **clientes FTP**: línea de comandos (ftp, lftp, curl) y gráficos (FileZilla).
- Integrar el servidor FTP con **Apache** para publicar contenido web.
- Configurar **firewall (ufw)** para abrir solo los puertos necesarios.
- Entender las diferencias entre modo activo y pasivo.
- Aplicar buenas prácticas de seguridad: logs, backups, límites de conexión.

---

## Qué no entiendo del todo

Aunque he aprendido bastante, todavía hay cosas que me cuestan un poco:

- Configurar correctamente el **NAT y port forwarding** cuando el servidor está detrás de un router.
- Entender del todo cómo funciona `pasv_address` cuando hay IP pública.
- Interpretar algunos errores de permisos cuando algo no funciona a la primera.
- Saber exactamente qué límites de conexión poner según el tipo de servidor.
- Entender todos los parámetros avanzados de vsftpd.

---

## Qué es lo que más me ha gustado y qué es lo que menos

Lo que más me ha gustado ha sido:

- Ver cómo funciona **FTPS** y comprobar que las conexiones sin cifrado son rechazadas.
- Usar **FileZilla** con la interfaz gráfica de dos paneles.
- La integración con **Apache**: subir un archivo por FTP y verlo inmediatamente en el navegador.
- Configurar el **modo pasivo** y ver que funciona correctamente con el firewall.
- Crear la estructura de directorios con chroot y que todo funcione bien.
- Probar diferentes clientes (lftp, curl, FileZilla, Nautilus) y ver las diferencias.

Lo que menos me ha gustado es:

- Que los **permisos en Linux** son complicados y un pequeño error puede hacer que FTP no funcione.
- Que la configuración de **chroot** requiere una estructura específica de carpetas.
- Que cuesta encontrar el fallo cuando algo no sale bien (sobre todo con permisos).
- Tener que ajustar el firewall cada vez que cambio la configuración del modo pasivo.

---

## Qué más me gustaría saber relacionado con la Unidad

Me gustaría aprender más sobre:

- Usar **SFTP** (SSH File Transfer Protocol) en lugar de FTPS y ver las diferencias.
- Configurar FTP en un entorno de producción real con alta disponibilidad.
- Integrar FTP con sistemas de **autenticación externa** (LDAP, Active Directory).
- Montar servidores FTP con **usuarios virtuales** en lugar de usuarios del sistema.
- Automatizar despliegues web usando FTP desde scripts o sistemas CI/CD.
- Configurar **fail2ban** más a fondo para proteger el servidor.
- Usar herramientas de monitorización para ver el estado del servidor FTP en tiempo real.
- Aprender a usar **rsync** como alternativa más moderna a FTP.
