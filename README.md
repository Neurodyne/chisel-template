# Chisel-template
Your next Chisel project template

## Prerequesties 
1. Java 11 JRE and SDK 
2. SBT tool [link](https://www.scala-sbt.org/download.html) 

## Usage 

1. Instantiate the template
```bash
> mkdir my-project
> cd my-project 
> sbt new chisel-crew/chisel-crew.g8
```

2. Run tests locally 
```bash
> sbt 
> test
```

3. Add your code

4. To publish your code as a library, setup the [Bintray](https://bintray.com/) account and type 
```bash
> sbt 
> publish
```
This will publish your artifact on Bintray and it will be immediately available for reference in other projects
