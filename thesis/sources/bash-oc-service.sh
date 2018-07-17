# For creating configmaps
# oc create configmap == oc create secret generic
function createSecrets() {
  oc create secret generic ${SECRET_SERVIVE} \
    --from-env-file=./config.properties

  oc create secret generic ${SECRET_SERVIVE_KEYCLOAK} \
    --from-file=./keycloak.json
}

# For deleting configmaps
# oc delete configmap/config_name == oc delete secret/secret_name
function deleteSecrets() {
  oc delete secret/${SECRET_SERVIVE}
  oc delete secret/${SECRET_SERVIVE_KEYCLOAK}
}
