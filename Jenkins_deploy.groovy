pipeline {
    agent any
    parameters {
        
        string(name: 'repo_Version', defaultValue: '', description: 'Enter maven version')
        string(name: 'ear_filename', defaultValue: '', description: 'Enter ear file name ')

    }
 stages {
        stage('Reading Maven perameters') {
            steps {
                
                
                echo "Maven Repo version:  ${params.repo_Version}"
                echo "EAR file name     :  ${params.ear_filename}"
               
             
            }
        }
 


        stage('Deplyoment preparation') {
            steps{
                  
                  echo "EAR file name  :     ${HostName}"
                  echo "EAR file name  :     ${maven_type}"
                  echo "EAR file name  :     ${Branch-tag}"
                  echo "Maven Repo version:  ${repo_Version}"
                  echo "EAR file name     :  ${ear_filename}"


                  
                  /*sshagent (credentials: ['TomDev-server']) {
                             sh '''
                                
                               
                                ssh -o StrictHostKeyChecking=no -l ec2-user 43.205.117.250 cat application.sls | wc -l
                                ssh -o StrictHostKeyChecking=no -l ec2-user 43.205.117.250 sed -i "/maven_repository/s/:.*$/:${repo_name}/" application.sls
                                ssh -o StrictHostKeyChecking=no -l ec2-user 43.205.117.250 sed -i "/maven_version/s/:.*$/:${repo_Version}/" application.sls
                                ssh -o StrictHostKeyChecking=no -l ec2-user 43.205.117.250 sed -i "/maven_file/s/:.*$/:${ear_filename}/" application.sls
                                
                                
                             '''                        
                        }*/
            }
                

        }
 }
}
