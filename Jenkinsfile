pipeline {
    agent any

    stages {
        stage('Compile Stage') {
            steps {
                withMaven(maven: 'maven_3_6_2') {
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Deployment Stage') {
            steps {
                withMaven(maven: 'maven_3_6_2') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}