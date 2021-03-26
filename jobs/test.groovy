pipelineJob('job-name') {
  definition {
    cps {
      script('''
        pipeline {
          agent { label 'ecs-plugin' }
          stages {
            stage('Stage name 1') {
              steps {
                script {
                    sh 'ls -la'
                }
              }
            }
          }
        }
    ''')
    sanbox()   
    }
  }
}

