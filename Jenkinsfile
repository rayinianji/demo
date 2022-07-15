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
               sh" mvn install -Dmaven.test.skip=true "
            }

        }
        
        stage('Docker Image Build....')
        {
            steps {
                
                sh "docker build -t hellosp ."
                
            }

        }

        stage ('Push image to Docker Registry')
        {
           steps{

             withCredentials([usernamePassword(credentialsId: 'DockerId', passwordVariable: 'dockerpwd', usernameVariable: 'dockerid')])
    
              {

               sh "docker login -u ${dockerid} -p ${dockerpwd}" 
  
              }

               sh "docker tag hellosp anjidockerid/myspboot"
               sh "docker push anjidockerid/myspboot"              
 
           } 

        }
       }

       post { 
        always { 
            cleanWs()
        }
    }
       
    }

   

    

