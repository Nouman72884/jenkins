job("MyProject-Build") {
    description "Builds MyProject from master branch."
    steps {
        shell('echo "Hello world!"')
    }
}