pipeline{
  agent any
  tools{
    maven 'sonar-maven'
  }
  environment{
    JAVA_PATH="C:\\Program Files\\Java\\jdk-17\\bin"
  }
  stages{
    stage('Checkout Code') {
            steps {
                checkout scm
            }
    }
    stage('Build'){
      steps{
      dir('my-app') { // Adjust if the POM is in a subdirectory
            bat 'mvn clean package'
        }
    }
     }
    stage('SonarQube Analysis'){
   environment{
       SONAR_TOKEN=credentials('sonarqube-token')
       MAVEN_HOME="C:\\Users\\sheik\\Downloads\\apache-maven-3.9.9-bin\\apache-maven-3.9.9\\bin" // Adjust this path
       PATH="${env.PATH};${env.MAVEN_HOME}\\bin"
   }
   steps{
       bat '''
       set PATH=%JAVA_PATH%;
       set PATH=%MAVEN_HOME%\\bin;%PATH%;
       mvn clean verify sonar:sonar -Dsonar.projectKey=Maven-1 -Dsonar.projectName='Maven-1' -Dsonar.source=my-app -Dsonar.host.url=http://localhost:9000 -Dsonar.token=${SONAR_TOKEN}
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
