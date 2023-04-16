# Berlin Clock

### Project Tools

* Java 17
* Gradle
* Spring Boot

### Run Instruction

* Navigate to Project Root
* Run `./gradlew clean build`
* Navigate to `./build/libs`
* Execute `java -jar berlinclock-0.0.1-SNAPSHOT.jar`
* An input prompt will appear in command line
* Test reports can also be accessed from `/build/reports/tests/test/index.html`

### Architecture

* Used Spring Boot for the ease of packaging the project
* `com.bashir.berlinclock.BerlinClockApplication.run()` is the main entry point and 
business flow is controlled from this part
* Conversion logics are written in the `core` while `input` and `output` packages deal with taking input and processing
combining and processing display output respectively

