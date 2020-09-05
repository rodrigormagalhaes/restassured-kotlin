pipeline {
    agent {
        docker {
            image "adoptopenjdk/openjdk14"
        }
    }

    environment {
        gradle = "./gradlew"
    }

    stage("Test") {
        steps {
            sh "${gradle} clean test -Dprofile=qa"
        }
    }
}