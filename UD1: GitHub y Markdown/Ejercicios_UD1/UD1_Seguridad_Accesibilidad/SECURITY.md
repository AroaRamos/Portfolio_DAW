## Seguridad y Accesibilidad en el Repositorio

### 1. Protección de datos sensibles
He creado un archivo **.gitignore** para evitar que se suban al repositorio archivos que no deberían compartirse.  
En mi caso, al trabajar con **NetBeans y Java**, hay carpetas y ficheros que se generan automáticamente (como `dist/`, `nbproject/private/` o los `.class`).  
Estos archivos no contienen código fuente útil y, además, pueden guardar configuraciones personales o rutas de mi ordenador.  

Gracias al `.gitignore`, el proyecto se mantiene más limpio, ordenado y libre de archivos innecesarios.

---

### 2. Accesibilidad y gestión de permisos
En GitHub existen diferentes niveles de permisos que se pueden asignar a los colaboradores de un proyecto.  
Cada nivel tiene funciones específicas según el tipo de usuario y el grado de responsabilidad dentro del equipo.

| Rol | Permisos principales | Uso recomendado |
|-----|----------------------|-----------------|
| **Read** | Solo lectura del código | Para revisores o supervisores |
| **Write** | Puede subir cambios y crear ramas | Para compañeros que desarrollan código |
| **Admin** | Control total (configura, borra, invita) | Solo para el propietario del proyecto |

---

### 3. Buenas prácticas de seguridad
Para proteger el trabajo y la documentación he seguido algunas medidas básicas.  
He comprobado las **opciones de revisión de código** en GitHub, que sirven para limitar quién puede revisar o aprobar cambios.  
También es recomendable usar **ramas protegidas** para que los cambios importantes pasen primero por una revisión antes de llegar a la rama principal.

Además, siempre intento hacer **commits con mensajes claros** para saber qué se ha modificado en cada momento.  
Así se mantiene un control de versiones que facilita localizar errores o volver atrás si algo falla.

Otra medida importante es **no subir datos personales, contraseñas ni configuraciones privadas**, ya que eso podría comprometer la seguridad del proyecto.  
El mismo `.gitignore` ayuda a evitar este tipo de errores.

---

### 4. Recuperación y copias de seguridad
GitHub guarda automáticamente un **historial completo de cambios**, lo que permite recuperar el proyecto en caso de pérdida de datos o errores graves.  
En cualquier momento se puede volver a una versión anterior o **clonar el repositorio** para tener una copia de seguridad en otro equipo.  
De esta manera, el trabajo no se pierde aunque haya un fallo o se borre algo por accidente.

---
