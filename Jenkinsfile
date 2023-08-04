node {
	stage('Checkout') {
		git url: 'https://github.com/rabaraaaron/RegistrationClientGateway', branch: 'main'
	}
	stage('Gradle build') {
		bat: 'gradle build'
	}
}