pipeline {
    agent { docker { image 'adoptopenjdk/openjdk14' } }
    stages {
        stage('Test Rodrigo') {
            steps {
                echo 'Hello, JDK'
                sh 'java -version'
            }
        }

        stage('Config') {
            steps {
                def javaHome = tool 'java14'
                env.PATH = "${javaHome}/bin:${env.PATH}"
                env.JAVA_HOME = "${javaHome}"
            }
        }

        stage('Test') {
            steps {
                sh '${gradle} clean test -Dprofile=qa'
            }
        }


    }
}