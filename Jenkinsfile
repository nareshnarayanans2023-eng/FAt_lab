pipeline {
    agent any

    environment {
        // 1. Replace with your actual Docker Hub username
        DOCKER_HUB_USER = 'naresh876'
        DOCKER_REPO = 'inheritance-app'
        // 2. This must match the ID you created in Jenkins Credentials
        DOCKER_CRED_ID = 'docker-hub-credentials' 
    }

    stages {
        stage('Checkout GitHub') {
            steps {
                // Pulls the latest code from your GitHub repo
                checkout scm
            }
        }

        stage('JUnit Testing') {
            steps {
                // Runs Maven tests on Windows
                bat 'mvn test'
            }
        }

        stage('Maven Build') {
            steps {
                // Packages the app into a JAR file
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Create Docker Image') {
            steps {
                // Builds the image using your Dockerfile
                bat "docker build -t %DOCKER_HUB_USER%/%DOCKER_REPO%:latest ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                // Logs into Docker Hub and pushes the image
                withCredentials([usernamePassword(credentialsId: "${DOCKER_CRED_ID}", 
                                 passwordVariable: 'DOCKER_PASS', 
                                 usernameVariable: 'DOCKER_USER')]) {
                    bat "echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin"
                    bat "docker push %DOCKER_HUB_USER%/%DOCKER_REPO%:latest"
                }
            }
        }
    }
    
    post {
        always {
            // Cleans up the workspace after the build
            cleanWs()
        }
    }
}
