pipeline {
    agent any

    tools {
     
        maven "mavan3"

    }

    stages {
        stage('SCM-Checkout') {
            steps {
                
                  git 'https://github.com/rayinianji/demo.git'
                 
            }
        }


        stage('Building Code....')
        {
            steps{

               // sh "mvn clean install"
               sh" mvn package -Dmaven.test.skip=true"
            }

        }
        
        stage('Docker Image Build....')
        {
            steps {
                
                sh "docker build -t myboot ."
                
            }

        }

        stage ('Push image to Docker Registry')
        {
           steps{

             withCredentials([usernamePassword(credentialsId: 'DockerId', passwordVariable: 'dockerpwd', usernameVariable: 'dockerid')])
    
              {

               sh "docker login -u ${dockerid} -p ${dockerpwd}" 
  
              }

               sh "docker tag mywebapp anjidockerid/myboot"
               sh "docker push anjidockerid/myboot"              
 
           } 

        }
       }

       post { 
        always { 
            cleanWs()
        }
    }
       
    }

   

    

