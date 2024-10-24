pipeline {
    agent any

    stages {
        stage('Testing') {
            steps {
                script {
                    // Start the container to run the tests
                    sh 'sudo docker start -a happy_buck'
                    
                    // Run the test script
                    sh 'bash mvn_test_log.sh'
                    
                    // Output the last line of the logs
                    sh 'cat .mvn.logs | tail -1'
                }
            }
        }

        stage('Building') {
            steps {
                script {
                    // Start the build container
                    sh 'sudo docker start demo-api_build'
                }
            }
        }

        stage('Deploying') {
            steps {
                script {
                    // Run the production deployment script
                    sh 'sudo bash prod.sh'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
