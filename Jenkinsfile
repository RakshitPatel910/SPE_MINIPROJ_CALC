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

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'DOCKER_CRED', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                    docker login -u $DOCKER_USER -p $DOCKER_PASS
                    docker tag scientific-calculator scientific-calculator:latest
                    docker push scientific-calculator:latest
                    '''
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
