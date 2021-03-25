multibranchPipelineJob('Prod/BE') {
    branchSources {
        github {
            scanCredentialsId('githiub-token')
            repository('thepillclub_backend')
            repoOwner('ThePillClub')
            buildForkPRHead(false)
            buildForkPRMerge(false)
            buildOriginBranchWithPR(false)
            buildOriginPRHead(false)
            includes('master')
            id('cc5a4af7-b15b-4749-884d-1cafef1a7100')
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