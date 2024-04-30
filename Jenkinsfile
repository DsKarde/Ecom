pipeline{
    agent any  
    tools { 
      maven 'maven1' 
    }
    stages{
        stage('Clone Repository'){
            steps{
                script {
                // sh '''
                //     echo "commit id is ${GIT_COMMIT}"
                //     echo "current branch is  ${CURRENT_BRANCH}"
                //     echo "current hash is ${CURRENT_HASH}"
                // '''
                // sh "clone repository is sucessfull"
                }
            }
        }
        stage('Test'){
            steps {
                script{
                    echo "This is unit testing phase"
                    sh "mvn test"
                    
                }
            }            
        }
       
    }
}