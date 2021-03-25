multibranchPipelineJob('Dev/Appsmith') {
    branchSources {
        github {
            scanCredentialsId('githiub-token')
            repository('appsmith')
            repoOwner('ThePillClub')
            buildForkPRHead(false)
            buildForkPRMerge(false)
            buildOriginBranchWithPR(false)
            buildOriginPRHead(true)
            id('84486689-8471-41a7-b196-d71b3db5e373')
            includes('develop')
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
