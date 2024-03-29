pipeline {
    agent {
        docker {
            image "adoptopenjdk/openjdk14"
        }
    }

    environment {
        gradle = "./gradlew"
    }

    stages {

        stage('Start Notification') {
            steps {
                slackSend message: "Iniciando testes automatizados API. Job: `${env.JOB_NAME}`. Branch `${env.GIT_BRANCH}` :pray:"
            }
        }

        stage('Test') {
            steps {
                sh "${gradle} clean test -Dprofile=qa"
            }
            post {
                always {
                    junit '**/test-results/test/*.xml'

                    publishHTML(target: [
                            allowMissing         : false,
                            alwaysLinkToLastBuild: false,
                            keepAll              : true,
                            reportDir            : 'build/reports/tests/test',
                            reportFiles          : 'index.html',
                            reportName           : "Tests Report"
                    ])
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }

        success {
            slackSend color:"good", message: "Testes finalizados com sucesso! <${env.BUILD_URL}> :pepeds:"
        }

        failure {
            slackSend color:"danger", message: "Testes finalizados com erro! <${env.BUILD_URL}> :rage:"
        }
    }
}