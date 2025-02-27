pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from the configured SCM (GitHub in your case)
                checkout scm
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
