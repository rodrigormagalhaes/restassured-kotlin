pipeline {
    agent { docker { image 'openjdk13' } }
    stages {
        stage('Test Rodrigo') {
            steps {
                echo 'Hello, JDK'
                sh 'java -version'
            }
        }
    }
}