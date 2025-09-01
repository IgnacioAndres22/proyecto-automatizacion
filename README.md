proyecto de automatización de pruebas EVA 2 
Fuente: Material de estudio y respuestas unidad 1 y 2.

Objetivos. 

Implementar integración continua para un proyecto de Java con Maven y pruebas automatizadas. 
Configurar Pipeline en github actions para compilación y ejecución automatica de test. 
Garantizar trazabilidad y control de versiones en git. 

Comandos utilizados: 
git init (iniciar)
git add . (añadir)
git commit -m (Comentarios)
git branch -M main (Subir a raiz principal)
git remote add origin <url-repositorio> (Subir al repositorio)
git push -u origin main (Subir en origen)
mvn clean compile (Compila repositorio)
mvn test ( pruebas unitarias)
mvn surefire-report:report ( genera reportes)

Archivos clave y breve explicación

pom.xml: Define dependencias Maven y configuración del proyecto
src/main/java: Código fuente principal (Calculadora.java)
src/test/java: Tests unitarios (SumaTest.java, RestaTest.java)
.github/workflows/ci.yml: Configuración del pipeline de CI
README.md: Documentación del proyecto en este caso objetivos, comandos utilizados, archivos clave, etc. 
.gitignore: Archivos excluidos del control de versiones

Descripción del pipeline de CI 

El pipeline de github actions ejecuta las siguentes etapas automaticamente: SETUP en donde esta configura java y cache de Maven, Build ejecuta mvn clean compile para compilar el repositorio, mvn test para correr las pruebas, report para generar los reportes. 
La activación del mismo se activa cada vez que hay un push o pull de la rama main. 
Resultado esperado: Logs y reportes visibles en pestaña "Actions" 

Como esto beneficia, crea ramas feature para nuevas funcionalidades, escribir commits con mensajes descriptivos. Creación de pull para revisiones y se asegura que pase todos los test. 