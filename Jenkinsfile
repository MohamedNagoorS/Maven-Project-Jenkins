pipeline{
  agent any
  tools{
    maven 'sonar-maven'
  }
  environment{
    JAVA_PATH="C:\\Program Files\\Java\\jdk-17\\bin"
  }
  stages{
    stage('Build'){
      dir('my-app') { // Adjust if the POM is in a subdirectory
            bat 'mvn clean package'
        }
    }
    stage('SonarQube Analysis'){
       environment{
                SONAR_TOKEN=credentials('sonarqube-token')
            }
      steps{
        bat '''
        set PATH=%JAVA_PATH%
        mvn clean verify sonar:sonar ^ 
  -Dsonar.projectKey=Maven-1 ^
  -Dsonar.projectName='Maven-1' ^
  -Dsonar.host.url=http://localhost:9000 ^
  -Dsonar.token=sqp_d2584ca45178f0ab9bc525a746f6221df0f60d77
        '''
      }
    }
  }
  post{
    success{
      echo "DONE SUCCESSFULLY"
    }
    failure{
      echo "WRONG"
    }
  }
  
}
