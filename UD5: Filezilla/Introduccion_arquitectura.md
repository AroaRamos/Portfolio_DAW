# Actividad 1: Esquema de conexión FTP
---

## Esquema del flujo de conexión FTP

### Canal de Control (Puerto 21)

Es la conexión principal que se mantiene abierta durante toda la sesión. Por aquí van los comandos y las respuestas del servidor.
```
Cliente                                  Servidor
  |                                         |
  | -------- USER aroa ------------------>  | Puerto 21
  |                                         |
  | <------- Necesito contraseña ---------  |
  |                                         |
  | -------- PASS ***** ----------------->  |
  |                                         |
  | <------- Login correcto --------------  |
  |                                         |
  | -------- LIST (dame archivos) ------->  |
  |                                         |
  | <------- Abriendo conexión de datos --  |
  |                                         |
```

### Canal de Datos

Es una conexión aparte que se abre solo cuando se necesita transferir archivos. Una vez termina la transferencia, se cierra.
```
Cliente                                  Servidor
  |                                         |
  | ======== NUEVA CONEXIÓN =============>  | Puerto variable
  |                                         |
  | <====== Archivos/datos ===============  |
  |                                         |
  | <------- Transferencia completa ------  | (vuelve al puerto 21)
  |                                         |
```

---

## Modo Activo vs Modo Pasivo

### Modo Activo (casi obsoleto)

El **servidor** inicia la conexión de datos hacia el cliente:
```
Cliente (192.168.1.10)              Servidor (192.168.1.100)
  |                                         |
  | -------- PORT 192,168,1,10 --------->  | Puerto 21 (control)
  |         "Conéctate a mi IP"            |
  |                                         |
  | <====== Servidor se conecta =========  | Puerto 20 → Cliente
  |         (el servidor va al cliente)    | (datos)
  |                                         |
```

**Problema:** Los firewalls del cliente bloquean esto porque es una conexión entrante.

### Modo Pasivo (el que se usa ahora)

El **cliente** inicia ambas conexiones:
```
Cliente (192.168.1.10)              Servidor (192.168.1.100)
  |                                         |
  | -------- PASV ----------------------->  | Puerto 21 (control)
  |                                         |
  | <------- Conéctate al puerto 50040 --  |
  |                                         |
  | ====== Cliente se conecta ==========>  | Puerto 50040 (datos)
  |        (el cliente va al servidor)     |
  |                                         |
```

**Ventaja:** Funciona con firewalls y routers porque el cliente solo hace conexiones salientes.

---

## Diferencias principales

| Aspecto | Modo Activo | Modo Pasivo |
|---------|-------------|-------------|
| ¿Quién inicia conexión de datos? | Servidor → Cliente | Cliente → Servidor |
| Comando usado | PORT | PASV |
| Puerto de datos (servidor) | 20 (fijo) | Rango alto (ej: 50000-60000) |
| ¿Funciona con firewalls? | No | Sí |
| ¿Se usa actualmente? | Casi nunca | Estándar |
