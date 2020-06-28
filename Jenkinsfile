pipeline {
	    options {
	        buildDiscarder(logRotator(numToKeepStr: '6'))
	    }
	    agent any 
	    stages {
	        stage ('maven clean'){
	            steps {
	                script {
	                    bat "mvn -f food-delivery-system/pom.xml clean"
	                }
	            }  
	        }
	        stage ('maven validate'){
	            steps {
	                script {
	                    bat "mvn -f food-delivery-system/pom.xml validate"
	                }
	            }  
	        }
	        stage ('maven compile'){
	            steps {
	                script {
	                    bat "mvn -f food-delivery-system/pom.xml compile"
	                }
	            }  
	        }
	        stage ('maven test'){
	            steps {
	                script {
	                    bat "mvn -f food-delivery-system/pom.xml test"
	                }
	            }  
	        }
	        stage ('maven package'){
	            steps {
	                script {
	                    bat "mvn -f food-delivery-system/pom.xml package"
	                }
	            }  
	        }
	        stage ('maven verify'){
	            steps {
	                script {
	                    bat "mvn -f food-delivery-system/pom.xml verify"
	                }
	            }  
	        }
	        stage ('maven install'){
	            steps {
	                script {
	                    bat "mvn -f food-delivery-system/pom.xml install"
	                }
	            }  
	        }
	        stage ('maven deploy'){
	            steps {
	                script {
	                    bat "mvn -f food-delivery-system/pom.xml deploy"
	                }
	            }  
	        }
	    }
	    post {
	    always {
	       archiveArtifacts artifacts: 'food-delivery-system/target/**'
	      cleanWs()
	    }
	  }
	}
