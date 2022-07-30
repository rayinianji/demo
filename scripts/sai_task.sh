#!/bin/bash
echo "Repo Check_out In process..........."
#repo-checkout branch feature/TVR-Plain-JDK8-Elastic7.5.0-JBOSS-7.3.0
sleep 5 
repo_name=$1
repo_Version=$2
ear_filename=$3
cd srv/pillar
FILE=application.sls
if [ -n "$repo_name" ] && [ -n "$repo_Version" ] && [ -n "$ear_filename" ];then
         
          if [ -f "$FILE" ]; then
    
            echo "***************** $FILE exists & Processing start here********************************"
            sed -i "/maven_repository/s/:.*$/: $repo_name/" application.sls
            sed -i "/maven_version/s/:.*$/: $repo_Version/" application.sls
            sed -i "/maven_file/s/:.*$/: $ear_filename/" application.sls
            echo "***************** application.sls file updated with appropriate values****************"

         else 

            echo "$FILE does not exist."
        
         fi
else
   echo " Please valide repo_name, repo_Version, ear_filename "
   exit
fi
