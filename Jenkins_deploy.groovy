pipeline {
    agent any
    parameters {
        
        choice(name: 'host_name', choices: ['TVR1', 'TVR2'], description: 'choose hostname')
        choice(name: 'maven_type', choices: ['snapshots', 'releases'], description: 'choose maven type')
        string(name: 'repo_Version', defaultValue: '', description: 'Enter maven version')
        string(name: 'ear_filename', defaultValue: '', description: 'Enter ear file name')


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
                  
                  def branch_name = '${env.GIT_BRANCH}'
                  echo " Branch Name         ${branch_name}"
                  echo "EAR file name  :     ${host_name}"
                  echo "EAR file name  :     ${maven_type}"
                  echo "Maven Repo version:  ${repo_Version}"
                  echo "EAR file name     :  ${ear_filename}"
                  echo "Current GIT branhc : ${env.GIT_BRANCH}"


                  
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
