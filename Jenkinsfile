pipeline {
    agent any
    
    environment {
            registry = "amirbrd/devops-project"
            registryCredential = 'dockerHub'
            dockerImage = ''
     }

    stages {

        stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'main',
                url : 'https://github.com/amir-brd/DevOps_Train.git'
            }
        }
        
         stage('MVN CLEAN'){
            steps{
                sh  'mvn clean -e'
            }
        }

        stage('MVN COMPILE'){
            steps{
                sh  'mvn compile'
            }
        }

        stage('MVN INSTALL'){
              steps{
                  sh  'mvn install'
              }
        }
        stage('Deploy Nexus'){
            steps{
                sh  'mvn  deploy'
            }
        }
        
        
        
}
}