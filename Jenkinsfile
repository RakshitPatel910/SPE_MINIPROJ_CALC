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

        stage('Build') {
            steps {
                sh 'mvn clean install'
                sh 'mvn test'
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

        stage('Deploy with Ansible') {
            steps {
                script {
                    withEnv(["ANSIBLE_HOST_KEY_CHECKING=False"]) {
                        ansiblePlaybook(
                            playbook: 'deploy.yml',
                            inventory: 'inventory.ini',
                            credentialsId: 'ANSIBLE_SSH_CRED'
                        )
                    }
                }
            }
        }
    }


//     post {
//         failure {
//             mail (
//                 to: 'PatelRakshit.Chandulal@iiitb.ac.in',
//                 subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
//                 body: "Check Jenkins logs: ${env.BUILD_URL}"
//             )
//         }
//     }
}
