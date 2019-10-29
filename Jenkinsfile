node {
    stage("Clone InvestmentAdviceServer project") {
        git 'https://github.com/preetamnp/InvestmentAdviceServer.git'
    }
    stage("Build InvestmentAdviceServer") {
        if (isUnix()) {
            sh "./mvnw clean install -DskipTests"
        } else {
            bat "./mvnw.cmd clean install -DskipTests"
        }
    }
    stage("Deploy InvestmentAdviceServer") {
        sh "echo \"killing any previous process\""
        sh "pid=\$(lsof -i:8081 -t) && if [ \"\$pid\" != \"\" ]; then kill -9 \$pid ; fi || echo \"no running process exit\" 2> /dev/null"
        withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
            sh './mvnw spring-boot:run 1>output.log 2> /dev/null &'
        }
        waitUntil {
           script {
                def r = sh script: 'curl -0 http://localhost:8081 --retry-connrefused --retry 5 --retry-delay 5 --retry-max-time 60  >/dev/null', returnStatus: true
                return (r == 0);
            }
        }
    }
    stage("clone Apiproxy") {
        git 'https://github.com/preetamnp/AdviceInvestApigee.git'
    }
    stage("deploy Apiproxy") {
        dir("${env.WORKSPACE}/AdviceInvestmentApiProxy"){
            withMaven(maven: 'maven_3_6_2') {
                sh "mvn install -P test -Dusername=preetam.potadar@cognizant.com -Dpassword='\$Gaurav19032015'"
            }
        }
    }

}