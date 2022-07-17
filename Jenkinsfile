pipeline {
      agent { label 'slave-1' }

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

      }

       post { 
        always { 
            cleanWs()
        }
    }
       
    }

   

    

