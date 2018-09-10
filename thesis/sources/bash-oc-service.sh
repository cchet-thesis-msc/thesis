function createSecrets() {
  oc create secret generic ${SECRET_SERVIVE} \
    --from-env-file=./config.properties

  oc create secret generic ${SECRET_SERVIVE_KEYCLOAK} \
    --from-file=./keycloak.json
} # createSecrets

function deleteSecrets() {
  oc delete secret/${SECRET_SERVIVE}
  oc delete secret/${SECRET_SERVIVE_KEYCLOAK}
} # deleteSecrets
