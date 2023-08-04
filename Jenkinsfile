node {
	stage('Checkout') {
		git url: 'https://github.com/rabaraaaron/RegistrationClientGateway'
	}
	stage('Gradle build') {
		bat: 'gradle build'
	}
}