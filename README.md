# GAEM

- Gestión Actas Electrónicas Móviles
- Municipalidad de Santa Fé 
- 2014-02-23

## Descripción

GAEM es un sistema desarrollado en junto a la Municipalidad de Rosario el cual que
permite el labrado de actas desde dispositivos móviles.

Esta divido en dos sub proyectos, gaem-client que corre en dispositivos Android >= 2.3
el cual envía peticiones vía HTTPS -mediante API-REST- a gaem-server. Este último
recibe dichas peticiones y sirve como proxy/interface con los sistemas existentes.

## Instalación GAEM-Server

### Instalar Java SDK 7

    $ javac -version
    javac 1.7.0_21

### Instalar Apache Ant 
   
    # install
    $ Ant=apache-ant-1.9.0
    $ cd /tmp ; curl -O http://archive.apache.org/dist/ant/binaries/${Ant}-bin.tar.gz
    $ mkdir -p ~/opt ; tar zxf /tmp/${Ant}-bin.tar.gz ~/opt
    $ sudo ln -s ~/opt/$Ant/bin/ant /usr/bin/ant
   
    # test
    $ ant -version
    Apache Ant(TM) version 1.9.0 compiled on March 5 2013

### Instalar Gaem

    $ git clone https://gitlab.tecso.coop/tecso/gaem-server-msf.git
    $ cd gaem-server-msf    
    $ ant mkenv tomcat
    $ ./gait tomcat start

### Probar

* Browse <http://localhost:8080/gait>
* user: admin / Password: admin
    
### Eclipse

- File -> Import... (Seleccionar path de gaem-server-X)
- Nota 1: Verificar que la versión de GIT instalada (en la versión más reciente de Eclipse ya viene el plugin instalado)
- Nota 2: Configurar Preferences -> ... -> Execution Environment" -> Java SE 1.7 

### Instalación Base de Datos

- Instalar PostgreSQL
- Crear base de datos con Log y charset US-ASCII
- Importar etc/gait.exp.tar.gz 

## Instalación Gaem-Client

TODO

### Eclipse

TODO
  
## Links

- Server <https://gitlab.tecso.coop/tecso/gaem-server-msf/>
- Client <https://gitlab.tecso.coop/tecso/gaem-client-msf/>
- Documentación <https://svn.tecso.coop/svn/msf/gaem/documentacion/trunk>
- Issues <http://jira.tecso.coop/browse/MSFGAEM>
