pipeline {
    agent any

    triggers {
        githubPush()
    }
    environment {
        DOCKER_IMAGE_NAME = 'scientific-calculator'
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
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', DOCKER_CRED)
                    sh "docker tag ${DOCKER_IMAGE_NAME} ${DOCKER_IMAGE_NAME}"
                    sh "docker push ${DOCKER_IMAGE_NAME}"
                }
            }
        }

        stage('Build') {
            steps {
                // Run the Maven build command; adjust if you're using another tool
                sh 'mvn clean install'
                sh 'mvn test'
            }
        }
    }
}
