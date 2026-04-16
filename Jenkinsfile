pipeline {
    agent any

    environment {
        // Replace with your Docker Hub ID and repository name
        DOCKER_HUB_USER = 'naresh876'
        DOCKER_REPO = 'inheritance-app'
        DOCKER_CRED_ID = 'docker-hub-credentials' 
    }

    stages {
        stage('Checkout GitHub') {
            steps {
                // Jenkins automatically pulls the code if linked to SCM
                checkout scm
            }
        }

        stage('JUnit Testing') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Maven Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Create Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_HUB_USER}/${DOCKER_REPO}:latest ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKER_CRED_ID}", 
                                 passwordVariable: '$PRTn73367', 
                                 usernameVariable: 'naresh876')]) {
                    sh "echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin"
                    sh "docker push ${DOCKER_HUB_USER}/${DOCKER_REPO}:latest"
                }
            }
        }
    }
}
