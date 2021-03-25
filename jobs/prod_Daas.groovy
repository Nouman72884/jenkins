multibranchPipelineJob('Prod/Daas') {
    branchSources {
        github {
            scanCredentialsId('githiub-token')
            repository('thepillclub_bpm')
            repoOwner('ThePillClub')
            buildForkPRHead(false)
            buildForkPRMerge(false)
            buildOriginBranchWithPR(false)
            buildOriginPRHead(false)
            id('5bf59699-06f4-442f-b706-2b60f7fcd18f')
            includes('master')
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