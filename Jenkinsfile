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
        
        stage('MVN INSTALL'){
              steps{
                  sh  'mvn install'
              }
        }

        stage('MVN COMPILE'){
            steps{
                sh  'mvn compile'
            }
        }

        
        stage('Deploy Nexus'){
            steps{
                sh  'mvn  deploy'
            }
        }
        
        stage('MVN SONARQUBE'){

                steps{
                          sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
                }
          }
        
         stage('Building our image') {
               steps{
                        script {
                            dockerImage = docker.build registry + ":$BUILD_NUMBER"
                        }
               }
        }

         stage('Deploy our image') {
               steps {
                        script {
                            docker.withRegistry( '', registryCredential ) {
                                dockerImage.push()
                            }
                        }
               }
         }
        
        stage('Deploy our image') {
               steps {
                        script {
                            sh 'docker-compose up -d --build'
                            }
                        }
               }
        

        
        
        
}
}
