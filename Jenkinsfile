pipeline {
    agent any
    stages{
        
        stage('Testing') {
            steps {
                script {
                    // Start the container to run the tests
                    sh 'sudo docker start -a demo-api_test'
                    
                    // Run the test script
                    sh 'sudo bash /home/profesor1/mvn_test_log.sh'
                    
                    // Output the last line of the logs
                    sh 'sudo cat /home/profesor1/.mvn.logs | tail -1'
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
                    sh 'sudo bash /home/profesor1/prod.sh'
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
