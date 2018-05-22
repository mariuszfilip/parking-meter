pipeline {
  agent any
  stages {
    stage('clean') {
      steps {
        sh '''./gradlew clean
'''
      }
    }
    stage('test') {
      steps {
        sh '''./gradlew --refresh-dependencies


'''
        sh './gradlew test'
      }
    }
    stage('build') {
      steps {
        sh './gradlew build'
      }
    }
  }
}