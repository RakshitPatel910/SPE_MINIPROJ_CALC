pipeline {
    agent any

    triggers {
        githubPush()
    }

    environment {
        DOCKER_IMAGE_NAME = 'rakshit910/scientific-calculator'
        GITHUB_REPO_URL = 'https://github.com/RakshitPatel910/SPE_MINIPROJ_CALC.git'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the GitHub repository
                    git branch: 'master', url: "${GITHUB_REPO_URL}"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the image with the correct tag
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', env.DOCKER_CRED) {
                        sh "docker push ${DOCKER_IMAGE_NAME}:latest"
                    }
                }
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
                sh 'mvn test'
            }
        }
    }
}
