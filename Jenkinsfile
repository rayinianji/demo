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

                sh "mvn clean package"
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

               sh "docker tag mywebapp anjidockerid/myboot" f
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

   

    

