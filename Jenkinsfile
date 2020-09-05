pipeline {
    agent { docker { image 'adoptopenjdk/openjdk14' } }
    stages {
        stage('Test Rodrigo') {
            steps {
                echo 'Hello, JDK'
                sh 'java -version'
            }
        }
    }
}