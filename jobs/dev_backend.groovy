multibranchPipelineJob('Dev/BE') {
    branchSources {
        github {
            scanCredentialsId('githiub-token')
            repository('thepillclub_backend')
            repoOwner('ThePillClub')
            buildForkPRHead(false)
            buildForkPRMerge(false)
            buildOriginBranchWithPR(true)
            buildOriginPRHead(true)
            excludes('master')
            id('77419be0-8429-42af-82a4-a4d135b74feb')
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
