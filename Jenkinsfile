pipeline {
    agent any

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
        stage('Build') {
            steps {
                // Run the Maven build command; adjust if you're using another tool
                sh 'mvn clean install'
                sh 'mvn test'
            }
        }
    }
}
