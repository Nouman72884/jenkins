def jobname = 'jenkins_master_build'
pipelineJob("wajahat") {

  logRotator {
      numToKeep(5)
  }
//   parameters {
//     gitParam('GIT_BRANCH_NAME') {
//         description 'The Git branch to checkout'
//         type 'BRANCH'
//         defaultValue 'origin/master'
//         sortMode 'ASCENDING_SMART'
//     }
//   }
  definition {
    cpsScm {
      scm {
        git {
          remote {
                url('https://github.com/Nouman72884/simple_java_app.git')
            }
            branches('master')
        }
      }
      scriptPath('Jenkinsfile')
      lightweight(false)
    }
  }
}