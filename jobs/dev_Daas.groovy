multibranchPipelineJob('Dev/Daas') {
    branchSources {
        github {
            scanCredentialsId('githiub-token')
            repository('thepillclub_bpm')
            repoOwner('ThePillClub')
            buildForkPRHead(false)
            buildForkPRMerge(false)
            buildOriginBranchWithPR(false)
            buildOriginPRHead(true)
            excludes('master')
            id('2c4bae1f-f519-4b20-a017-d5fadec09eb8')
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
