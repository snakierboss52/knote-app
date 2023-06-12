pipeline {
    agent any

    environment {
        REPOSITORY_NAME = 'knote-app'
    }

    stages {
        stage('Clone repo'){
            steps{
                git 'https://github.com/snakierboss52/knote-app.git'
            }
        }
        stage('Build BootJar') {
            steps {
                sh './gradlew bootJar'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build . -t knote-app --no-cache --platform linux/amd64/v2'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    sh 'docker push knote-app'
                }
            }
        }
    }
}