# knote-app

Este proyecto es un microservicio desarrollado en Spring Boot que ofrece una aplicación de notas. Proporciona una API para crear, leer, actualizar y eliminar notas, y también incluye archivos YAML para el despliegue en Kubernetes.

## Características principales

- Gestión de notas: Permite crear, leer, actualizar y eliminar notas.
- API RESTful: Proporciona una interfaz de programación de aplicaciones basada en REST para interactuar con las notas.
- Microservicio: Implementado utilizando el framework Spring Boot, facilitando la construcción y despliegue del servicio.
- Despliegue en Kubernetes: Incluye archivos YAML que describen la configuración de despliegue en un clúster de Kubernetes.

## Tecnologías utilizadas

- Java-17: Lenguaje de programación utilizado para implementar el microservicio.
- Gradle-7.2: Gestor de dependencias, plugins y tasks personalizados
- Spring Boot: Framework de desarrollo de aplicaciones Java que simplifica la configuración y el desarrollo de aplicaciones basadas en Spring.
- RESTful API: Se utiliza para proporcionar una interfaz de programación de aplicaciones basada en HTTP que sigue los principios de REST.
- Kubernetes: Plataforma de orquestación de contenedores utilizada para el despliegue y administración de la aplicación en un entorno escalable.

## Estructura del proyecto

El proyecto sigue una estructura de directorios típica de una aplicación Spring Boot:

- `ops`
    - `deployment.yaml`
    - `service.yaml`
    - `ingress.yaml`
- `src`
    - `main`
        - `java`
            - `com.jorge.application`
                - `controller`
                - `entity`
                - `dto`
                - `mappers`
                - `repository`
                - `service`
        - `resources`
            - `application.properties`
    - `test`
        - `java`
            - `com.jorge.applicationTest`
- `build.gradle`
- `Dockerfile`
- `Jenkinsfile`
- `README.md`


## Configuración y despliegue

Para desplegar el microservicio en un clúster de Kubernetes, sigue los pasos a continuación:


1. Utilizar el Jenkinsfile para compilar y crear la imagen y subirla al registry de su preferencia
2. Asegúrate de tener un clúster de Kubernetes configurado y accesible desde tu entorno de desarrollo.
3. Ajusta los archivos YAML de Kubernetes (`deployment.yaml`, `service.yaml`, `ingress.yaml`) según tus necesidades, como el nombre del servicio, los puertos, etc.
4. Utiliza los comandos de Kubernetes (por ejemplo, `kubectl apply -f deployment.yaml`) para aplicar los archivos YAML y desplegar la aplicación en el clúster.
5. Verifica que la aplicación se haya desplegado correctamente y está en funcionamiento utilizando comandos como `kubectl get pods`, `kubectl get services`, etc.
