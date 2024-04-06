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
        stage('upload artifact'){
            steps{
               nexusArtifactUploader artifacts: [[artifactId: 'entitlement-management', classifier: '', file: 'target/entitlement-management-0.0.1-SNAPSHOT.jar', type: 'jar']], credentialsId: 'sonarqube-server', groupId: 'com.user-mgmt', nexusUrl: '192.168.1.237:8070', nexusVersion: 'nexus3', protocol: 'http', repository: 'user-management-snapshot', version: '1.0-SNAPSHOT'
            }
        }
    }
}