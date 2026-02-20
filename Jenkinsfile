pipeline {
    agent any
    environment {
        IMAGE_NAME='testing1'
    }
    parameters{
        choice(name: 'Condition', choices: ['Testing','Dev'], description: 'Choose Environment')
    }
    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning repository...'
                git branch: 'main', url: 'https://github.com/J-Gokul23/Testing1.git'
            }
        }
        stage ('Testing'){
            when{
                expression{
                    params.Condition == 'Testing'
                }
            }
            steps {
                bat 'mvn test'
            }
        }
        stage('Build with Maven') {
            steps {
                echo 'Building the project with Maven...'
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                bat 'docker build -t %IMAGE_NAME%:latest .'
            }
        }
        stage('Stop Old Container (if any)') {
            steps {
                echo 'Stopping old container if it exists...'
                bat '''
                docker stop testingcon || exit 0
                docker rm testingcon || exit 0
                '''
            }
        }
        stage('Run Docker Container') {
            steps {
                echo 'Running new container...'
                bat 'docker run -d -p 8081:8081 --name testingcon %IMAGE_NAME%:latest'
            }
        }
    }
    post {
        success {
            echo '✅ Build and deployment completed successfully!'
        }
        failure {
            echo '❌ Build failed. Check logs for errors.'
        }
    }
}

