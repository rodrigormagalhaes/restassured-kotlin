pipeline {
    agent { docker { image 'adoptopenjdk/openjdk14' } }

    tools {
        jdk 'adoptopenjdk/openjdk14'
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
                sh '${gradle} clean test -Dprofile=qa'
            }
        }


    }
}