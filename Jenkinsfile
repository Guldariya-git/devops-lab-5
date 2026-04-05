pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'GitHub-тан код алу'
                checkout scm
            }
        }

        stage('Build (Maven in Docker)') {
            steps {
                echo 'Maven контейнер арқылы билд'
                sh '''
                docker run --rm \
                -v $PWD/app:/app \
                -w /app \
                maven:3.9.6-eclipse-temurin-17 \
                mvn clean package -DskipTests
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Docker image жинау'
                sh 'docker build -t my-app .'
            }
        }

        stage('Run App') {
            steps {
                echo 'Контейнер іске қосу'
                sh 'docker run -d -p 8081:8080 my-app'
            }
        }
    }
}
