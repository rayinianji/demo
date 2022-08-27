pipeline {
    agent any
    parameters {
        
        choice(name: 'host_name', choices: ['TVR1', 'TVR2'], description: 'choose hostname')
        choice(name: 'maven_type', choices: ['snapshots', 'releases'], description: 'choose maven type')
        string(name: 'repo_Version', defaultValue: '', description: 'Enter maven version')
        string(name: 'ear_filename', defaultValue: '', description: 'Enter ear file name')


    }
       
    tools {maven "mavan3"}    
        

    
    stages {
       
       stage("SCM check out & Build ")
       {
            steps{
                checkout scm
                sh" mvn install -Dmaven.test.skip=true "
            }
        
       }
       
       
        stage('Reading Maven perameters') {
            steps {
                
                
                echo "Maven Repo version:  ${params.repo_Version}"
                echo "EAR file name     :  ${params.ear_filename}"
               
             
            }
        }
    }
}     
