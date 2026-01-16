# Actividad 5: Pruebas en modo activo y pasivo
---

## Configuración realizada

He configurado el rango de puertos pasivos en el archivo `/etc/vsftpd.conf`:
```bash
pasv_enable=YES
pasv_min_port=40000
pasv_max_port=40100
```

Y reinicié el servicio:
```bash
sudo systemctl restart vsftpd
```

---

## Pruebas de conexión

### Modo pasivo

Me conecté al servidor FTP con `ftp localhost`. Al hacer `ls`, el servidor usó el puerto 40096 del rango configurado y funcionó bien.

### Modo activo

Dentro del FTP ejecuté `passive` para desactivar el modo pasivo y luego `ls`. En localhost funcionó, pero en un escenario real con firewall habría dado error.

### Con firewall activado

Instalé y configuré ufw:
```bash
sudo ufw enable
sudo ufw allow 21/tcp
sudo ufw allow 40000:40100/tcp
```

El modo pasivo siguió funcionando porque los puertos están permitidos. El modo activo fallaría en un cliente remoto porque el firewall del cliente bloquearía la conexión entrante del servidor.

---

## ¿Cuál funciona mejor con firewall?

El **modo pasivo** funciona mucho mejor porque el cliente inicia ambas conexiones (control y datos), y los firewalls permiten conexiones salientes por defecto. No hace falta configurar nada en el firewall del cliente.

El **modo activo** tiene problemas porque el servidor intenta conectarse al cliente, y los firewalls bloquean conexiones entrantes. El cliente tendría que abrir puertos y configurar su firewall, lo cual es complicado y muchas veces imposible con NAT.

---

## Tabla comparativa: Modo Activo vs Modo Pasivo

| Característica | Modo Activo | Modo Pasivo |
|----------------|-------------|-------------|
| **¿Quién se conecta para enviar datos?** | El servidor se conecta al cliente | El cliente se conecta al servidor |
| **Puerto que usa el servidor** | Puerto 20 (siempre el mismo) | Puertos entre 40000 y 40100 |
| **¿Funciona con firewall en el cliente?** | ❌ No, se bloquea | ✅ Sí, funciona bien |
| **¿Funciona con router/NAT?** | ❌ No funciona | ✅ Sí funciona |
| **¿El cliente necesita abrir puertos?** | ✅ Sí, tiene que configurar | ❌ No necesita nada |
| **¿El servidor necesita abrir puertos?** | ❌ Solo el puerto 20 | ✅ Sí, el rango completo |
| **¿Se usa actualmente?** | ❌ Casi nunca (obsoleto) | ✅ Sí (es el estándar) |
| **¿Cuándo funciona bien?** | Solo en redes locales sin firewall | En cualquier red moderna |
| **Tipo de conexiones** | 1 saliente + 1 entrante | 2 salientes |
| **Problema principal** | El firewall del cliente bloquea la entrada | Necesita abrir muchos puertos en el servidor |
