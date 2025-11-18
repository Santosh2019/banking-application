pipeline {
    agent any

    stages {
        stage('Build Jar') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t banking-app .'
            }
        }
        stage('Run Docker Container') {
            steps {
                bat 'docker run -d -p 8080:8080 banking-app'
            }
        }
    }
}
