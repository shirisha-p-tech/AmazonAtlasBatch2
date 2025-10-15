pipeline {
    agent any

    tools {
        maven 'Maven3.9.11'
        jdk 'JDK17'
    }

    environment {
        DOCKER_IMAGE = 'smart-home-dashboard-image:latest'
    }

    stages {
        stage('Checkout') {
            steps {
                // Replace with your actual GitHub URL and branch
                git branch: 'IOTSmartHomeProject', url: 'https://github.com/shirisha-p-tech/AmazonAtlasBatch2.git'
            }
        }

        stage('Build with Maven') {
            steps {
                echo 'Packaging fat JAR with dependencies(shaded jar)...'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Run Unit Tests') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %DOCKER_IMAGE% .'
            }
        }

        stage('Deploy to Docker Desktop') {
            steps {

                echo 'Cleaning up old containers...'
                bat 'docker rm -f device-server smart-home-dashboard || exit 0'
                // Stop old containers (ignore if none)
                bat 'docker-compose down || exit 0'
                // Rebuild & start new ones
                bat 'docker-compose up -d --build'
                // Show running containers
                bat 'docker ps'
            }
        }
    }

    post {
        success {
            echo 'Build, Test, and Docker Deployment Successful!'
        }
        failure {
            echo 'Build or Test Failed — Check Console Output.'
        }
    }
}
