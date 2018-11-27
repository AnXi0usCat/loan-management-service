curl -w "\n" \
-H "Accept: application/json" \
-F "deployment-name=loan-issue-process" \
-F "enable-duplicate-filtering=true" \
-F "deploy-changed-only=true" \
-F "loan-issue-process.bpmn=@loan-issue-process.bpmn" \
http://localhost:8080/engine-rest/deployment/create
