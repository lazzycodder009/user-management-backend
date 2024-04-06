pipeline{
    agent any
    stages{
        stage('Build'){
            steps{
                echo 'Hello!!'
                sh 'mvn clean package'
            }
        }
        stage('Test'){
            steps{
                echo 'Running Test cases!!'
                sh 'mvn test '
            }
        }
        stage('Code-Scan'){
            steps{
                 withSonarQubeEnv('SonarQubeServer') {
                 sh 'mvn clean package sonar:sonar'
              }
            }
        }
    }
}