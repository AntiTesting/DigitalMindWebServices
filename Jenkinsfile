pipeline {
    agent any
        tools {
        maven "MAVEN_3.9.5"
        jdk "JDK-17"
    }
    stages {
    stage('test') {
                steps {
                    sh 'mvn clean compile test'
                }
            }
        stage('Build Application') {
            steps {
                echo 'mvn clean install -Dmaven.test.skip=true'
            }
        }
    }
}
