pipeline {
    agent any

    tools {
        jdk 'JDK 25'
    }

    stages {

        stage('Build and Test') {
            steps {
                bat 'java -version'
                bat 'mvn clean test'
            }
        }

    }
}