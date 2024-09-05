# Manejo de Versiones y Uso de Ramas en el Proyecto

En este proyecto, utilizamos Git para gestionar el control de versiones y facilitar la colaboración entre los desarrolladores. A continuación, se describe cómo se organizó el flujo de trabajo y las ramas en el proyecto, utilizando varias herramientas de visualización proporcionadas por Git.

## Estrategia de Ramas

Para mantener un desarrollo ordenado, implementamos un esquema básico de ramas:

- **`main`**: Es la rama principal donde reside el código más estable y listo para producción.
- **`develop`**: En esta rama se integran las nuevas funcionalidades antes de fusionarse con `main`.
- **Ramas de funcionalidad** (`feature/<nombre-de-la-funcionalidad>`): Cada nueva característica se desarrolla en una rama independiente basada en `develop`. Una vez que la funcionalidad está lista y probada, se fusiona de vuelta a `develop`.

### Visualización del Flujo de Ramas

Utilizamos los siguientes comandos y herramientas para visualizar el flujo de trabajo y los cambios entre las ramas:

- **`git log --oneline --graph --all`**: Este comando muestra de manera gráfica el historial de commits y cómo las ramas se fusionan.
- **`git status`**: Nos permite ver el estado actual de la rama en la que estamos trabajando, indicando si hay archivos modificados o nuevos que necesitan ser confirmados.

### Conclusión

El uso de Git y las ramas nos permitió que varios desarrolladores trabajaran en paralelo, sin interferir entre ellos. Las visualizaciones y herramientas de Git ayudaron a entender el flujo del código y aseguraron que las fusiones se realizaran de forma eficiente y sin conflictos.

Para poder acceder al repositorio donde se encuentra el proyecto, se adjunta el link del repositorio en evidencia de la dinámica trabajada:

