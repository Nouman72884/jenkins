multibranchPipelineJob('Prod/Debezium') {
    branchSources {
        github {
            scanCredentialsId('githiub-token')
            repository('debezium-es')
            repoOwner('ThePillClub')
            buildForkPRHead(false)
            buildForkPRMerge(false)
            buildOriginBranchWithPR(false)
            buildOriginPRHead(false)
            includes('master')
            id('de7075f8-ea32-4900-a871-2f3d429065bd')
        }
    }
    configure {
        it / factory(class: "org.jenkinsci.plugins.workflow.multibranch.WorkflowBranchProjectFactory") << {
            scriptPath("pipelines/prod.groovy")
        }     
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(10)
        }
    }
}