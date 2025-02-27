pipeline {
  agent any
  tools {
    maven 'M3' // Matches the Maven name in Jenkins' Global Tool Configuration
  }
  stages {
    stage('Checkout SCM') {
      steps {
        checkout scm // Single checkout step
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