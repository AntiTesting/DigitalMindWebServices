#!/bin/bash

# Ejecutar el comando mvn clean package -DskipTests
mvn clean package -DskipTests

# Verificar si el comando anterior se ejecutó correctamente (código de salida 0)
if [ $? -eq 0 ]; then
    echo "El comando Maven se ejecutó correctamente."
    
    # Si se ejecutó correctamente, ejecutar el comando docker build -t web-services .
    docker build -t web-services .
    
    # Verificar si el comando docker build se ejecutó correctamente (código de salida 0)
    if [ $? -eq 0 ]; then
        echo "El comando Docker se ejecutó correctamente."
        
        # Al terminar de ejecutar el comando docker build, ejecutar docker-compose up -d
        docker-compose up -d
    else
        echo "Error al ejecutar el comando Docker."
    fi
else
    echo "Error al ejecutar el comando Maven."
fi
