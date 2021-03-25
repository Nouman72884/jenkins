multibranchPipelineJob('Dev/Debezium') {
    branchSources {
        github {
            scanCredentialsId('githiub-token')
            repository('debezium-es')
            repoOwner('ThePillClub')
            buildForkPRHead(false)
            buildForkPRMerge(false)
            buildOriginBranchWithPR(false)
            buildOriginPRHead(true)
            excludes('master')
            id('8ab9cc7d-0014-4acf-92dc-cacefaa6faaa')
            includes('*')
        }
    }
    configure {
        it / factory(class: "org.jenkinsci.plugins.workflow.multibranch.WorkflowBranchProjectFactory") << {
            scriptPath("pipelines/dev.groovy")
        }     
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(10)
        }
    }
}


