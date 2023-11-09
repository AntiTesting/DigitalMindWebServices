pipeline {
    agent any
        tools {
        maven "MAVEN_3.9.5"
        jdk "JDK-17"
    }
    stages {

        stage('Build Application') {
            steps {
                echo 'mvn clean install -Dmaven.test.skip=true'
            }
        }
    }
}
