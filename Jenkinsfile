pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'GitHub-тан код алу'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Java қолданбаны жинау'
                sh '''
                cd app
                mvn clean package -DskipTests
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Docker image құрастыру'
                sh 'docker build -t devops-app .'
            }
        }

        stage('Run App') {
            steps {
                echo 'Контейнерді іске қосу'
                sh 'docker-compose up -d'
            }
        }

        stage('Test') {
            steps {
                echo 'Қолданбаны тексеру'
                sh 'curl http://localhost:5000 || true'
            }
        }

        stage('Cleanup') {
            steps {
                echo 'Тазалау'
                sh 'docker-compose down'
            }
        }
    }
}
