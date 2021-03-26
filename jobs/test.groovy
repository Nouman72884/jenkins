pipelineJob('job-name') {
  definition {
    cps {
      script('''
        pipeline {
          agent { label 'ecs-plugin' }
          stages {
            stage('Stage name 1') {
              steps {
                // your logic here
              }
            }
            stage('Stage name 2') {
              steps {
                // your logic here
              }
            }
          }
        }
    ''')   
    }
  }
}