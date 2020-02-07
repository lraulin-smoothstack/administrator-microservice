node {
    stage('pull code') {
        git 'https://github.com/lraulin-smoothstack/borrower-microservice'
    }
    stage('build') {
        sh 'mvn clean package'
    }
    stage('archive') {
        archiveArtifacts 'target/*.jar'
    }
    stage('deploy') {
        sh 'java -jar target/*.jar'
    }
}