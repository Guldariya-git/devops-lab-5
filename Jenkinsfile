stage('Build (Maven in Docker)') {
    steps {
        echo 'Maven контейнер арқылы билд'
        // ${WORKSPACE} айнымалысын қолдану арқылы бүкіл проектіні контейнерге байлаймыз
        sh 'docker run --rm -v ${WORKSPACE}:/app -w /app maven:3.9.6-eclipse-temurin-17 mvn clean package -DskipTests'
    }
}
