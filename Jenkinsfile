pipeline {
    agent any

    tools {
        // Jenkins tool names (check Manage Jenkins → Global Tool Configuration)
        maven 'Maven3.9.11'
        jdk 'JDK17'
    }

    environment {
        PROJECT_DIR = 'C:\\Users\\pjhan\\ShirishaPrograms\\IdeaProjects\\SmartHomeDashboardProject'  // local path to your IntelliJ project
        JAR_FILE = 'SmartHomeDashboardProject-1.0-SNAPSHOT.jar'
        MAIN_CLASS = 'org.example.smartHome.Main'
        SERVER_CLASS = 'org.example.smartHome.network.DeviceServer'
    }

    stages {
        stage('Checkout from GitHub') {
            steps {
                echo "Pulling code from GitHub branch: Demo2dev..."
                checkout([$class: 'GitSCM',
                    branches: [[name: '*/IOTSmartHomeProject']],
                    userRemoteConfigs: [[
                        url: 'https://github.com/shirisha-p-tech/AmazonAtlasBatch2.git'
                    ]]
                ])
            }
        }

        stage('Build Project') {
            steps {
                echo "Building Maven project..."
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo "Running unit tests..."
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Check DynamoDB Connection') {
            steps {
                echo "💾 Checking DynamoDB Local availability..."
                bat 'curl http://localhost:8000 || echo "DynamoDB not reachable"'
            }
        }

        stage('Start DeviceServer') {
            steps {
                echo "Starting DeviceServer in background..."
                bat '''
                start "DeviceServer" cmd /c java -cp target\\%JAR_FILE% %SERVER_CLASS%
                ping 127.0.0.1 -n 5 > nul
                '''
            }
        }

     stage('Docker Build') {
                steps {
                    echo "Building Docker image for Smart Home app..."
                    bat 'docker build -t smart-home-app .'
                }
            }

            stage('Run Smart Home App') {
                steps {
                    echo "Running Smart Home Application..."
                    bat 'java -cp target\\SmartHomeDashboardProject-1.0-SNAPSHOT.jar org.example.smartHome.Main'
                }
            }

        }


    post {
        always {
            echo "Cleaning up background DeviceServer process..."
            bat 'taskkill /F /IM java.exe /FI "WINDOWTITLE eq DeviceServer" || exit 0'
        }
    }
}


