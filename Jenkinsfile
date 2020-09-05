pipeline {
    agent { docker { image 'adoptopenjdk/openjdk14' } }

    tools {
        gradle "GRADLE_LATEST"
    }

    stages {
        stage('Test Rodrigo') {
            steps {
                echo 'Hello, JDK'
                sh 'java -version'
            }
        }

        stage('Config') {
            steps {
                echo "PATH = ${PATH}"
            }
        }

        stage('Test') {
            steps {
                sh 'gradle --version'
                sh './gradlew clean test -Dprofile=qa'
            }
        }


    }
}